package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client1_1 {
    public static void main(String[] args){
        try {
            Socket socket=new Socket("localhost",3000);
            InputStream in= socket.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
