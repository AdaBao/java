package cn.com;


import javax.net.ssl.*;

import java.io.*;
import java.net.Socket;


public class Server1 {
    public static void main(String[] args){

        try {
            SSLServerSocketFactory factory= (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket= (SSLServerSocket) factory.createServerSocket(10002);
            String[] supported=serverSocket.getSupportedCipherSuites();
            serverSocket.setEnabledCipherSuites(supported);
            System.out.println("OK");

            while(true){
                Socket client=serverSocket.accept();
                InputStream in= client.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
                String line=bufferedReader.readLine();
                OutputStream out=client.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
                bufferedWriter.write(line+"\r\n");
                bufferedWriter.flush();
                client.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
