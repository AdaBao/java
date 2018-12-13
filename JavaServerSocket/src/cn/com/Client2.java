package cn.com;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//测试客户端，配合Main2
public class Client2 {
    public static void main(String[] args){
        try(Socket socket=new Socket("localhost",3000)){
            InputStream in=socket.getInputStream();
            byte []b=new byte[4];
            in.read(b);
            in.close();
            for(int i=0; i<b.length; i++)
                System.out.print(b[i]+" ");
        }
        catch(IOException e){}
    }
}
