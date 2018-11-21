package cn.com;

import java.awt.EventQueue;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthWindow extends Authenticator{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	//private String username="liferaynoteasy";
	//private char[] password={'l','i','f','e','r','a','y','i','s','e','a','s','y'};
	private String username;
	private char[] password;
	private PasswordAuthentication response;
	

	
	@Override
	 protected PasswordAuthentication getPasswordAuthentication() {
		    System.out.println(this.getRequestingPort());
	        System.out.println(this.getRequestingProtocol());
	        System.out.println(this.getRequestingScheme());
	        System.out.println(this.getRequestingSite());
	        System.out.println(this.getRequestingHost());
	        System.out.println(this.getRequestingURL());
	        System.out.println(this.getRequestingPrompt());
		    this.frame.setVisible(true); 
		  try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   // response=new PasswordAuthentication(username,password);
	        return this.response;
	        
	        
	  }
	

	/**
	 * Create the application.
	 */
	public AuthWindow() {
		initialize();
		
		//frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);

		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setBounds(39, 95, 75, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(39, 133, 75, 15);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(124, 92, 210, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 130, 210, 21);
		frame.getContentPane().add(passwordField);
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				username=textField.getText();
				password=passwordField.getPassword();
				response=new PasswordAuthentication(username,password);
				
			}
		});
		btnOk.setBounds(93, 183, 93, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(237, 183, 93, 23);
		frame.getContentPane().add(btnCancel);
	}
}
