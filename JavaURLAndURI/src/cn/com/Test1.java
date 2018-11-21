package cn.com;

import java.net.MalformedURLException;
import java.net.URL;

//URL构造函数测试
public class Test1{
    public static void main(String[] args){
        try {
            URL url1=new URL("http://www.google.com");
            //打印结果是“http://www.google.com”
            System.out.println(url1);

            URL url2=new URL("http","www.google.com","index.html");
            //打印结果是“http://www.google.comindex.html”
            System.out.println(url2);

            URL url3=new URL("http","www.google.com","/index.html");
            //打印结果是“http://www.google.com/index.html”
            System.out.println(url3);

            URL url4=new URL("http","www.google.com",8090,"index.html");
            //打印结果是“http://www.google.com:8090index.html”
            System.out.println(url4);

            URL url5=new URL("http","www.google.com",8090,"/index.html");
            //打印结果是“http://www.google.com:8090/index.html”
            System.out.println(url5);

            URL url6=new URL("http://www.google.com/test/index.html");
            URL url7=new URL(url6,"hello.html");
            //打印结果是“http://www.google.com/test/hello.html”
            System.out.println(url7);

            URL url8=new URL(url6,"/hello.html");
            //打印结果是“http://www.google.com/hello.html”
            System.out.println(url8);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
