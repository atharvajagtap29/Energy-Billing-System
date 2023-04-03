package EBS;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Payment extends JFrame implements ActionListener{
	
	String meter;
	JButton back;
	
	Payment(String meter){
		
		super("Paytm Electricity Bill Payment");	
	
		this.meter = meter;
		
		JEditorPane j = new JEditorPane();
		j.setEditable(false);
		
		try {
			
			//j.setPage("https://www.airtel.in/bank/electricity-bill-payment");
			j.setPage("https://paytm.com/online-payments");
			
		} catch(Exception e) {
			j.setContentType("text/html");
			j.setText("<html>Couldnt find the page</html>");
		}
		
		JScrollPane pane = new JScrollPane(j);
		add(pane);
		
		back = new JButton("CANCEL");
		back.setBounds(640, 20, 100, 30);
		back.addActionListener(this);
		j.add(back);
		
		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setSize(800, 600);
		setLocation(400, 100);
		//setLayout(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			setVisible(false);
			new PayBill(meter);
		}
	}
	
	 public static void main(String[] args) {
		 
		new Payment("561652");
		
	}
	
}

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class Payment extends JFrame implements ActionListener {
//
//	String meter;
//	JButton back;
//
//	Payment(String meter) {
//		this.meter = meter;
//
//		JEditorPane j = new JEditorPane();
//		j.setEditable(false);
//
//		try {
//			j.setPage("https://paytm.com/online-payments");
//		} catch (Exception e) {
//			j.setContentType("text/html");
//			j.setText("<html>Could not load<html>");
//
//		}
//
//		JScrollPane pane = new JScrollPane(j);
//		add(pane);
//
//		back = new JButton("Back");
//		back.setBounds(640, 20, 80, 30);
//		back.addActionListener(this);
//		j.add(back);
//
//		
//		
//		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
//		setIconImage(i1);
//		setSize(800, 600);
//		setLocation(400, 100);
//		//setLayout(null);
//		setResizable(false);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//		
//		
////		setSize(800, 600);
////		setLocation(400, 150);
////		setVisible(true);
//
//	}
//
//	public void actionPerformed(ActionEvent ae) {
//		setVisible(false);
//		new PayBill(meter);
//	}
//
//	public static void main(String[] args) {
//		new Payment("");
//	}
//}
