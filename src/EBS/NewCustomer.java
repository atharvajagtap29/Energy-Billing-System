package EBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener {

	private JTextField tfphone, tfname, tfaddress, tfstate, tfcity, tfemail;
	JButton next, cancel;
	JLabel lblmeter;

	public NewCustomer() { // only admin can create a new customer. only if admin has created a new
							// customer, that customer is allowed to sign up and create his account

		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(172, 216, 230));
		add(p);

		JLabel heading = new JLabel("NEW CUSTOMER");
		heading.setFont(new Font("Tahoma", Font.BOLD, 22));
		heading.setBounds(170, 10, 300, 25);
		p.add(heading);

		JLabel lblname = new JLabel("CUSTOMER NAME");
		lblname.setBounds(100, 80, 130, 20);
		p.add(lblname);

		tfname = new JTextField();
		tfname.setBounds(290, 80, 200, 20);
		p.add(tfname);

		JLabel meterno = new JLabel("METER NUMBER");
		meterno.setBounds(100, 120, 100, 20);
		p.add(meterno);

		lblmeter = new JLabel();
		lblmeter.setBounds(290, 120, 130, 20);
		p.add(lblmeter);

		Random ran = new Random();
		long number = ran.nextLong() % 1000000; // number of zeros = number of digits of the random number
		lblmeter.setText("" + Math.abs(number));

		JLabel address = new JLabel("ADDRESS");
		address.setBounds(100, 160, 130, 20);
		p.add(address);

		tfaddress = new JTextField();
		tfaddress.setBounds(290, 160, 200, 20);
		p.add(tfaddress);

		JLabel state = new JLabel("MENTION STATE");
		state.setBounds(100, 200, 130, 20);
		p.add(state);

		tfstate = new JTextField();
		tfstate.setBounds(290, 200, 200, 20);
		p.add(tfstate);

		JLabel city = new JLabel("MENTION CITY");
		city.setBounds(100, 240, 130, 20);
		p.add(city);

		tfcity = new JTextField();
		tfcity.setBounds(290, 240, 200, 20);
		p.add(tfcity);

		JLabel email = new JLabel("ENTER EMAIL");
		email.setBounds(100, 280, 130, 20);
		p.add(email);

		tfemail = new JTextField();
		tfemail.setBounds(290, 280, 200, 20);
		p.add(tfemail);

		JLabel phone = new JLabel("CONTACT NUMBER");
		phone.setBounds(100, 320, 130, 20);
		p.add(phone);

		tfphone = new JTextField();
		tfphone.setBounds(290, 320, 200, 20);
		p.add(tfphone);

		next = new JButton("NEXT");
		next.setBounds(160, 390, 100, 25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);

		cancel = new JButton("EXIT");
		cancel.setBounds(300, 390, 100, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);

		setLayout(new BorderLayout());
		add(p, "Center");

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(160, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image, "West");
		getContentPane().setBackground(Color.WHITE);

		Image img = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(img);
		setSize(700, 500);
		setLocation(450, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next) {

			String name = tfname.getText();
			String meter = lblmeter.getText();
			String address = tfaddress.getText();
			String city = tfcity.getText();
			String state = tfstate.getText();
			String email = tfemail.getText();
			String phone = tfphone.getText();

			if (name.length() != 0 && meter.length() != 0 && address.length() != 0 && city.length() != 0
					&& state.length() != 0 && email.length() != 0 && phone.length() != 0) {

				if (email.contains("@") && email.endsWith(".com") && phone.length() == 10 || phone.length() == 13) {

					try {

						String query1 = "insert into customer values('" + name + "', '" + meter + "', '" + address
								+ "', '" + city + "', '" + state + "', '" + email + "', '" + phone + "')";
//						String query2 = "insert into login values('" + meter + "', '" + "" + "', '" + name + "', '" + ""
//								+ "', '" + "" + "')";

						Conn c = new Conn();
						c.s.executeUpdate(query1);
						//c.s.executeUpdate(query2);

						JOptionPane.showMessageDialog(null, "Customer Details added successfully!");
						setVisible(false);
						
						new MeterInfo(meter);  // passing meter number as a parameter to constructor so we can use it in next class

					} catch (Exception ae) {
						ae.printStackTrace();
					}
				}

				else if (!email.contains("@") || !email.endsWith(".com")) {
					JOptionPane.showMessageDialog(null, "Invalid email. Try again");
				} else if (phone.length() != 10 || phone.length() != 13) {
					JOptionPane.showMessageDialog(null, "Invalid phone number. Try again");
				}
			} else {
				JOptionPane.showMessageDialog(null, "All fields must be filled");
			}

		} else if (e.getSource() == cancel) {
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		new NewCustomer();
	}
}
