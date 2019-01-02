package cn.com;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;

/*
* 使用通道实现一个UDP的Echo服务器
* */
public class Server4 {
    public static void main(String[] args){
        try {
            DatagramChannel channel = DatagramChannel.open();
            SocketAddress address= new InetSocketAddress(10001);
            channel.bind(address);
            ByteBuffer buffer=ByteBuffer.allocateDirect(1000);
            System.out.println("isConnected: "+channel.isConnected());
            while(true){
                //如果通道是阻塞的（默认值），这个方法在读取到包之前不会返回。如果通道是非阻塞
                //的，没有包可以读取的情况下这个方法会立即返回null。
                SocketAddress client=channel.receive(buffer);
                buffer.flip();
                //send()方法返回写入的字节数。这可能是要写的缓冲区中的可用字节数，也可能是0,
                //而不会是其他值。如果通道处于非阻塞模式，而且数据不能立即发送，就会返回0。否
                //则，如果通道不在非阻塞模式，send()会等待返回，直到它能发送缓冲区中的全部数
                //据。
                channel.send(buffer,client);
                buffer.clear();
                System.out.println("isConnected: "+channel.isConnected());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
