package EBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.*;

public class CalculateBill extends JFrame implements ActionListener {

	private JTextField units;
	JButton next, cancel;
	JLabel lblConsumername, lbladdress;

	Choice meterno;
	JComboBox<String> month;

	// for calculating bill
	static double cost_per_unit = 9.0;
	static double meter_rent = 47.2;
	static double service_charge = 22.0;
	static double service_tax = 57.4;
	static double swaach_bharat_yojna = 6.7;
	static double fixed_tax = 18.0;

	public CalculateBill() { // only admin can create a new customer. only if admin has created a new
								// customer, that customer is allowed to sign up and create his account
		super("Bill Calculation");

		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(172, 216, 230));
		add(p);

		JLabel heading = new JLabel("CALCULATE BILL");
		heading.setFont(new Font("Tahoma", Font.BOLD, 22));
		heading.setBounds(170, 10, 300, 25);
		p.add(heading);

		// getting consumer meter number
		JLabel lblname = new JLabel("METER NUMBER");
		lblname.setBounds(100, 80, 130, 20);
		p.add(lblname);

		meterno = new Choice();
		try {

			Conn c = new Conn();
			String query = "select * from customer";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				meterno.add(rs.getString("meter_no")); // a full row is stored in rs. by getString method we specify the
														// column name
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		meterno.setBounds(290, 80, 200, 20);
		p.add(meterno);

		// setting consumer name and address based on meter number
		JLabel name = new JLabel("CONSUMER NAME");
		name.setBounds(100, 120, 130, 20);
		p.add(name);

		lblConsumername = new JLabel();
		lblConsumername.setBounds(290, 120, 130, 20);
		p.add(lblConsumername);

		JLabel address = new JLabel("ADDRESS");
		address.setBounds(100, 160, 130, 20);
		p.add(address);

		lbladdress = new JLabel();
		lbladdress.setBounds(290, 160, 200, 20);
		p.add(lbladdress);

		try {

			Conn c = new Conn();
			String query = "select * from customer where meter_no = '" + meterno.getSelectedItem() + "'";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				lblConsumername.setText(rs.getString("name"));
				lbladdress.setText(rs.getString("address"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		meterno.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				try {

					Conn c = new Conn();
					String query = "select * from customer where meter_no = '" + meterno.getSelectedItem() + "'";
					ResultSet rs = c.s.executeQuery(query);

					while (rs.next()) {
						lblConsumername.setText(rs.getString("name"));
						lbladdress.setText(rs.getString("address"));
					}

				} catch (Exception ae) {
					ae.printStackTrace();
				}

			}
		});

		JLabel lblunits = new JLabel("UNITS CONSUMED");
		lblunits.setBounds(100, 200, 130, 20);
		p.add(lblunits);

		units = new JTextField();
		units.setBounds(290, 200, 200, 20);
		p.add(units);

		JLabel lblmonth = new JLabel("FOR MONTH OF");
		lblmonth.setBounds(100, 240, 130, 20);
		p.add(lblmonth);

		String s[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December" };
		month = new JComboBox<String>(s);
		month.setBounds(290, 240, 200, 20);
		p.add(month);

		next = new JButton("SUBMIT");
		next.setBounds(160, 340, 100, 25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);

		cancel = new JButton("EXIT");
		cancel.setBounds(300, 340, 100, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);

		setLayout(new BorderLayout());
		add(p, "Center");

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(160, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image, "West");
		getContentPane().setBackground(Color.WHITE);

		Image img = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(img);
		setSize(700, 450);
		setLocation(450, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	String meterUnits; // declared it globally as we need them in calcBill method.

	@Override
	public void actionPerformed(ActionEvent e) { // data from this class will go in bill table in database

		if (e.getSource() == next) {

			String mno = meterno.getSelectedItem();
			String munits = units.getText(); 
			String billMonth = (String) month.getSelectedItem();

			this.meterUnits = munits;

			double totalBill = calcBill();

			// System.out.println("Total bill is "+totalBill);

			if (meterUnits.length() != 0) {
				try {

					String query = "insert into bill values('" + mno + "', '" + billMonth + "', '" + munits + "', '"
							+ totalBill + "', 'Not Paid')";
					Conn c = new Conn();
					c.s.executeUpdate(query);

					JOptionPane.showMessageDialog(null, "Consumer Bill Updated Successfully");
					setVisible(false);

				} catch (Exception ae) {
					// ae.printStackTrace();
					System.out.println("Here");
				}

			} else if (meterUnits.length() == 0) {
				JOptionPane.showMessageDialog(null, "Enter units consumed");
			}

		} else if (e.getSource() == cancel) {
			setVisible(false);
		}

	}

	private double calcBill() {

		double unitsConsumed = 0;

		// exception needed to be handled as if empty string is passed as units consumed
		// it cannot be converted into double value
		try {
			unitsConsumed = Integer.parseInt(meterUnits);
		} catch (Exception e) {
			System.out.println("Here number format exception is occurring");
		}

		double totalBill = (unitsConsumed * cost_per_unit) + meter_rent + service_charge + service_tax
				+ swaach_bharat_yojna + fixed_tax;

		return totalBill;

	}

	public static void main(String[] args) {
		new CalculateBill();
	}
}
