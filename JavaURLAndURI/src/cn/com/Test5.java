package cn.com;

import java.net.MalformedURLException;
import java.net.URL;
//URL分解
public class Test5 {
    public static void main(String[] args){
        try {
            URL url=new URL("http://wang@www.baidu.com:8080/test/index.html?abc=abc#xxxx");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getDefaultPort());
            System.out.println(url.getFile());
            System.out.println(url.getPath());
            System.out.println(url.getRef());
            System.out.println(url.getQuery());
            System.out.println(url.getUserInfo());
            System.out.println(url.getAuthority());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
