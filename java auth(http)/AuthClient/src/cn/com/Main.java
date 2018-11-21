package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
//这段代码用于测试http认证方式，主函数中尝试打开一个URL，但是这个URL需要认证，此时会调用AuthWindow中的
//getPasswordAuthentication函数，这个函数会是JFrame显示出来以输入用户名和密码，这里最好是用Dialog
//而不是JFrame，因为JFrame不会阻塞调用它的线程，但是Dialog会阻塞调用它的线程，所以这里在AuthWindow中
//添加了线程的阻塞代码，以阻止getPasswordAuthentication的继续执行
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AuthWindow window = new AuthWindow();
		Authenticator.setDefault(new AuthWindow());
		try {
			URL url=new URL("http://localhost:8080/AuthProject/TestAuth");
			InputStream in=url.openStream();
			InputStreamReader isr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(isr);
			String line;
			while((line=br.readLine())!=null) {
				System.out.print(line);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);

	}

}
