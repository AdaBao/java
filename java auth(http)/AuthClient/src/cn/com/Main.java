package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
//��δ������ڲ���http��֤��ʽ���������г��Դ�һ��URL���������URL��Ҫ��֤����ʱ�����AuthWindow�е�
//getPasswordAuthentication�����������������JFrame��ʾ�����������û��������룬�����������Dialog
//������JFrame����ΪJFrame�����������������̣߳�����Dialog���������������̣߳�����������AuthWindow��
//������̵߳��������룬����ֹgetPasswordAuthentication�ļ���ִ��
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
