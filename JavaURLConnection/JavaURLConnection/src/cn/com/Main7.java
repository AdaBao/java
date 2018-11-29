package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

//测试Http请求的7中方法
public class Main7 {
    public static void main(String[] args){
        try {
            URL url=new URL("http://localhost:8080/WebProject/testReqM");


            //测试GET
            HttpURLConnection urlConn1=(HttpURLConnection)url.openConnection();
            InputStream in1=urlConn1.getInputStream();
            BufferedReader bufferedReader1=new BufferedReader(new InputStreamReader(in1));
            String line=bufferedReader1.readLine();
            System.out.println(line);
            bufferedReader1.close();
            System.out.println("-------------------------------------------------------");

            //测试POST
            HttpURLConnection urlConn2=(HttpURLConnection)url.openConnection();
            urlConn2.setRequestMethod("POST");
            InputStream in2=urlConn2.getInputStream();
            BufferedReader bufferedReader2=new BufferedReader(new InputStreamReader(in2));
            line=bufferedReader2.readLine();
            System.out.println(line);
            bufferedReader2.close();
            System.out.println("-------------------------------------------------------");

            //测试HEAD
            url=new URL("http://localhost:8080/WebProject/testReqM");
            HttpURLConnection urlConn3=(HttpURLConnection)url.openConnection();
            urlConn3.setRequestMethod("HEAD");
            System.out.println(urlConn3.getContentType());
            System.out.println("-------------------------------------------------------");

            //测试DELETE,似乎服务器拒绝执行
            /*url=new URL("http://localhost:8080/WebProject/delete.jsp");
            HttpURLConnection urlConn4=(HttpURLConnection)url.openConnection();
            urlConn4.setRequestMethod("DELETE");
            urlConn4.getInputStream();*/

            //PUT就不测试了，估计服务器可能又会拒绝执行

            //测试OPTIONS
            url=new URL("http://localhost:8080");
            HttpURLConnection urlConn5=(HttpURLConnection)url.openConnection();
            urlConn5.setRequestMethod("OPTIONS");
            System.out.println(urlConn5.getHeaderField("Allow"));
            System.out.println("-------------------------------------------------------");

            //测试TRACE,测试失败，似乎tomcat拒绝了这个方法
            /*url=new URL("http://localhost:8080/WebProject/testReqM");
            HttpURLConnection urlConn6=(HttpURLConnection)url.openConnection();
            urlConn6.setRequestProperty("Test","test");
            urlConn6.setRequestMethod("TRACE");
            InputStream in6=urlConn6.getInputStream();
            BufferedReader bufferedReader6=new BufferedReader(new InputStreamReader(in6));
            while((line=bufferedReader6.readLine())!=null)
                System.out.println(line);
             bufferedReader6.close();*/
            System.out.println("-------------------------------------------------------");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
