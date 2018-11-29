package cn.com;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//测试响应码和响应消息
public class Main8 {
    public static void main(String[] args){
        try {
            URL url1=new URL("http://localhost:8080/notexist");
            HttpURLConnection urlConn1=(HttpURLConnection)url1.openConnection();
            System.out.println(urlConn1.getResponseCode());
            System.out.println(urlConn1.getResponseMessage());
            System.out.println("-------------------------------------------------------");

            URL url2=new URL("http://localhost:8080/");
            HttpURLConnection urlConn2=(HttpURLConnection)url2.openConnection();
            System.out.println(urlConn2.getResponseCode());
            System.out.println(urlConn2.getResponseMessage());
            System.out.println("-------------------------------------------------------");

            URL url3=new URL("https://www.baidu.com/");
            HttpURLConnection urlConn3=(HttpURLConnection)url3.openConnection();
            System.out.println(urlConn3.getResponseCode());
            System.out.println(urlConn3.getResponseMessage());
            System.out.println("-------------------------------------------------------");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
