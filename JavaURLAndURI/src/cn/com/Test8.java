package cn.com;

import java.net.URI;
import java.net.URISyntaxException;

public class Test8 {
    public static void main(String [] args){
        try {
            URI uri1=new URI("https://www.baidu.com");
            System.out.println(uri1);
            System.out.println(uri1.isAbsolute());

            URI uri2=new URI("/abc");
            System.out.println(uri2);
            System.out.println(uri2.isAbsolute());

            //下面这个构造方法会报错，抛出语法错误的异常
            //URI uri3=new URI(":abc");
            //System.out.println(uri3);

            URI uri4=new URI("http","www.baidu.com","abc");
            System.out.println(uri4);

            URI uri5=new URI("http","//www.baidu.com","abc");
            System.out.println(uri5);

            URI uri6=new URI("httpp","//www.baidu.com","abc");
            System.out.println(uri6);

            URI uri7=new URI("http","//www.baidu.com",null);
            System.out.println(uri7);

            //下面这个构造方法会抛出空指针异常
            //URI uri8=new URI(null);
            //System.out.println(uri8);

            URI uri9=new URI("Tel:012-345-6789");
            System.out.println(uri9);

            //下面这个构造方法会抛语法错误的异常
            //URI uri10=new URI("http",null,null);
            //System.out.println(uri10);

            URI  uri11=new URI("http","www.baidu.com","/index.html","abc");
            System.out.println(uri11);

            //下面这个构造方法会抛语法错误的异常
            //URI uri12=new URI("http","www.baidu.com","index.html","abc");
            //System.out.println(uri12);

            URI uri12_=new URI("http",null,"/index.html",null);
            System.out.println(uri12_);

            URI uri12=new URI("http","www.baidu.com","/test/index.html","abc=abc","abc");
            System.out.println(uri12);

            URI uri13=new URI("http",null,"/test/index.html","abc=abc","abc");
            System.out.println(uri13);

            URI uri14=new URI("http","wang@aaa.org","www.baidu.com",8090,"/test/index",null,null);
            System.out.println(uri14);

            URI uri15=URI.create("http://www.baidu.com");
            System.out.println(uri15);



        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
