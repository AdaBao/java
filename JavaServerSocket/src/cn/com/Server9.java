package cn.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/*
*测试无参构造函数，后绑定SocketAddress
* */
public class Server9 {
    public  static void main(String[] args){
        try{
            ServerSocket server=new ServerSocket();
            System.out.println("ip: "+server.getInetAddress());
            System.out.println("port: "+server.getLocalPort());
            InetSocketAddress socketAddress=new InetSocketAddress(3000);
            server.bind(socketAddress);
            System.out.println("ip: "+server.getInetAddress());
            System.out.println("port: "+server.getLocalPort());
            server.close();
        }catch (IOException e) {}

        }
    }

