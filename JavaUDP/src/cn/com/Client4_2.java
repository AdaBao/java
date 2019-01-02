package cn.com;

import java.io.IOException;
import java.net.*;

public class Client4_2 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket(10003);
            byte []data={4,3,2,1,0};
            SocketAddress address=new InetSocketAddress("localhost",10001);
            DatagramPacket request=new DatagramPacket(data,5,address);
            socket.send(request);
            DatagramPacket response=new DatagramPacket(new byte[5],5);
            socket.receive(response);
            byte responseData[]=response.getData();
            for(int i=0; i<responseData.length; i++)
                System.out.print(responseData[i]);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
