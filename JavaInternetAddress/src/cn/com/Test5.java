package cn.com;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			InetAddress address=InetAddress.getByName("127.0.0.1");
			NetworkInterface nInterface1=NetworkInterface.getByInetAddress(address);
			System.out.println(nInterface1);
			System.out.println("-------------------------------------");
			//���ֵĸ�ʽ��ƽ̨�йأ����͵�UNIX�ϵ�������eth0��eth1��
			NetworkInterface nInterface2=NetworkInterface.getByName("eth0");
			System.out.println(nInterface2);
			System.out.println("-------------------------------------");
			//�г����������е�����ӿ�
			Enumeration<NetworkInterface> nInterfaces=NetworkInterface.getNetworkInterfaces();
			while(nInterfaces.hasMoreElements()) {
				System.out.println(nInterfaces.nextElement());
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
