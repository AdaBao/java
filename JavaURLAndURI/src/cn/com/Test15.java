package cn.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
//通过GET与服务器端程序通信
public class Test15 {
    public static void main(String[] args){
        String action="http://ico.bit.edu.cn/opac/openlink.php";
        StringBuilder url=new StringBuilder(action);
        url.append("?");
        url.append("strText=java");
        url.append("&");
        url.append("strSearchType=title");

        URL u=null;
        try {
            u=new URL(url.toString());
            //System.out.println(u);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try{
            //个人认为,openStream采用什么协议取决于url的协议类型
            InputStreamReader in=new InputStreamReader(u.openStream());
            BufferedReader reader=new BufferedReader(in);
            //这里有一个奇怪的bug，按照这种方式（逐个字符）读取的流打印出来之后字符顺序是乱的（不是乱码）
            /*while((reader.read())!=-1){
                System.out.print((char)reader.read());
            }*/


           String str=null;
            while((str=reader.readLine())!=null){
                System.out.print(str);
            }
            reader.close();
        }
        catch (Exception e){}

    }
}
