package cn.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

//从socket中获取本地的连接地址和主机（服务器）的连接地址以及它们的端口
public class Main7 {
    public static void main(String[] args) throws IOException {
        Socket mySocket=new Socket();
        SocketAddress socketAddress=new InetSocketAddress("www.bit.edu.cn",80);
        mySocket.connect(socketAddress);
        InetSocketAddress localSocketAddress=(InetSocketAddress)mySocket.getLocalSocketAddress();
        InetSocketAddress remoteSocketAddress=(InetSocketAddress)mySocket.getRemoteSocketAddress();

        System.out.println("本机--------------------------------------------------------------");
        System.out.println(localSocketAddress.getAddress());
        System.out.println(localSocketAddress.getHostName());
        System.out.println(localSocketAddress.getPort());
        System.out.println();
        System.out.println("服务器--------------------------------------------------------------");
        System.out.println(remoteSocketAddress.getAddress());
        System.out.println(remoteSocketAddress.getHostName());
        System.out.println(remoteSocketAddress.getPort());

        mySocket.close();
    }
}
