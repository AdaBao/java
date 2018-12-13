package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//访问时间服务器(Server1,Server7)
public class Client1 {
    public static void main(String[] args){
        try(Socket socket=new Socket("localhost",3000)){
            InputStream in=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(in);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String time=bufferedReader.readLine();
            System.out.println(time);
            bufferedReader.close();
        }
        catch(IOException e){}
    }
}
