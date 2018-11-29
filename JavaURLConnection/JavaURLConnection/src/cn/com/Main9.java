package cn.com;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//测试错误条件，就是当访问的页面不存在时（404），输出错误流
public class Main9 {
    public static void main(String[] args) throws IOException {
        URL errorURL=null;
        HttpURLConnection urlConn=null;
        try {
            errorURL= errorURL = new URL("http://www.bit.edu.cn/sadf");
            urlConn=(HttpURLConnection)errorURL.openConnection();
            InputStream in=urlConn.getInputStream();
        }catch (FileNotFoundException e){
            InputStream errorIn=urlConn.getErrorStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(errorIn));
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
