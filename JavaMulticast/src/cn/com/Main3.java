package cn.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/*
* 接受来自组播组 all-systems.mcast.net的消息
* main3和main4是接收方和发送方
* */
public class Main3 {
    public static void main(String[] args){
        MulticastSocket ms=null;
        InetAddress group= null;
        try {
            //all-systems.mcast.net - 224.0.0.1 代表本地子网上所有系统
            group = InetAddress.getByName("all-systems.mcast.net");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {

            ms=new MulticastSocket(5000);
            ms.joinGroup(group);

            byte[] buffer=new byte[8192];

            while(true){
                DatagramPacket dp=new DatagramPacket(buffer,buffer.length);
                ms.receive(dp);
                String s=new String(dp.getData(),"8859_1");
                System.out.println(s);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ms!=null){
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
