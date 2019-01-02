package cn.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/*
* 发送组播数据
* */
public class Main2 {
    public static void main(String[] args){
        try (MulticastSocket  ms=new MulticastSocket(4000);){
            byte[] data=new byte[10];
            InetSocketAddress socketAddress=new InetSocketAddress("experiment.mcast.net",1000);
            DatagramPacket packet=new DatagramPacket(data,data.length,socketAddress);
            //设置TTL
            ms.setTimeToLive(64);
            ms.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
