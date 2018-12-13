package cn.com;

import java.io.*;
import java.net.Socket;

/*
* 服务器Server4的客户端
* */
public class Client4 {
    public static void main(String[] args){
        try(Socket socket=new Socket("localhost",3000)){
            OutputStream out=socket.getOutputStream();
            Writer writer=new OutputStreamWriter(out);
            writer=new BufferedWriter(writer);
            writer.write("test\r\n");
            writer.flush();
            writer.close();
        }
        catch(IOException e){}
    }
}
