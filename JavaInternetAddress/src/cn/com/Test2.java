package cn.com;

import java.net.InetAddress;
import java.net.UnknownHostException;
//获取方法
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress address1=InetAddress.getByName("www.baiduxxx.com");
			//获得ip,会抛异常,而且之后上面这行会一直抛异常
			System.out.println(address1.getHostAddress());
			//获得主机名
			System.out.println(address1.getHostName());
			InetAddress address2=InetAddress.getByName("www.baidu.com");
			//获得ip
			System.out.println(address2.getHostAddress());
			//获得主机名
			System.out.println(address2.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
