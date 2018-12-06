package cn.com;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

//获取网络接口
public class Main4 {
    public static void main(String[] args){
        try {
            //获取当前机器上所有的网络接口
            Enumeration<NetworkInterface> interfaceList=NetworkInterface.getNetworkInterfaces();
            while(interfaceList.hasMoreElements()){
                System.out.println(interfaceList.nextElement());
            }
            //获取指定IP所绑定的网络接口，当然必须是本地的IP
            InetAddress address=InetAddress.getByName("10.108.16.201");
            System.out.println(NetworkInterface.getByInetAddress(address));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
