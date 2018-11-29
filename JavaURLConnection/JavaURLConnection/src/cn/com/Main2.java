package cn.com;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main2 {
    public static void main(String[] args){
        try {
            URL url=new URL("http://localhost:8080/tomcat.png");
            URLConnection urlConn=url.openConnection();
            int contentLength=urlConn.getContentLength();
            int offset=0;
            byte []data=new byte[contentLength];

            InputStream in=urlConn.getInputStream();
            while(offset<contentLength){
                int byteNum=in.read(data,offset,contentLength-offset);
                if(byteNum==-1)
                    break;
                offset=offset+byteNum;
            }

            String filename=url.getFile();
            filename=filename.substring(filename.lastIndexOf("/"));

            //默认放在c盘下
            File file=new File(filename);

            OutputStream out=new FileOutputStream(file);
            System.out.println(file.getName());

            out.write(data);
            out.flush();
            out.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
