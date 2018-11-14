package cn.com;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if(args!=null) {
				for(int i=0; i<args.length; i++)
				{
					InetAddress address=InetAddress.getByName(args[i]);
					//ÅÐ¶ÏIPµØÖ·ÀàÐÍ
					System.out.println("address "+address.getHostAddress());
					if(address.isAnyLocalAddress())
						System.out.println("This is a wildcard address");
					if(address.isLoopbackAddress())
						System.out.println("This is a loopback address");
					if(address.isLinkLocalAddress())
						System.out.println("This is a link-local address");
					if(address.isSiteLocalAddress())
						System.out.println("This is a site-local address");
					if(address.isMulticastAddress())
						System.out.println("This is a multicast address");
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
