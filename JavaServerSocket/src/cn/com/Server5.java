package cn.com;




import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server5 {

    public static void main(String[] args){
        boolean tag=true;
        try {
            Selector selector;

            ServerSocketChannel serverChannel1=ServerSocketChannel.open();
            ServerSocketChannel serverChannel2=ServerSocketChannel.open();

            InetSocketAddress socketAddress1=new InetSocketAddress(3000);
            InetSocketAddress socketAddress2=new InetSocketAddress(3001);

            serverChannel1.bind(socketAddress1);
            serverChannel2.bind(socketAddress2);

            serverChannel1.configureBlocking(false);
            serverChannel2.configureBlocking(false);

            //selector同时监视ServerSocketChannel和SocketChannel的状态
            selector=Selector.open();

            //当channel注册到selector之后，selector会检测和channel关联的socket的状态
            //下面的代码中，参数ops是OP_ACCEPT，selector会检测ServerSocket是否接收
            //就绪
            serverChannel1.register(selector, SelectionKey.OP_ACCEPT);
            serverChannel2.register(selector,SelectionKey.OP_ACCEPT);

            while(true){
                //当服务端没有收到连接请求时，select方法会阻塞
                //ServerSocketChannel是用来监听端口的，相当于ServerSocket类
                //SocketChannel相对于Socket类
                //select方法用来选择准备进行I/O操作的通道所对应的key
                //每个SelectionKey其实是一个ServerSocketChannel和SocketChannel的组合
                selector.select();
                Set<SelectionKey> selectionKeys=selector.selectedKeys();
                Iterator<SelectionKey> iterator=selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey selectionKey=iterator.next();
                    //原因不明，如果没有remove，selectionKeys集合会越来越大
                    iterator.remove();
                    if(selectionKey.isAcceptable()){
                        ServerSocketChannel channel= (ServerSocketChannel) selectionKey.channel();
                        SocketChannel client=channel.accept();
                        client.configureBlocking(false);
                        SelectionKey key=client.register(selector,SelectionKey.OP_READ|SelectionKey.OP_WRITE);
                        ByteBuffer buffer=ByteBuffer.allocate(100);
                        key.attach(buffer);
                    }

                    //当position等于0时，isReadable返回false
                    else if(selectionKey.isReadable()){
                        SocketChannel client= (SocketChannel) selectionKey.channel();
                        ByteBuffer input= (ByteBuffer) selectionKey.attachment();
                        client.read(input);
                        int bufferSize=input.position();
                        input.flip();
                        byte data[]=new byte[bufferSize];
                        input.get(data);
                        String str=new String(data);
                        System.out.println("data:"+str);
                        input.flip();
                        client.write(input);
                        input.clear();
                    }
                    else if(selectionKey.isWritable()&&tag){
                        SocketChannel client= (SocketChannel) selectionKey.channel();
                        ByteBuffer output= (ByteBuffer) selectionKey.attachment();
                        output.put((byte) 65);
                        output.flip();
                        client.write(output);
                        output.clear();
                        tag=false;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
