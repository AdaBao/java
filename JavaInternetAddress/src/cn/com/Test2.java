package cn.com;

import java.net.InetAddress;
import java.net.UnknownHostException;
//��ȡ����
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress address1=InetAddress.getByName("www.baiduxxx.com");
			//���ip,�����쳣,����֮���������л�һֱ���쳣
			System.out.println(address1.getHostAddress());
			//���������
			System.out.println(address1.getHostName());
			InetAddress address2=InetAddress.getByName("www.baidu.com");
			//���ip
			System.out.println(address2.getHostAddress());
			//���������
			System.out.println(address2.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
