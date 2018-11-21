package cn.com;

import java.net.MalformedURLException;
import java.net.URL;

//URL的形式的转换
public class Test7 {
    public static void main(String[] args){
        try {
            URL url=new URL("https://www.baidu.com");
            System.out.println(url.toString());
            System.out.println(url.toExternalForm());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
