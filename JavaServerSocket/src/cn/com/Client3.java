package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//客户端，服务端是Main3
public class Client3 {
    public static void main(String[] args){
        try(Socket socket=new Socket("localhost",3000)){
            InputStream in=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(in);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String time=bufferedReader.readLine();
            bufferedReader.close();
            System.out.println(time);
        }
        catch(IOException e){}
    }
}
