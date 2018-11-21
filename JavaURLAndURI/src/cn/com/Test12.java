package cn.com;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
//URLEncoder的使用
public class Test12 {
    public static void main(String[] args){
        String url="http://www.baidu.com";
        String query="/&?@#";//这几个字符如果用在value中的时候需要编码
        String enconded= null;
        try {
            enconded = url+"?query="+ URLEncoder.encode(query,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(enconded);


    }
}
