package cn.com;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			InetAddress address=InetAddress.getByName("www.baidu.com");
			//�����ܵõ���ȷ�Ľ��������ʹ�ñ��������������Կɴ���
			System.out.println(address.isReachable(20));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
