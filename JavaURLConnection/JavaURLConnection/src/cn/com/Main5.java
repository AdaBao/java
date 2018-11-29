package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main5 {
    //测试获取Http请求所有的首部信息
    //测试Http请求的首部的配置，在http首部配置了cookie，服务器会在读取cookie之后发还给客户端
    public static void main(String[] args){
        try {
            URL url=new URL("http://localhost:8080/WebProject/testHttpHead");
            URLConnection urlConn=url.openConnection();
            urlConn.setRequestProperty("key1","v1,v2,v3,v4");
            urlConn.setRequestProperty("key2","v1,v2,v3");
            Map<String, List<String>> properties=urlConn.getRequestProperties();
            Set<Map.Entry<String,List<String>>> propertySet=properties.entrySet();
            Iterator<Map.Entry<String,List<String>>>  iterator=propertySet.iterator();
            while(iterator.hasNext()){
                Map.Entry<String,List<String>> entry=iterator.next();
                String key=entry.getKey();
                List<String> value=entry.getValue();

                System.out.print(key);
                System.out.print(":");
                for(int i=0; i<value.size(); i++)
                    System.out.print(value.get(i)+",");
                System.out.println();
            }
            urlConn.setRequestProperty("Cookie","ide1=eclipse;ide2=netbeans;ide3=idea");
            InputStream in=urlConn.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
            String line=null;
            System.out.println("---------------------------------------------------------");
            System.out.println("所有的Cookie:");
            while((line=bufferedReader.readLine())!=null)
            System.out.println(line);
            System.out.println("---------------------------------------------------------");
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
