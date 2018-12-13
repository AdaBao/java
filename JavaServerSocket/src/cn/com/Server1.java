package cn.com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/*实现一个简单的时间服务器
**仅仅返回给客户端一个时间字符串
* */
public class Server1 {
    public static void main(String[] args){
        try(ServerSocket server=new ServerSocket(3000)){
            while(true){
                try(Socket connection=server.accept()){
                    System.out.println("connection from "+connection.getInetAddress());
                    Date now=new Date();
                    OutputStream out=connection.getOutputStream();
                    Writer writer= new OutputStreamWriter(out);
                    writer=new BufferedWriter(writer);
                    writer.write(now.toString()+"\r\n");
                    writer.flush();
                    writer.close();
                }
                catch(IOException e){}
            }
        }
        catch(IOException e){}
    }
}
