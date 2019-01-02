package cn.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client3_1 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket(10002);
            DatagramPacket request1=new DatagramPacket(new byte[10],10, InetAddress.getByName("localhost"),10001);
            socket.send(request1);
            socket.send(request1);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
