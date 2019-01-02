package cn.com;

import java.io.IOException;
import java.net.*;

public class Client2_1 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket();
            DatagramPacket request=new DatagramPacket(new byte[20],20, InetAddress.getByName("localhost"),10001);
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
