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

public class ViewInformation extends JFrame implements ActionListener {

	JButton cancel;

	public ViewInformation(String meternum) {
		// TODO Auto-generated constructor stub
		super("Customer Information");

		// heading
		JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
		heading.setBounds(250, 0, 500, 40);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(heading);

		// customer name
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(70, 80, 100, 20);
		add(lblname);

		JLabel name = new JLabel();
		// name.setFont(new Font("Calibri", Font.TYPE1_FONT, 16));
		name.setBounds(250, 80, 150, 20);
		add(name);

		// customer meter number
		JLabel lblmeterno = new JLabel("METER NUMBER");
		lblmeterno.setBounds(70, 140, 100, 20);
		add(lblmeterno);

		JLabel meterno = new JLabel();
		meterno.setBounds(250, 140, 100, 20);
		add(meterno);

		// customer address
		JLabel lbladdress = new JLabel("ADDRESS");
		lbladdress.setBounds(70, 200, 200, 20);
		add(lbladdress);

		JLabel address = new JLabel();
		address.setBounds(250, 200, 200, 20);
		add(address);

		// City
		JLabel lblcity = new JLabel("CITY");
		lblcity.setBounds(70, 260, 100, 20);
		add(lblcity);

		JLabel city = new JLabel();
		city.setBounds(250, 260, 100, 20);
		add(city);

		// state
		JLabel lblstate = new JLabel("STATE");
		lblstate.setBounds(500, 80, 100, 20);
		add(lblstate);

		JLabel state = new JLabel();
		state.setBounds(650, 80, 100, 20);
		add(state);

		// email
		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(500, 140, 100, 20);
		add(lblemail);

		JLabel email = new JLabel();
		email.setBounds(650, 140, 150, 20);
		add(email);

		// phone number
		JLabel lblphone = new JLabel("PHONE NUMBER");
		lblphone.setBounds(500, 200, 100, 20);
		add(lblphone);

		JLabel phone = new JLabel();
		phone.setBounds(650, 200, 100, 20);
		add(phone);

		try {

			Conn c = new Conn();
			String query = "select * from customer where meter_no = '" + meternum + "'";
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

		// button
		cancel = new JButton("CANCEL");
		cancel.setBounds(350, 300, 100, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);

		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
		Image i3 = i2.getImage();
		ImageIcon i4 = new ImageIcon(i3);
		JLabel img = new JLabel(i4);
		img.setBounds(10, 350, 600, 300);
		add(img);

		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setSize(850, 650);
		setLocation(370, 80);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(new Color(249, 246, 238));
		// getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cancel) {
			setVisible(false);
			// new Project("", "");
		}

	}

//	public static void main(String[] args) {
//		new ViewInformation("");
//	}

}
