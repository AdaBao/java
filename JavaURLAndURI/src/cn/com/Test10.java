package cn.com;

import java.net.URI;

//解析相对URI
public class Test10 {
    public static void main(String[] args){
        URI uri1= URI.create("http://www.baidu.com");
        URI uri2=uri1.resolve("/test/index.html");
        System.out.println(uri2);

        URI uri3=URI.create("http://www.baidu.com/test/index.html");
        URI uri4=uri1.relativize(uri3);
        System.out.println(uri4);
    }
}
