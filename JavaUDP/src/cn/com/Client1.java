package cn.com;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;

public class Client1 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket(0);
            DatagramPacket request=new DatagramPacket(new byte[1],1, InetAddress.getByName("localhost"),10001);
            DatagramPacket response=new DatagramPacket(new byte[1024],1024);
            socket.send(request);
            socket.receive(response);
            String daytime=new String(response.getData(),0,response.getLength(),"ASCII");
            System.out.println(daytime);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
