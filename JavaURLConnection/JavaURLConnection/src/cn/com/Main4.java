package cn.com;

import jdk.internal.util.xml.impl.Input;

import javax.xml.ws.Response;
import java.io.*;
import java.net.*;
import java.util.Date;

public class Main4 {
    public static void main(String[] args){
        try {
            Authenticator.setDefault(new MyAuthenticator());
            URL url=new URL("http://localhost:8080/WebProject/testConf");
            URLConnection urlConn=url.openConnection();
            System.out.println("URL:"+urlConn.getURL());

            //----------------------------------------------------------------------------------
            //测试交互和读取
            /*urlConn.setDoInput(false);  //起作用了，URLConnection对象的getInputStream方法会抛异常
            urlConn.setAllowUserInteraction(false);//这个方法并没有起作用,不能阻止和用户的交互
            InputStream in=urlConn.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();*/
            //----------------------------------------------------------------------------------

            //----------------------------------------------------------------------------------
            //测试向服务器写数据，留待后续完善
            /*urlConn.setDoOutput(true);
            OutputStream out=urlConn.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
            bufferedWriter.write("test write");
            bufferedWriter.flush();
            bufferedWriter.close();*/
            //----------------------------------------------------------------------------------

            //----------------------------------------------------------------------------------
            //测试ifModifiedSince，但是tomcat似乎是忽略了这一字段
           /* URL url1=new URL("http://localhost:8080/WebProject/testMod");
            URLConnection urlConn1=url1.openConnection();
            Date now=new Date();
            Date modifiedSince=new Date(now.getTime()-24*3600*1000);
            urlConn.setIfModifiedSince(modifiedSince.getTime());
            InputStream in=urlConn1.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();*/
            //----------------------------------------------------------------------------------

            //----------------------------------------------------------------------------------
            //测试useCaches，useCaches不是静态变量
            /*ResponseCache.setDefault(new SimpleResponseCache());
            URL url1=new URL("http://localhost:8080/WebProject/testMod");
            URLConnection urlConn1=url1.openConnection();
            InputStream in=urlConn1.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
            System.out.println("-------------------------------------------------------");
            URL url1_=new URL("http://localhost:8080/WebProject/testMod");
            URLConnection urlConn1_=url1_.openConnection();
            urlConn1_.setUseCaches(false);
            InputStream in_=urlConn1_.getInputStream();
            BufferedReader bufferedReader_=new BufferedReader((new InputStreamReader(in_)));
            System.out.println(bufferedReader_.readLine());
            bufferedReader_.close();*/
            //----------------------------------------------------------------------------------

            //----------------------------------------------------------------------------------
            //测试timeout，timeout设置成3秒，而服务器需要至少10秒才能响应，所以抛异常了
            /*URL url2=new URL("http://localhost:8080/WebProject/testTimeout");
            URLConnection urlConn2=url2.openConnection();
            urlConn2.setReadTimeout(3000);
            Date before=new Date();
            InputStream in2=urlConn2.getInputStream();
            Date after=new Date();
            System.out.println(after.getTime()-before.getTime());
            BufferedReader bufferedReader2=new BufferedReader(new InputStreamReader(in2));
            System.out.println(bufferedReader2.readLine());
            bufferedReader2.close();*/
            //----------------------------------------------------------------------------------
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
