package cn.com;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
//URLDecoder的使用
public class Test13 {
    public static void main(String[] args){
        String encoded="http://www.baidu.com?query=%2F%26%3F%40%23";
        try {
            String decoded= URLDecoder.decode(encoded,"UTF-8");
            System.out.println(decoded);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            //会抛异常,因为%e无法decode
            System.out.println(URLDecoder.decode("http://www.baidu.com/test%e","UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
