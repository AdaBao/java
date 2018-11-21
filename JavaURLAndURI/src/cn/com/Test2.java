package cn.com;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;
//从URL中获取数据
public class Test2 {
    public static void main(String [] args){
        try {
            URL url=new URL("https://www.baidu.com");
            InputStream in=url.openStream();
            Reader reader=new InputStreamReader(in);
            BufferedReader bufferedReader=new BufferedReader(reader);
            CharBuffer cb = CharBuffer.allocate(1000);
            while(bufferedReader.read(cb)!=-1){
                cb.flip();
                System.out.print(cb.toString());
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
