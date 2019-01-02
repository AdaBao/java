package cn.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

/*
* 实现daytime服务器
* */
public class Server1 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket(10001);
            while(true){
                DatagramPacket request=new DatagramPacket(new byte[1024],1024);
                socket.receive(request);
                String daytime=new Date().toString()+"\r\n";
                byte[] responseContent=daytime.getBytes();
                DatagramPacket response=new DatagramPacket(responseContent,responseContent.length,request.getAddress(),request.getPort());
                socket.send(response);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
