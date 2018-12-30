package cn.com;



import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
* 使用HttpURLConnection来访问soap服务
* */
public class Main11 {
    public static void main(String []args){
        try {
            URL url=new URL("http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx/qqCheckOnline");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();

            //设置http请求头和请求数据
            httpURLConnection.addRequestProperty("Host","www.webxml.com.cn");
            httpURLConnection.addRequestProperty("Content-Type","application/x-www-form-urlencoded");
            String requestBody="qqCode=486252827";
            httpURLConnection.addRequestProperty("Content-Length",requestBody.length()+"");

            //设置允许写出和读入
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            //发送请求
            OutputStream out=httpURLConnection.getOutputStream();
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(requestBody);
            writer.flush();

            //接收响应
            InputStream in=httpURLConnection.getInputStream();
            byte [] content=new byte[httpURLConnection.getContentLength()];
            in.read(content);
            String contentStr=new String(content);
            System.out.println(contentStr);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
