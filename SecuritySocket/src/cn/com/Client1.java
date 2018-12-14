package cn.com;

import javax.net.ssl.*;
import java.io.*;

public class Client1 {

    public static void main(String[] args){
        try {
            SSLSocketFactory  factory= (SSLSocketFactory) SSLSocketFactory.getDefault();


            int i=0;
            while(true){
                SSLSocket socket=(SSLSocket)factory.createSocket("localhost",10002);
                String[] supported=socket.getSupportedCipherSuites();
                socket.setEnabledCipherSuites(supported);


                OutputStream out=socket.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
                bufferedWriter.write((i++)+"\r\n");
                bufferedWriter.flush();

                InputStream in= socket.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
                String line=bufferedReader.readLine();
                System.out.println(line);

                socket.close();

                Thread.sleep(1000);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
