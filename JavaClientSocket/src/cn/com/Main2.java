package cn.com;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//使用socket从字典服务器上获取指定词语的解释，不过这个程序存在bug，bug的原因是服务器
//的故障，所以返回的数据流是服务器故障的提示
public class Main2 {
    public static void main(String [] args){
        try {
            InetAddress address=InetAddress.getByName("dict.org");
            Socket mySocket=new Socket(address,2628);
            mySocket.setSoTimeout(30000);
            OutputStream out=mySocket.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
            bufferedWriter.write("DEFINE eng-lat people\r\n");
            bufferedWriter.flush();
            InputStream in=mySocket.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String line=null;
            while(!(line=bufferedReader.readLine()).equals(".")){
                System.out.println(line);
            }
            //输出流的关闭应该放在最后，或者使用socket所提供的关闭方式，因为如果放在getInputStream的前面，会抛Socket被关闭的异常
            bufferedWriter.close();
            bufferedReader.close();
            mySocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
