package EBS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Contact extends JFrame{
	
	public Contact() {
		// TODO Auto-generated constructor stub
		super("Contact Us");
		
		JLabel heading = new JLabel("WAYS TO REACH OUR EXECUTIVES");
		heading.setBounds(10, 10, 500, 20);
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(heading);
		
		JLabel lbladdress = new JLabel("ADDRESS:");
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbladdress.setBounds(10, 60, 70, 20);
		add(lbladdress);
		
		JLabel address = new JLabel("<html>Powershell Electricity Company Main Building, Pune City<br>8th Floor, Opposite Pune Railway Station, Pune - 411001<html>");
		address.setFont(new Font("Arial", Font.PLAIN, 13));
		address.setBounds(250, 55, 2000, 40);
		add(address);
		
		JLabel lblhelplineno = new JLabel("<html>HELPLINE NUMBER<br>(09:00 AM to 07:00 PM):</html>");
		lblhelplineno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblhelplineno.setBounds(10, 120, 150, 40);
		add(lblhelplineno);
		
		JLabel helplineno = new JLabel("+91-9980387782,         +91-7789745629");
		helplineno.setBounds(250, 120, 500, 40);
		helplineno.setFont(new Font("Arial", Font.PLAIN, 13));
		add(helplineno);
		
		JLabel lblemail = new JLabel("E-MAIL ADDRESS:");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblemail.setBounds(10, 180, 150, 40);
		add(lblemail);
		
		JLabel email = new JLabel("powershellelectricity07@gmail.com");
		email.setBounds(250, 180, 500, 40);
		email.setFont(new Font("Arial", Font.PLAIN, 13));
		add(email);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icon/contact2.jpg"));
		Image i3 = i2.getImage().getScaledInstance(620, 400, Image.SCALE_DEFAULT);
		ImageIcon i4 = new ImageIcon(i3);
		JLabel finalImage = new JLabel(i4);
		finalImage.setBounds(0, 230, 620, 400);
		add(finalImage);
		
		
	
		
		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setSize(620, 610);
		setLayout(null);
		setLocation(450, 100);
		getContentPane().setBackground(new Color(249, 246, 238));
		//getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Contact();
	}
}
