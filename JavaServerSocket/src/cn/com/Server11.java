package cn.com;

import java.io.IOException;
import java.net.ServerSocket;

/*
* 测试有ServerSocket有参构造函数
* */
public class Server11 {
    public static void main(String[] args){
        try {
            //两个参数分别表示端口号和保存入站连接请求所用的队列长度
            ServerSocket server=new ServerSocket(3000,50);
            System.out.println("ip: "+server.getInetAddress());
            System.out.println("port: "+server.getLocalPort());
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
