package cn.com;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//使用socket从时间服务器上获取时间
public class Main1 {
    public static void main(String[] args){
        try(Socket mySocket=new Socket("time.nist.gov",13)){
            mySocket.setSoTimeout(10000);
            StringBuilder time=new StringBuilder();
            InputStream in=mySocket.getInputStream();
            InputStreamReader inReader=new InputStreamReader(in,"ASCII");
            int c;
            while((c=inReader.read())!=-1){
                time.append((char)c);
            }
            System.out.println(time);
            inReader.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
