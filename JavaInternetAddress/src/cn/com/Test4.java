package cn.com;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			InetAddress address=InetAddress.getByName("www.baidu.com");
			//并不能得到正确的结果，建议使用别的替代方法来测试可达性
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
