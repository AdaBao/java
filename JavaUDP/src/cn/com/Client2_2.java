package cn.com;

import java.io.IOException;
import java.net.*;

public class Client2_2 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket();
            DatagramPacket request=new DatagramPacket(new byte[25],25, InetAddress.getByName("localhost"),10001);
            socket.send(request);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
