package cn.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/*
* 发送消息给组播组 all-systems.mcast.net
* */
public class Main4 {
    public static void main(String[] args){
        try {
            MulticastSocket ms=new MulticastSocket();
            //all-systems.mcast.net - 224.0.0.1 代表本地子网上所有系统
            //个人猜测是会发送消息给本地所有的主机
            InetAddress  ia=InetAddress.getByName("all-systems.mcast.net");
            byte[] data="Here's some multicast data\r\n".getBytes();
            DatagramPacket packet=new DatagramPacket(data,data.length,ia,5000);
            ms.setTimeToLive(1);
            ms.joinGroup(ia);
            ms.send(packet);
            ms.leaveGroup(ia);
            ms.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
