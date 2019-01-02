package cn.com;

import java.io.IOException;
import java.net.*;

/*
* 管理连接
* */
public class Server3 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket(10001);
            System.out.println("Remote port: "+socket.getPort());
            //connect方法可以设置当前socket只接受来自于或者发送给localhost:10002的数据报
            //别的到来的数据报会丢弃，或者如果尝试发送给别的socketAddress，会抛异常
            socket.connect(InetAddress.getByName("localhost"),10002);
            socket.send(new DatagramPacket(new byte[1],1,InetAddress.getByName("localhost"),10002));
            //socket.send(new DatagramPacket(new byte[1],1,InetAddress.getByName("localhost"),10003));
            //getPort返回的是connect方法中所设置的端口
            System.out.println("Remote port: "+socket.getPort());
            DatagramPacket request=new DatagramPacket(new byte[100],100);

            while(true){
                socket.receive(request);
                System.out.println("Data from "+request.getPort());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
