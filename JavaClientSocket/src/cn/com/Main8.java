package cn.com;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;

//测试代理的使用，代理软件是Psiphon3，Psiphon3同时支持http代理和socks代理
public class Main8 {
    public static void main(String[] args) throws IOException {
        //设置代理地址
        SocketAddress proxyAddress=new InetSocketAddress("localhost",8555);
        //实例化proxy对象
        Proxy proxy=new Proxy(Proxy.Type.HTTP,proxyAddress);
        //将代理实例作为参数传递给Socket构造函数
        Socket mySocket=new Socket(proxy);
        SocketAddress socketAddress=new InetSocketAddress("www.bbc.com",80);
        mySocket.connect(socketAddress,30000);
        OutputStream out=mySocket.getOutputStream();
        Writer writer=new OutputStreamWriter(out);
        writer=new BufferedWriter(writer);
        StringBuilder head=new StringBuilder();
        head.append("GET / HTTP/1.1\r\n");
        head.append("Host: www.bbc.com\r\n\r\n");
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
