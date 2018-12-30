package cn.com;

import java.io.*;
import java.net.Socket;

public class Client2_2 {
    public static void main(String[] args){
        try {
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append("1234567890\n");
            stringBuilder.append("1234567890\n");
            stringBuilder.append("1234567890\n");
            stringBuilder.append("1234567890\n");
            Socket socket=new Socket("localhost",10001);
            OutputStream out=socket.getOutputStream();
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(stringBuilder.toString());
            writer.flush();

            InputStream in=socket.getInputStream();
            InputStreamReader isr= new InputStreamReader(in);
            BufferedReader reader=new BufferedReader(isr);


            String line=null;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }


            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
