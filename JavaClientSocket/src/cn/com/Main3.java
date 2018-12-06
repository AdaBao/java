package cn.com;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//使用Socket模拟HTTP请求
public class Main3 {
    public static void main(String[] args){
        try {
            InetAddress address=InetAddress.getByName("localhost");
            Socket mySocket=new Socket(address,8080);
            mySocket.setSoTimeout(10000);
            OutputStream out=mySocket.getOutputStream();
            Writer writer=new OutputStreamWriter(out);
            /*
            * 这里有两点需要注意：
            * 1 需要在请求头中添加Host
            * 2 需要把请求头都放在一个字符串中，然后写。不能多次调用write去写，个人推测，应该是每一次的写入都相当于一次
            * 新的请求
            * */
            writer=new BufferedWriter(writer);
            StringBuilder head=new StringBuilder();
            head.append("GET / HTTP/1.1\r\n");
            head.append("Host: localhost:8080\r\n");
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
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
