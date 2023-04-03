package EBS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateInfo extends JFrame implements ActionListener {

	JButton cancel, update;
	JTextField address, city, state, email, phone;
	JLabel name;
	
	String meter;

	UpdateInfo(String meter) {
		super("Update Information");

		this.meter = meter; // gave global variable the value of meter variable declared locally

		// heading
		JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
		heading.setBounds(70, 0, 400, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(heading);

		// customer name
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(30, 70, 100, 20);
		add(lblname);

		name = new JLabel();
		// name.setFont(new Font("Calibri", Font.TYPE1_FONT, 16));
		name.setBounds(230, 70, 200, 20);
		add(name);

		// customer meter number
		JLabel lblmeterno = new JLabel("METER NUMBER");
		lblmeterno.setBounds(30, 110, 100, 20);
		add(lblmeterno);

		JLabel meterno = new JLabel();
		meterno.setBounds(230, 110, 200, 20);
		add(meterno);

		// customer address
		JLabel lbladdress = new JLabel("ADDRESS");
		lbladdress.setBounds(30, 150, 200, 20);
		add(lbladdress);

		address = new JTextField();
		address.setBounds(230, 150, 200, 20);
		add(address);

		// City
		JLabel lblcity = new JLabel("CITY");
		lblcity.setBounds(30, 190, 100, 20);
		add(lblcity);

		city = new JTextField();
		city.setBounds(230, 190, 200, 20);
		add(city);

		// state
		JLabel lblstate = new JLabel("STATE");
		lblstate.setBounds(30, 230, 200, 20);
		add(lblstate);

		state = new JTextField();
		state.setBounds(230, 230, 200, 20);
		add(state);

		// email
		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(30, 270, 100, 20);
		add(lblemail);

		email = new JTextField();
		email.setBounds(230, 270, 200, 20);
		add(email);

		// phone number
		JLabel lblphone = new JLabel("PHONE NUMBER");
		lblphone.setBounds(30, 310, 100, 20);
		add(lblphone);

		phone = new JTextField();
		phone.setBounds(230, 310, 200, 20);
		add(phone);

		// button
		update = new JButton("UPDATE");
		update.setBounds(90, 360, 100, 25);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);

		cancel = new JButton("CANCEL");
		cancel.setBounds(230, 360, 100, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);

		try {

			Conn c = new Conn();
			String query = "select * from customer where meter_no = '" + meter + "'";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				// Name = rs.getString("name").toUpperCase();
				name.setText(rs.getString("name"));
				meterno.setText(rs.getString("meter_no"));
				address.setText(rs.getString("address"));
				state.setText(rs.getString("state"));
				city.setText(rs.getString("city"));
				email.setText(rs.getString("email"));
				phone.setText(rs.getString("phone"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
		Image i3 = i2.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i4 = new ImageIcon(i3);
		JLabel img = new JLabel(i4);
		img.setBounds(550, 50, 400, 300);
		add(img);

		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setSize(1050, 450);
		setLocation(300, 150);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(new Color(249, 246, 238));
		// getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == update) {
			
			String upaddr = address.getText();
			String upcity = city.getText();
			String upstate = state.getText();
			String upemail = email.getText();
			String upphone = phone.getText();
			
			if(upaddr.length() != 0 && upcity.length() != 0 && upstate.length() != 0 && upemail.length() != 0 && upphone.length() != 0) {
				
				if(upemail.contains("@") && upemail.endsWith(".com") && upphone.length() == 10 || upphone.length() == 13) {
					
					try {
						
						Conn c = new Conn();
						String query = "update customer set address = '"+upaddr+"', city = '"+upcity+"', state = '"+upstate+"', email = '"+upemail+"', phone = '"+upphone+"'  where meter_no = '"+meter+"'";
						c.s.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Details updated successfully!");
		                setVisible(false);
						
					} catch (Exception ae) {
						// TODO: handle exception
						ae.printStackTrace();
					}
					
				} else if(!upemail.contains("@") || !upemail.endsWith(".com")) {
					JOptionPane.showMessageDialog(null, "Invalid Email. Try again");
				} else if(upphone.length() != 10 || upphone.length() != 13) {
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
		new UpdateInfo("");
	}

}
