package EBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MeterInfo extends JFrame implements ActionListener {

	private JTextField tfphone, tfname, tfaddress, tfstate, tfcity, tfemail;
	JButton next, cancel;
	JLabel lblmeter;

	JComboBox<String> meterloc, metertype, phasecode, billtype;
	String meterNumber;

	public MeterInfo(String meterNumber) { // only admin can create a new customer. only if admin has created a new
		// customer, that customer is allowed to sign up and create his account

		this.meterNumber = meterNumber;

		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(172, 216, 230));
		add(p);

		String title = "Meter information";
		JLabel heading = new JLabel(title.toUpperCase());
		heading.setFont(new Font("Tahoma", Font.BOLD, 22));
		heading.setBounds(160, 10, 300, 25);
		p.add(heading);

		JLabel lblmetertxt = new JLabel("METER NUMBER");
		lblmetertxt.setBounds(100, 80, 250, 20);
		p.add(lblmetertxt);

		JLabel lblmeternum = new JLabel(meterNumber);
		lblmeternum.setBounds(290, 80, 130, 20);
		p.add(lblmeternum);

		JLabel lblmeterloc = new JLabel("METER LOCATION");
		lblmeterloc.setBounds(100, 120, 130, 20);
		p.add(lblmeterloc);

		String s[] = { "Inside", "Outside" };
		meterloc = new JComboBox<String>(s);
		meterloc.setBounds(290, 120, 200, 20);
		p.add(meterloc);

		JLabel lblmetertype = new JLabel("METER TYPE");
		lblmetertype.setBounds(100, 160, 130, 20);
		p.add(lblmetertype);

		String s2[] = { "Electric Meter", "Solar Meter", "Smart Meter" };
		metertype = new JComboBox<String>(s2);
		metertype.setBounds(290, 160, 200, 20);
		p.add(metertype);

		JLabel lblcode = new JLabel("PHASE CODE");
		lblcode.setBounds(100, 200, 130, 20);
		p.add(lblcode);

		String s3[] = { "011", "022", "033", "044", "055", "066", "077", "088", "099" };
		phasecode = new JComboBox<String>(s3);
		phasecode.setBounds(290, 200, 200, 20);
		p.add(phasecode);

		JLabel lblbilltype = new JLabel("BILL TYPE");
		lblbilltype.setBounds(100, 240, 130, 20);
		p.add(lblbilltype);

		String s4[] = { "Normal", "Commercial" };
		billtype = new JComboBox<String>(s4);
		billtype.setBounds(290, 240, 200, 20);
		p.add(billtype);

		JLabel lbldays = new JLabel("DAYS");
		lbldays.setBounds(100, 280, 130, 20);
		p.add(lbldays);

		JLabel days = new JLabel("30 DAYS");
		days.setBounds(290, 280, 130, 20);
		p.add(days);

		JLabel lblnote = new JLabel("PLEASE NOTE");
		lblnote.setBounds(100, 320, 130, 20);
		p.add(lblnote);

		JLabel note = new JLabel("Bill will be auto-generated for \n30 days of power usage.");
		note.setBounds(290, 320, 500, 20);
		p.add(note);

		next = new JButton("SUBMIT");
		next.setBounds(220, 390, 100, 25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);

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
		setSize(800, 500);
		setLocation(450, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next) {

			String meter = meterNumber;
			String mLoc = (String) meterloc.getSelectedItem();
			String mtype = (String) metertype.getSelectedItem();
			String code = (String) phasecode.getSelectedItem();
			String bill = (String) billtype.getSelectedItem();
			String days = "30";

			if (meter.length() != 0) {
				try {

					String query = "insert into meter_info values('" + meter + "', '" + mLoc + "', '" + mtype + "', '"
							+ code + "', '" + bill + "', '" + days + "')";

					Conn c = new Conn();
					c.s.executeUpdate(query);

					JOptionPane.showMessageDialog(null, "Meter Information added successfully!");
					setVisible(false);

				} catch (Exception ae) {
					ae.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Meter number not set");
			}
			

		} else if (e.getSource() == cancel) {
			setVisible(false);
		}

	}

//	public static void main(String[] args) {
//		new MeterInfo("");
//	}

}
