package cn.com;

import java.net.URI;
import java.net.URISyntaxException;
//解析URI的各部分
public class Test9 {
    public static void main(String[] args){
        try {
            URI uri=new URI("http","wa/g","www.baidu.com",8090,"/test/index.html","abc=abc","bcd");
            System.out.println(uri);
            System.out.println(uri.getAuthority());
            System.out.println(uri.getHost());
            System.out.println(uri.getPath());
            System.out.println(uri.getPort());
            System.out.println(uri.getQuery());
            System.out.println(uri.getUserInfo());
            System.out.println(uri.getFragment());
            System.out.println(uri.getRawAuthority());
            System.out.println(uri.getRawFragment());
            System.out.println(uri.getRawPath());
            System.out.println(uri.getRawQuery());
            //带有RAW的方法返回的是编码后的形式
            System.out.println(uri.getRawSchemeSpecificPart());
            System.out.println(uri.getRawUserInfo());
            System.out.println(uri.getScheme());
            //如果是不透明的（模式特定部分未分层），返回true，否则，返回false
            System.out.println(uri.isOpaque());
            //强制解析授权机构（何时用呢？）
            System.out.println(uri.parseServerAuthority());

            URI uri1=new URI("http://wang@www.baidu.com");
            System.out.println(uri1.getUserInfo());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
