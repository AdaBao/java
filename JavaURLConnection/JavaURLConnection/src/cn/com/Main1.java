package cn.com;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Main1 {

    public static void main(String[] args) {
	// write your code here
        try {
            URL url=new URL("http://localhost:8080/WebProject/");
            URLConnection urlConn=url.openConnection();
            System.out.println("ContentType:"+urlConn.getContentType());
            System.out.println("ContentEncoding:"+urlConn.getContentEncoding());
            Date date=new Date(urlConn.getDate());
            System.out.println("Date:"+date.toGMTString());
            System.out.println("Expiration:"+urlConn.getExpiration());
            Date lastModified=new Date(urlConn.getLastModified());
            System.out.println("lastModified:"+lastModified);
            System.out.println("-------------------------------------------------------");
            Map map=urlConn.getHeaderFields();
            Set<Map.Entry<String, List<String>>> headerFields=map.entrySet();
            Iterator<Map.Entry<String, List<String>>> iterator=headerFields.iterator();

            while(iterator.hasNext()){
                Map.Entry<String, List<String>>  headerField=iterator.next();
                System.out.print(headerField.getKey()+": ");
                List<String> values=headerField.getValue();
                for(int i=0; i<values.size(); i++){
                    System.out.print(values.get(i)+" ");
                }
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
            InputStream in=urlConn.getInputStream();
            Reader reader=new InputStreamReader(in,"GBK");
            BufferedReader bufferedReader=new BufferedReader(reader);

            String line=null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
