package cn.com;

import java.io.IOException;
import java.net.*;

public class Client4_1 {
    public static void main(String[] args){
        try {
            DatagramSocket socket=new DatagramSocket(10002);
            byte []data={0,1,2,3,4};
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
