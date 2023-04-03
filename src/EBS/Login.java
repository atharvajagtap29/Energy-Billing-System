package EBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

	private TextField username, password;
	JComboBox cbUser;
	JButton login, signup, cancel;

	Login() {
		super("LOGIN PAGE"); // super must be the first line in a constructor according to language rules

		// creating label username and a textfield for it
		JLabel lblusername = new JLabel("USERNAME:");
		lblusername.setBounds(300, 20, 80, 20);
		lblusername.setForeground(Color.BLACK);
		add(lblusername);

		username = new TextField();
		username.setBounds(400, 20, 150, 20);
		add(username);

		// creating label password and a textfield for it
		JLabel lblpassword = new JLabel("PASSWORD:");
		lblpassword.setBounds(300, 60, 80, 20);
		lblpassword.setForeground(Color.BLACK);
		add(lblpassword);

		password = new TextField();
		password.setEchoChar('*');
		password.setBounds(400, 60, 150, 20);
		add(password);

		// creating label and combobox for usertype
		JLabel loggingInAs = new JLabel("LOGIN AS:");
		loggingInAs.setBounds(300, 100, 80, 20);
		loggingInAs.setForeground(Color.BLACK);
		add(loggingInAs);

		String userTypes[] = { "Customer", "Admin" };
		cbUser = new JComboBox(userTypes);
		cbUser.setBounds(400, 100, 100, 20);
		add(cbUser);

		// creating button objects
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i2 = i1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		login = new JButton("LOGIN", i3);
		login.setBounds(330, 160, 120, 25);
		login.setBackground(Color.WHITE);
		login.setForeground(Color.BLACK);
		login.addActionListener(this);
		add(login);

		ImageIcon signup1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
		Image signup2 = signup1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		ImageIcon signup3 = new ImageIcon(signup2);
		signup = new JButton("SIGN UP", signup3);
		signup.setBounds(470, 160, 120, 25);
		signup.setBackground(Color.WHITE);
		signup.setForeground(Color.BLACK);
		signup.addActionListener(this);
		add(signup);

		ImageIcon cancel1 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
		Image cancel2 = cancel1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		ImageIcon cancel3 = new ImageIcon(cancel2);
		cancel = new JButton("CANCEL", cancel3);
		cancel.setBounds(390, 200, 120, 25);
		cancel.setBackground(Color.WHITE);
		cancel.setForeground(Color.BLACK);
		cancel.addActionListener(this);
		add(cancel);

		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/login2.png"));
		Image image2 = image.getImage().getScaledInstance(250, 265, Image.SCALE_DEFAULT);
		ImageIcon image3 = new ImageIcon(image2);
		JLabel imageFinal = new JLabel(image3);
		imageFinal.setBounds(0, 0, 250, 265);
		add(imageFinal);

		// creating frame
		Image img = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(img);

		setSize(640, 300);
		setLocation(450, 200);
		getContentPane().setBackground(new Color(249, 246, 238));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login) {

			String susername = username.getText();
			String spassword = password.getText();
			String logginIn = (String) cbUser.getSelectedItem();

			if (logginIn == "Customer") {

				try {

					Conn c = new Conn();
					String query = "select * from login where username = '" + susername + "'and password = '"
							+ spassword + "'and user = '" + logginIn + "'";
					ResultSet rs = c.s.executeQuery(query);

					if (rs.next()) {
						setVisible(false);
						String meter = rs.getString("meter_no");
						String fname = rs.getString("fname");
						new Project(logginIn, meter, fname);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid credentials! Try Again");
						username.setText("");
						password.setText("");
					}

				} catch (Exception ae) {
					ae.printStackTrace();
				}

			}

			if (logginIn == "Admin") {
				
				try {

					Conn c = new Conn();
					String query = "select * from login where username = '" + susername + "'and password = '"
							+ spassword + "'and user = '" + logginIn + "'";
					ResultSet rs = c.s.executeQuery(query);

					if (rs.next()) {
						setVisible(false);
						String fname = rs.getString("fname");
						new Project(logginIn, "", fname);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid credentials! Try Again");
						username.setText("");
						password.setText("");
					}

				} catch (Exception ae) {
					ae.printStackTrace();
				}
				
			}

		} else if (e.getSource() == signup) {

			setVisible(false);
			// new Signup();
			new Signup();

		} else if (e.getSource() == cancel) {

			setVisible(false);

		} 

	}

	public static void main(String[] args) {
		new Login();
	}
}
