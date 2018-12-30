package cn.com;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.nio.CharBuffer;

/*
* 使用socket来访问soap服务
* */
public class Main10 {
    public static void main(String[] args){
        try {
            Socket socket=new Socket("www.webxml.com.cn",80);

            //设置请求数据和请求头
            String requestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <qqCheckOnline xmlns=\"http://WebXml.com.cn/\">\n" +
                    "      <qqCode>486252827</qqCode>\n" +
                    "    </qqCheckOnline>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>";
            String requestHead="POST /webservices/qqOnlineWebService.asmx HTTP/1.1"+"\n"
                    +"Host: www.webxml.com.cn"+"\n"
                    +"Content-Type: text/xml; charset=utf-8"+"\n"
                    +"Content-Length: "+requestBody.length()+"\n"
                    +"SOAPAction: \"http://WebXml.com.cn/qqCheckOnline\"";
            String request=requestHead+"\n\n"+requestBody;

            //发送请求
            OutputStream out=socket.getOutputStream();
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(request);
            writer.flush();

            //接收响应
            InputStream in=socket.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            CharBuffer buffer=CharBuffer.allocate(2000);
            reader.read(buffer);
            buffer.flip();
            char [] response=new char[buffer.limit()];
            buffer.get(response,0,buffer.limit());//把buffer中的响应写入char数组中
            String responseStr=new String(response);
            System.out.println(responseStr);
            socket.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
