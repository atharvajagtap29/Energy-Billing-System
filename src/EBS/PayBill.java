package EBS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PayBill extends JFrame implements ActionListener {

	JComboBox<String> month;
	JButton back, pay;

	String meternum;

	PayBill(String meternum) {
		super("Bill Payment");

		this.meternum = meternum;

		JLabel heading = new JLabel("ELECTIRCITY BILL");
		heading.setFont(new Font("Tahoma", Font.BOLD, 22));
		heading.setBounds(120, 5, 400, 30);
		add(heading);

		JLabel lblmeterno = new JLabel("METER NUMBER");
		lblmeterno.setBounds(30, 80, 150, 20);
		add(lblmeterno);

		JLabel meterno = new JLabel();
		meterno.setBounds(220, 80, 130, 20);
		add(meterno);

		JLabel lblname = new JLabel("CUSTOMER NAME");
		lblname.setBounds(30, 140, 150, 20);
		add(lblname);

		JLabel name = new JLabel();
		name.setBounds(220, 140, 200, 20);
		add(name);

		JLabel lblmonth = new JLabel("BILL MONTH");
		lblmonth.setBounds(30, 200, 150, 20);
		add(lblmonth);

		String s[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December" };
		month = new JComboBox<String>(s);
		month.setBounds(220, 200, 150, 20);
		add(month);

		JLabel lblunits = new JLabel("UNITS CONSUMED");
		lblunits.setBounds(30, 260, 150, 20);
		add(lblunits);

		JLabel units = new JLabel();
		units.setBounds(220, 260, 130, 20);
		add(units);

		JLabel lbltotal = new JLabel("PAYABLE AMOUNT");
		lbltotal.setBounds(30, 320, 150, 20);
		add(lbltotal);

		JLabel total = new JLabel();
		total.setBounds(220, 320, 130, 20);
		add(total);

		JLabel lblstatus = new JLabel("STATUS");
		lblstatus.setBounds(30, 380, 150, 20);
		add(lblstatus);

		JLabel status = new JLabel();
		status.setBounds(220, 380, 130, 20);
		status.setForeground(Color.RED);
		add(status);

		try {

			Conn c = new Conn();
			String query = "select * from customer where meter_no = '" + meternum + "'";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				meterno.setText(meternum);
				name.setText(rs.getString("name"));
			}

			String query2 = "select * from bill where meter_no = '" + meternum + "' and month = '"
					+ month.getSelectedItem() + "'";
			rs = c.s.executeQuery(query2);

			while (rs.next()) {
				units.setText(rs.getString("units_consumed"));
				total.setText(rs.getString("total_bill"));
				status.setText(rs.getString("status"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		month.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method

				try {

					Conn c = new Conn();
					String query2 = "select * from bill where meter_no = '" + meternum + "' and month = '"
							+ month.getSelectedItem() + "'";
					ResultSet rs = c.s.executeQuery(query2);

					while (rs.next()) {
						units.setText(rs.getString("units_consumed"));
						total.setText(rs.getString("total_bill"));
						status.setText(rs.getString("status"));
					}

					String q3 = "select * from bill where meter_no = '" + meternum + "' and month = '"
							+ month.getSelectedItem() + "'";
					rs = c.s.executeQuery(q3);

//					while(rs.next()) {
//						units.setText("");
//						total.setText("");
//						status.setText("");
//						
//						units.setVisible(false);
//						total.setVisible(false);
//						status.setVisible(false);
//					}
				} catch (Exception ae) {
					ae.printStackTrace();
				}
			}
		});

		pay = new JButton("PAY");
		pay.setBackground(Color.BLACK);
		pay.setForeground(Color.WHITE);
		pay.setBounds(100, 460, 100, 25);
		pay.addActionListener(this);
		add(pay);

		back = new JButton("EXIT");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(250, 460, 100, 25);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
		Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(380, 120, 600, 300);
		add(img);

		Image im1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(im1);
		setSize(900, 600);
		setLocation(350, 100);
		setLayout(null);
		getContentPane().setBackground(new Color(249, 246, 238));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		
		if (e.getSource() == pay) {
			
			try {

				Conn c = new Conn();
				String query = "update bill set status = 'Paid' where meter_no = '" + meternum + "' and month = '"
						+ month.getSelectedItem() + "'";
				c.s.executeUpdate(query);
				
			} catch (Exception ae) {
				ae.printStackTrace();
			}

			setVisible(false);
			new Payment(meternum);

		} else if (e.getSource() == back) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new PayBill("");
	}

}
