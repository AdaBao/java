package cn.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/*
* Java nio类型的服务器，服务器的作用是接收客户端传入的流，并原封不动的写回
* */

//服务端不能检测到客户端的关闭，不理解为什么
public class Server2 {
    public static void main(String[] args){
        try {
            ServerSocketChannel server=ServerSocketChannel.open();
            server.configureBlocking(false);
            SocketAddress serverAddress=new InetSocketAddress("localhost",10001);
            server.bind(serverAddress);

            Selector selector=Selector.open();
            //撤销注册的方法是cancel
            server.register(selector, SelectionKey.OP_ACCEPT);

            while(true){
                selector.select();
                Set<SelectionKey> selectionKeys=selector.selectedKeys();
                Iterator<SelectionKey> iterator=selectionKeys.iterator();

                while(iterator.hasNext()){
                    SelectionKey selectionKey=iterator.next();
                    //从集合中删除这个键，从而不会处理两次
                    iterator.remove();

                    try{
                        if(selectionKey.isAcceptable()){
                            ServerSocketChannel serverSocketChannel=(ServerSocketChannel) selectionKey.channel();
                            SocketChannel socketChannel=serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            SelectionKey selectionKey1=socketChannel.register(selector,SelectionKey.OP_READ|SelectionKey.OP_WRITE);
                            ByteBuffer buffer=ByteBuffer.allocate(10);
                            selectionKey1.attach(buffer);
                        }
                        if(selectionKey.isReadable()){
                            SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                            ByteBuffer buffer=(ByteBuffer)selectionKey.attachment();
                            InetSocketAddress client= (InetSocketAddress) socketChannel.getRemoteAddress();
                            int port=client.getPort();
                            System.out.println("Read data from "+port+"...");
                            socketChannel.read(buffer);

                        }
                        if(selectionKey.isWritable()){
                            SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                            ByteBuffer buffer=(ByteBuffer)selectionKey.attachment();
                            InetSocketAddress client= (InetSocketAddress) socketChannel.getRemoteAddress();
                            int port=client.getPort();
                            System.out.println("Write data to "+port+"...");
                            buffer.flip();
                            socketChannel.write(buffer);
                            //缓冲区的数据不能保证一次就全部写出，所以需要压缩缓冲区，使缓冲区
                            //未被写出的数据移到缓冲区的头部，缓冲区的position的位置在为写出数据
                            //之后，这样，下次读入的数据就不会覆盖未写出的数据
                            buffer.compact();
                        }
                    }
                    catch(IOException ex){
                        selectionKey.cancel();
                        selectionKey.channel().close();
                        System.out.println("One connection is closed");
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
