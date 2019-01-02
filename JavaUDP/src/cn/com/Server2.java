package cn.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
* <java网络编程>的第395页上说：当接收数据报时，其长度设置为入站数据的长度，
* 这表示如果试图在同一个DatagramPacket中接收另一个数据报，那么会限制第二个数据报的字节数
* 不能多于第一个数据报的字节数。
* 经过程序的测试，发现这句话是错误的，大概是java8应该在这里有所修改
* */
public class Server2 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket(10001);
            DatagramPacket request=new DatagramPacket(new byte[30],30);
            System.out.println("Length: "+request.getLength());

            while(true){
                socket.receive(request);
                System.out.println("Length: "+request.getLength());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
