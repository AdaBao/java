package cn.com;



import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

//测试向服务器写入数据
public class Main6 {
    public static void main(String[] args){
        try {
            URL url=new URL("http://localhost:8080/WebProject/testWrite");
            URLConnection urlConn=url.openConnection();
            //Permission代表上面的URL所具有的权限
            Permission permission=urlConn.getPermission();
            System.out.println(permission.getName());
            System.out.println(permission.getActions());
            urlConn.setDoOutput(true);
            urlConn.connect();
            OutputStream out=urlConn.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
            bufferedWriter.write("hello world\r\n");
            bufferedWriter.flush();
            bufferedWriter.close();

            //必须要获得InputStream，否则OutputStream的数据不会被发送给服务器
            InputStream in=urlConn.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
            String line=bufferedReader.readLine();
            System.out.print(line);
            bufferedReader.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
