package cn.com;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Main5 {
    public static void main(String[] args){
        try {
            //下面这行代码是错误的，网络接口的名字和主机名不是同一个概念
            //InetAddress myAddress=InetAddress.getByName("wlan0");

            InetAddress myAddress=InetAddress.getByName("10.108.16.201");
            System.out.println(myAddress);
            //后两个参与指定从本机的哪个接口和端口连接
            Socket mySocket=new Socket("www.bit.edu.cn",80,myAddress,10000);
            OutputStream out=mySocket.getOutputStream();
            Writer writer=new OutputStreamWriter(out);
            writer=new BufferedWriter(writer);
            StringBuilder head=new StringBuilder();
            head.append("GET / HTTP/1.1\r\n");
            head.append("Host: www.bit.edu.cn\r\n");
            head.append("\r\n");
            writer.write(head.toString());
            writer.flush();
            mySocket.shutdownOutput();
            InputStream in=mySocket.getInputStream();
            Reader reader=new InputStreamReader(in);
            reader=new BufferedReader(reader);
            String line;
            while((line=((BufferedReader) reader).readLine())!=null){
                System.out.println(line);
            }
            mySocket.shutdownInput();
            mySocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
