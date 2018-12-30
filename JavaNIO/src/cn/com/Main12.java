package cn.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/*
* 测试异步通道，下面代码中，the other work不需要等待网络连接的结束
*  */
public class Main12 {
    public static void main(String[] args){
        try {
            SocketAddress socketAddress=new InetSocketAddress("time.nist.gov",13);
            AsynchronousSocketChannel client=AsynchronousSocketChannel.open();
            Future<Void> connected=client.connect(socketAddress);
            ByteBuffer buffer=ByteBuffer.allocate(100);
            //等待连接完成
            connected.get();
            //从连接读取
            Future<Integer> future=client.read(buffer);

            //做其他工作
            System.out.println("The other work is in process");

            //等待读取完成
            System.out.println(future.get());

            buffer.flip();
            for(int i=0; i<buffer.limit(); i++)
                System.out.print((char)buffer.get());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
