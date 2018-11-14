package cn.com;

import java.net.InetAddress;
import java.net.UnknownHostException;

//获得InetAddress对象
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//由主机名得到InetAddress对象
			InetAddress address1=InetAddress.getByName("www.baidu.com");
			System.out.println("address1:"+address1);
			//由ip得到InetAddress对象
			InetAddress address2=InetAddress.getByName("13.229.188.59");
			System.out.println("address2:"+address2.getHostName()+"/"+address2.getHostAddress());
			//由主机名得到多个InetAddress对象数组,因为一个主机名可以对应多个ip
			InetAddress addressArr1[]=InetAddress.getAllByName("www.baidu.com");
			System.out.println("addressArr1:");
			for(int i=0; i<addressArr1.length; i++)
				System.out.println(addressArr1[i]);
			//得到本机的InetAddress对象
			InetAddress me=InetAddress.getLocalHost();
			System.out.println("me:"+me);
			//getByName(xxx.xxx.com.cn)会立刻请求解析域名为IP地址，而getByAddress不会立刻请求解析IP地址为域名
			byte []ip1={(byte)202,(byte)201,(byte)179,110};//int转byte会截断int
			InetAddress address3=InetAddress.getByAddress(ip1);
			byte []ip2={61,(byte)135,(byte)169,121};
			InetAddress address4=InetAddress.getByAddress("www.baidu.com", ip2);
			System.out.println("address3:"+address3);
			System.out.println("address3 hostname:"+address3.getHostName());
			System.out.println("address4:"+address4);
			//下面这行会抛异常,因为如果调用getByName创建InetAddress对象时,如果参数是主机名，就会立即进行dns解析，但是参数中的主机名
			//又不存在，所以程序抛异常
			InetAddress address5=InetAddress.getByName("www.baidxxx.com");
			//下面这两行代码不会抛异常，虽然参数中的ip是不存在的(不知道为什么，反正是这样规定的)
			InetAddress address6=InetAddress.getByName("202.117.179.110");
			address6.getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
