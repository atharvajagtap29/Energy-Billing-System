package EBS;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {

	JComboBox<String> accType;
	JTextField meterNumber, username, name;
	JPasswordField password;
	JButton create, back;
	// Choice choice;

	// String nameset;

	JLabel ifAdmin;

	Signup() {
		super("SIGNUP PAGE");

		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 645, 320);
		panel.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 2), "CREATE-ACCOUNT  ", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		panel.setBackground(new Color(249, 246, 238));
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		// setVisible(true);
		add(panel);

		JLabel heading = new JLabel("ACCOUNT USER");
		heading.setBounds(100, 50, 160, 20);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(heading);

		// String boxElements[] = {"Admin", "Customer"};
		accType = new JComboBox<String>();
		accType.addItem("Admin");
		accType.addItem("Customer");
		accType.setBounds(280, 50, 150, 20);
		panel.add(accType);

//		choice = new Choice();
//		choice.add("Customer");
//		choice.add("Admin");
//		choice.setBounds(280, 50, 150, 20);
//		panel.add(choice);

		JLabel lblmeternumber = new JLabel("METER NUMBER");
		lblmeternumber.setBounds(100, 90, 140, 20);
		lblmeternumber.setForeground(Color.BLACK);
		lblmeternumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmeternumber.setVisible(false);
		panel.add(lblmeternumber);

		meterNumber = new JTextField();
		meterNumber.setBounds(280, 90, 150, 20);
		meterNumber.setVisible(false);
		panel.add(meterNumber);

		// if admin is selected this messege will display as a label
		ifAdmin = new JLabel("Only customers can add meter numbers");
		ifAdmin.setBounds(120, 90, 600, 20);
		ifAdmin.setForeground(Color.BLACK);
		ifAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ifAdmin.setVisible(true);
		panel.add(ifAdmin);

		accType.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String user = (String) accType.getSelectedItem();

				if (user != "Admin") {

					ifAdmin.setVisible(false);
					lblmeternumber.setVisible(true);
					meterNumber.setVisible(true);
					name.setEditable(false);

				} else {
					ifAdmin.setVisible(true);
					lblmeternumber.setVisible(false);
					meterNumber.setVisible(false);
					name.setEditable(true);
				}
			}
		});

		JLabel lblusername = new JLabel("USERNAME");
		lblusername.setBounds(100, 130, 140, 20);
		lblusername.setForeground(Color.BLACK);
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblusername);

		username = new JTextField();
		username.setBounds(280, 130, 150, 20);
		panel.add(username);

		JLabel lblname = new JLabel("FULL NAME");
		lblname.setBounds(100, 170, 140, 20);
		lblname.setForeground(Color.BLACK);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblname);

		name = new JTextField();
		name.setBounds(280, 170, 150, 20);
		panel.add(name);

		meterNumber.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

				try {

					Conn c = new Conn();
					String query = "select * from customer where meter_no = '" + meterNumber.getText() + "'";
					ResultSet rs = c.s.executeQuery(query);

					while (rs.next()) {
						name.setText(rs.getString("name"));
						// nameset = rs.getString("name");
					}
				} catch (Exception ae) {
					ae.printStackTrace();
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

//		JLabel name = new JLabel(nameset);
//		name.setBounds(280, 170, 150, 20);
//		name.setForeground(Color.BLACK);
//		name.setFont(new Font("Tahoma", Font.BOLD, 14));
//		panel.add(name);

		JLabel lblpassword = new JLabel("PASSWORD");
		lblpassword.setBounds(100, 210, 140, 20);
		lblpassword.setForeground(Color.BLACK);
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblpassword);

		password = new JPasswordField();
		password.setBounds(280, 210, 150, 20);
		// password.setEchoChar('*');
		panel.add(password);

		// Creating Buttons
		create = new JButton("CREATE ACCOUNT");
		create.setBounds(140, 270, 150, 25);
		create.setBackground(Color.BLACK);
		create.setForeground(Color.WHITE);
		create.addActionListener(this);
		panel.add(create);

		back = new JButton("GO BACK");
		back.setBounds(320, 270, 150, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		panel.add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
		Image i2 = i1.getImage().getScaledInstance(225, 225, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(430, 35, 225, 225);
		panel.add(image);

		// to make all the items on the panel visible at run time, set the visibility of
		// the panel to true after adding all the items to it
		panel.setVisible(true);

		// creating frame
		Image img = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(img);

		setSize(700, 400);
		setLocation(450, 150);
		getContentPane().setBackground(new Color(249, 246, 238));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int passLength = 8;

		if (e.getSource() == create) {

			String user = (String) accType.getSelectedItem();

			if (user == "Customer") {

				String atype = (String) accType.getSelectedItem();
				String meterNum = meterNumber.getText();
				String userName = username.getText();
				String fname = name.getText();
				@SuppressWarnings("deprecation")
				String pass = password.getText();

				if (userName.length() != 0 && fname.length() != 0 && pass.length() != 0) {

					if (pass.length() == passLength) {

						try {

							Conn c = new Conn();
							String query = "insert into login values(\'" + meterNum + "\', \'" + userName + "\', \'"
									+ fname + "\', \'" + pass + "\', \'" + atype + "\');";
							c.s.executeUpdate(query); // execute update is used for inserting something into the
														// database,
														// while
														// executeQuery is used when we got to get some result set from
														// the
														// database

							JOptionPane.showMessageDialog(null, "Account created successfully");
							setVisible(false);
							new Login();

						} catch (Exception ae) {
							ae.printStackTrace();
						}
					} else if (pass.length() != passLength) {
						JOptionPane.showMessageDialog(null, "Password must be 8 characters");
					}
				} else {
					JOptionPane.showMessageDialog(null, "All fields must be filled");
				}

			} else if (user == "Admin") {

				String atype = (String) accType.getSelectedItem();
				String meterNum = "0";
				String userName = username.getText();
				String fname = name.getText();
				@SuppressWarnings("deprecation")
				String pass = password.getText();

				if (userName.length() != 0 && fname.length() != 0 && pass.length() != 0) {

					if (pass.length() == passLength) {

						try {

							Conn c = new Conn();
							String query = "insert into login values(\'" + meterNum + "\', \'" + userName + "\', \'"
									+ fname + "\', \'" + pass + "\', \'" + atype + "\');";
							c.s.executeUpdate(query); // execute update is used for inserting something into the
														// database,
														// while
														// executeQuery is used when we got to get some result set from
														// the
														// database

							JOptionPane.showMessageDialog(null, "Account created successfully");
							setVisible(false);
							new Login();

						} catch (Exception ae) {
							ae.printStackTrace();
						}
					} else if (pass.length() != passLength) {
						JOptionPane.showMessageDialog(null, "Password must be 8 characters");
					}
				} else {
					JOptionPane.showMessageDialog(null, "All fields must be filled");
				}

			}

//			String atype = (String) accType.getSelectedItem();
//			String meterNum = meterNumber.getText();
//			String userName = username.getText();
//			String fname = name.getText();
//			@SuppressWarnings("deprecation")
//			String pass = password.getText();
//
//			if (userName.length() != 0 && fname.length() != 0 && pass.length() != 0) {
//
//				if (pass.length() == passLength && meterNum.length() == meterNumLength) {
//
//					try {
//
//						Conn c = new Conn();
//						String query = "insert into login values(\'" + meterNum + "\', \'" + userName + "\', \'" + fname
//								+ "\', \'" + pass + "\', \'" + atype + "\');";
//						c.s.executeUpdate(query); // execute update is used for inserting something into the database,
//													// while
//													// executeQuery is used when we got to get some result set from the
//													// database
//
//						JOptionPane.showMessageDialog(null, "Account created successfully");
//						setVisible(false);
//						new Login();
//
//					} catch (Exception ae) {
//						ae.printStackTrace();
//					}
//				} else if (pass.length() != passLength) {
//					JOptionPane.showMessageDialog(null, "Password must be 8 characters");
//				}
//			}
//
//			else {
//				JOptionPane.showMessageDialog(null, "All fields must be filled");
//			}

		} else if (e.getSource() == back) {

			setVisible(false);
			// new Login();
			new Login();

		}
	}

	public static void main(String[] args) {

		new Signup();

	}

}
