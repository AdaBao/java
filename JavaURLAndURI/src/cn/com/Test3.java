package cn.com;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//从URL中获取数据
public class Test3 {
    public static void main(String[] args){
        try {
            URL url1=new URL("http://cs.bit.edu.cn/images/content/2018-06/20180625073248415559.JPG");
            Object o= url1.getContent();
            System.out.println(o.getClass().getName());

            URL url2=new URL("http://www.baidu.com");
            Object o2=url2.getContent();
            System.out.println(o2.getClass().getName());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
