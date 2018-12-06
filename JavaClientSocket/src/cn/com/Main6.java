package cn.com;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

//测试socket的无参构造方法
public class Main6 {
    public static void main(String[] args) throws IOException {
        Socket mySocket=new Socket();
        SocketAddress socketAddress=new InetSocketAddress("www.bit.edu.cn",80);
        //无参构造方法不会连接主机，调用下面的connect方法时才会连接主机
        mySocket.connect(socketAddress,10000);
        OutputStream out=mySocket.getOutputStream();
        Writer writer=new OutputStreamWriter(out);
        writer=new BufferedWriter(writer);
        StringBuilder head=new StringBuilder();
        head.append("GET / HTTP/1.1\r\n");//不要多加空格
        head.append("Host: www.bit.edu.cn\r\n\r\n");
        writer.write(head.toString());
        writer.flush();
        InputStream in=mySocket.getInputStream();
        Reader reader=new InputStreamReader(in);
        reader=new BufferedReader(reader);
        String line;
        while((line=((BufferedReader) reader).readLine())!=null){
            System.out.println(line);
        }
        mySocket.close();
    }
}
