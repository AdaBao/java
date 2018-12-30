package cn.com;

import java.io.*;
import java.net.*;


public class Main9 {
    public static void main(String[] args){
        try {
            Socket socket=new Socket("www.webxml.com.cn",80);
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

            OutputStream out=socket.getOutputStream();
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(request);
            writer.flush();

            InputStream in=socket.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            int data=-1;
            while((data=reader.read())!=-1){
                System.out.print((char)data);
            }

            socket.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
