package cn.com;

import java.io.IOException;
import java.net.ServerSocket;

/*
* 测试构造函数
* */
public class Server8 {
    public static void main(String[] args){
        try {
            //端口设置为0，会随机分配一个端口给ServerSocket
            ServerSocket server=new ServerSocket(0);
            //未设置ip，获得的ip是0.0.0.0，表示绑定所有接口
            //因为每个电脑可以有多个ip，所以上面的ServerSocket
            //可以监听所有经过指定端口的ip
            System.out.println("ip: "+server.getInetAddress());
            //随机分配的端口
            System.out.println("port: "+server.getLocalPort());
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
