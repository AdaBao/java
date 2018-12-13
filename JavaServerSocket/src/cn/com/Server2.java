package cn.com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/*
* 这段程序无实际意义，仅仅实现了一个服务端
* 服务端向客户端发送二进制数据，所以需要用到
* byte数组类型。
* */
public class Server2 {
    public static void main(String[] args){

        try(ServerSocket server=new ServerSocket(3000)){
            while(true){
                try(Socket connection=server.accept()){
                   OutputStream out=connection.getOutputStream();
                   byte[] b={1,2,3,4};
                   out.write(b);
                   out.flush();
                   out.close();
                }
                catch(IOException e){}
            }
        }
        catch(IOException e){}
    }
}
