package cn.com;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/*
*测试ServerSocket的有参构造函数
* */
public class Server12 {
    public static void main(String[] args){
        try {
            InetAddress address=InetAddress.getByName("localhost");
            ServerSocket server=new ServerSocket(3000,50,address);
            System.out.println("ip: "+server.getInetAddress());
            System.out.println("port: "+server.getLocalPort());
            System.out.println(server);
            server.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
