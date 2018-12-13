package cn.com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
* 服务器接收来自服务端的字符串，并打印
* */
public class Server4 {
    public static void main(String[] args){
        try(ServerSocket server=new ServerSocket(3000)){
            while(true){
                try(Socket connection=server.accept()){
                    InputStream in=connection.getInputStream();
                    Reader reader=new InputStreamReader(in);
                    reader=new BufferedReader(reader);
                    String str=((BufferedReader) reader).readLine();
                    System.out.println(str);
                    reader.close();
                }
                catch(IOException e){}
            }
        }
        catch(IOException e){}
    }
}
