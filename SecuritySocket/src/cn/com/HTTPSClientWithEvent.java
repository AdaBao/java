package cn.com;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

/*
* 测试事件处理器，当握手成功时，会提示成功，并打印所使用的密码组
* */
public class HTTPSClientWithEvent {
    public static void main(String[] args){
        int port=443;
        String host="www.baidu.com";
        //获得sslsocket工厂实例
        SSLSocketFactory factory=(SSLSocketFactory)SSLSocketFactory.getDefault();
        SSLSocket socket=null;
        try{
            //用工厂实例去创建SSLSocket
            socket=(SSLSocket)factory.createSocket(host,port);
            //获得socket所支持的密码组
            String[] supported=socket.getSupportedCipherSuites();
            //设置允许socket所使用的密码组
            socket.setEnabledCipherSuites(supported);
            //增加事件处理器
            socket.addHandshakeCompletedListener(new HandShakeCompletedImpl());
            Writer out=new OutputStreamWriter(socket.getOutputStream(),"UTF-8");
            //https在GET行中需要完全URL
            out.write("GET https://"+host+"/ HTTP/1.1\r\n");
            out.write("Host: "+host+"\r\n");
            out.write("\r\n");
            out.flush();

            //读取响应
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line=null;
            while((line=in.readLine())!=null){
                System.out.println(line);
            }

            in.close();

        }
        catch(IOException ex){}
        finally {
            try{if(socket!=null) socket.close();}
            catch (IOException e){}
        }

    }
}
