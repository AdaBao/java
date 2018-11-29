package cn.com;

import javax.swing.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Scanner;

public class MyAuthenticator extends Authenticator {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("您所访问的网站需要验证:");
        System.out.print("请输入用户名:");
        String username=scanner.nextLine();
        System.out.print("请输入密码:");
        String password=scanner.nextLine();
        return new PasswordAuthentication(username,password.toCharArray());
    }
}
