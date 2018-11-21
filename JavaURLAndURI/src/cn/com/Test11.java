package cn.com;

import java.net.URI;

public class Test11 {
    public static void main(String[] args){
        URI uri1= URI.create("http://www.baidu.com");
        URI uri2= URI.create("HTTP://www.baidu.COM");
        System.out.println(uri1.equals(uri2));

        URI uri3= URI.create("http://www.baidu.com");
        URI uri4=URI.create("http://www.baidu.com");
        System.out.println(uri3.equals(uri4));

        URI uri5=URI.create("http://wang@www.baidu.com");
        URI uri6=URI.create("http://WANG@www.baidu.com");
        System.out.println(uri5.equals(uri6));

        System.out.println(uri5.compareTo(uri6));

    }
}
