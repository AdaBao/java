package cn.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/*
* 测试组播，加入组播组并接受数据。不过程序没有输出，组播需要路由器支持
* 组播，所以本章的代码应该都不能运行得到正确结果
* */
public class Main1 {
    public static void main(String[] args){
        //打开一个组播socket，这个socket是DatagramSocket的子类
        try( MulticastSocket ms=new MulticastSocket(4000)) {
            //组播地址
            InetAddress ia=InetAddress.getByName("224.2.2.2");
            //加入组播组
            ms.joinGroup(ia);
            byte[] buffer=new byte[8192];
            //循环接受数据
            while(true){
                DatagramPacket dp=new DatagramPacket(buffer,buffer.length);
                ms.receive(dp);
                String s=new String(dp.getData(),"8859_1");
                System.out.println(s);

                if(s==null) break;
            }
            //离开组播组
            ms.leaveGroup(ia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
