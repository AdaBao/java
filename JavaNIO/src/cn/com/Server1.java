package cn.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/*
* Java nio类型服务器，向客户端发送26个英文字母
* */
public class Server1 {
    public static void main(String[] args){
        try {
            ServerSocketChannel ssc=ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(3000));
            ssc.configureBlocking(false);
            Selector selector=Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            while(true){
                selector.select();
                Set<SelectionKey>  keys=selector.selectedKeys();
                Iterator<SelectionKey> iterator=keys.iterator();

                while(iterator.hasNext()){
                    SelectionKey key=iterator.next();
                    iterator.remove();
                    if(key.isAcceptable()){
                       ServerSocketChannel serverChannel=(ServerSocketChannel)key.channel();
                       SocketChannel socketChannel=serverChannel.accept();
                       socketChannel.configureBlocking(false);
                       SelectionKey key2=socketChannel.register(selector,SelectionKey.OP_WRITE);
                       ByteBuffer buffer=ByteBuffer.allocate(8);
                       buffer.put("abcdef".getBytes());
                       buffer.put("\r".getBytes());
                       buffer.put("\n".getBytes());
                       buffer.flip();
                       key2.attach(buffer);
                    }else if(key.isWritable()){
                        ByteBuffer buffer= (ByteBuffer) key.attachment();
                        SocketChannel client= (SocketChannel) key.channel();
                        if(!buffer.hasRemaining()) {
                            buffer.rewind();
                            byte first = buffer.get();
                            buffer.rewind();
                            first= (byte) (first+6);
                            if(first+6>'z')
                            {
                                key.cancel();
                                key.channel().close();
                                break;
                            }
                            for(byte i=first; i<first+6; i++){
                                buffer.put(i);
                            }
                            buffer.put((byte)'\r');
                            buffer.put((byte)'\n');
                            buffer.flip();
                        }
                        client.write(buffer);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
