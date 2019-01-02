package cn.com;

import java.net.DatagramSocket;
import java.net.SocketException;

/*
* 查找正在被使用的UDP端口
* */
public class Main2 {
    public static void main(String[] args){
        for(int i=1024; i<=65535;i++){
            DatagramSocket socket= null;
            try {
                socket = new DatagramSocket(i);
                socket.close();
            } catch (SocketException e) {
                System.out.println("Socket"+" "+i+" "+"is being used");
            }
        }
    }
}
