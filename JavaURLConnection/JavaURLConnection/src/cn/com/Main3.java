package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

//测试Web缓存
public class Main3 {
    public static void main(String[] args){
        ResponseCache.setDefault(new SimpleResponseCache());

        try {
            URL url=new URL("http://localhost:8080/WebProject/");
            URLConnection urlConn=url.openConnection();
            InputStream in=urlConn.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in,"GBK"));
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();

            //-----------------------------------------------------------------------------
            //第二次打开一样的url，验证是否已经缓存

            URL url1=new URL("http://localhost:8080/WebProject/");
            URLConnection urlConn1=url1.openConnection();
            InputStream in1=urlConn1.getInputStream();
            BufferedReader bufferedReader1=new BufferedReader(new InputStreamReader(in1,"GBK"));
            String line1=null;
            while((line1=bufferedReader1.readLine())!=null){
                System.out.println(line1);
            }
            bufferedReader1.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
