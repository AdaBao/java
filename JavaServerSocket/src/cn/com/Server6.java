package cn.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

/*
*测试isClosed和isBound方法，isClosed表示ServerSocket是否处于关闭状态，isBound表示
* ServerSocket是否曾经被绑定过端口
 */
public class Server6 {
    public static void main(String[] args){
        try{
            ServerSocket server=new ServerSocket();
            if(server.isBound()){System.out.println("ServerSocket被绑定到过端口");}
            else{System.out.println("ServerSocket从未被绑定过端口");}
            if(server.isClosed()){System.out.println("ServerSocket处于关闭状态");}
            else{System.out.println("ServerSocket处于开启状态");}

            SocketAddress  address=new InetSocketAddress("localhost",3000);
            server.bind(address);
            if(server.isBound()){System.out.println("ServerSocket被绑定到过端口");}
            else{System.out.println("ServerSocket从未被绑定过端口");}
            if(server.isClosed()){System.out.println("ServerSocket处于关闭状态");}
            else{System.out.println("ServerSocket处于开启状态");}

            server.close();
            if(server.isBound()){System.out.println("ServerSocket被绑定到过端口");}
            else{System.out.println("ServerSocket从未被绑定过端口");}
            if(server.isClosed()){System.out.println("ServerSocket处于关闭状态");}
            else{System.out.println("ServerSocket处于开启状态");}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
