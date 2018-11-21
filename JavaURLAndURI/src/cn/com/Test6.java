package cn.com;

import java.net.MalformedURLException;
import java.net.URL;

public class Test6 {
    public static void main(String[] args){
        try {
            //下面这两个URL是相等的，因为URL会尝试去解析主机名，然后得到了相同的IP
            URL url1=new URL("http://www.cnki.com/");
            URL url2=new URL("http://cnki.com/");
            System.out.println(url1.equals(url2));

            //下面这两个URL不相等，通过是使用ping命令发现，这两个URL的IP并不相同
            URL url3=new URL("https://www.baidu.com/");
            URL url4=new URL("https://baidu.com/");
            System.out.println(url3.equals(url4));

            //下面这两个URL是相等的，并且在判等的时候阻塞了一段时间，因为需要解析域名
            //不过解析失败，之后通过判断URL字符串的相等进而判断两个URL是相等的
            URL url5=new URL("http://www.baiduxxx.com");
            URL url6=new URL("http://www.baiduxxx.com");
            System.out.println(url5.equals(url6));

            //虽然下面两个URL的主机名是相同的，但是两者的查询字符串是不等的，所以两个URL是不相等的
            URL url7=new URL("https://www.baidu.com?abc=abc");
            URL url8=new URL("https://www.baidu.com?bcd=bcd");
            System.out.println(url7.equals(url8));

            //下面两个URL是相同的，虽然URL是不存在的，所以说两个URL之间的判等要综合考虑URL字符串和解析结果
            URL url9=new URL("https://www.baiduxyz.com");
            URL url10=new URL("https://baiduxyz.com");
            System.out.println(url9.equals(url10));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
