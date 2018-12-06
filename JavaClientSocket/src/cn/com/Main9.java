package cn.com;

import java.io.IOException;
import java.net.Socket;
//测试获取Socket信息
public class Main9 {
    public static void main(String[] args){
        try {
            Socket mySocket1=new Socket("www.baidu.com",80);
            System.out.println("mySocket1是否连接过服务器:"+mySocket1.isConnected());//注意，isConnected指示的是是否连接过服务器，不是连接状态
            System.out.println("mySocket1是否绑定到了本地的出站端口:"+mySocket1.isBound());
            System.out.println("mySocket1是否关闭:"+mySocket1.isClosed());
            System.out.println("mySocket1的本地地址:"+mySocket1.getLocalAddress());
            System.out.println("mySocket1的本地端口:"+mySocket1.getLocalPort());
            System.out.println("mySocket1的服务器地址:"+mySocket1.getInetAddress());
            System.out.println("mySocket1的服务器端口:"+mySocket1.getPort());
            mySocket1.close();
            System.out.println("mySocket1是否关闭:"+mySocket1.isClosed());
            System.out.println("--------------------------------------------------");
            Socket mySocket2=new Socket();
            System.out.println("mySocket2是否连接过服务器:"+mySocket2.isConnected());//注意，isConnected指示的是是否连接过服务器，不是连接状态
            System.out.println("mySocket2是否绑定到了本地的出站端口:"+mySocket2.isBound());
            System.out.println("mySocket2是否关闭:"+mySocket2.isClosed());
            System.out.println("mySocket2的本地地址:"+mySocket2.getLocalAddress());
            System.out.println("mySocket2的本地端口:"+mySocket2.getLocalPort());
            System.out.println("mySocket2的服务器地址:"+mySocket2.getInetAddress());
            System.out.println("mySocket2的服务器端口:"+mySocket2.getPort());
            mySocket2.close();
            System.out.println("mySocket2是否关闭:"+mySocket2.isClosed());
            System.out.println("--------------------------------------------------");
            System.out.println("mySocket1.toString:  "+mySocket1);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
