package cn.com;

import java.net.InetAddress;
import java.net.UnknownHostException;

//���InetAddress����
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//���������õ�InetAddress����
			InetAddress address1=InetAddress.getByName("www.baidu.com");
			System.out.println("address1:"+address1);
			//��ip�õ�InetAddress����
			InetAddress address2=InetAddress.getByName("13.229.188.59");
			System.out.println("address2:"+address2.getHostName()+"/"+address2.getHostAddress());
			//���������õ����InetAddress��������,��Ϊһ�����������Զ�Ӧ���ip
			InetAddress addressArr1[]=InetAddress.getAllByName("www.baidu.com");
			System.out.println("addressArr1:");
			for(int i=0; i<addressArr1.length; i++)
				System.out.println(addressArr1[i]);
			//�õ�������InetAddress����
			InetAddress me=InetAddress.getLocalHost();
			System.out.println("me:"+me);
			//getByName(xxx.xxx.com.cn)�����������������ΪIP��ַ����getByAddress���������������IP��ַΪ����
			byte []ip1={(byte)202,(byte)201,(byte)179,110};//intתbyte��ض�int
			InetAddress address3=InetAddress.getByAddress(ip1);
			byte []ip2={61,(byte)135,(byte)169,121};
			InetAddress address4=InetAddress.getByAddress("www.baidu.com", ip2);
			System.out.println("address3:"+address3);
			System.out.println("address3 hostname:"+address3.getHostName());
			System.out.println("address4:"+address4);
			//�������л����쳣,��Ϊ�������getByName����InetAddress����ʱ,������������������ͻ���������dns���������ǲ����е�������
			//�ֲ����ڣ����Գ������쳣
			InetAddress address5=InetAddress.getByName("www.baidxxx.com");
			//���������д��벻�����쳣����Ȼ�����е�ip�ǲ����ڵ�(��֪��Ϊʲô�������������涨��)
			InetAddress address6=InetAddress.getByName("202.117.179.110");
			address6.getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
