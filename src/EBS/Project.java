package EBS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Project extends JFrame implements ActionListener {

	JMenuItem newcust, custdetails, depdetails, calculatebill, viewInfo, updateInfo, billdetails, notepad, calc, ext,
			paybill, generateBill, feedback, reachus;

	String atype;
	String meterno;
	String fname;

	Project(String atype, String meterno, String fname) {

		super("Home Screen");

		this.meterno = meterno; // assigning the value of meter number we got from login to a global variable
								// meterno
		this.fname = fname;

		setExtendedState(JFrame.MAXIMIZED_BOTH); // it maximizes both length and breadth

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/Main.jpg"));
		Image img2 = img1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel image = new JLabel(img3);
		image.setBounds(0, 0, 1550, 850);
		add(image);

		// creating a menu bar
		JMenuBar mb = new JMenuBar();
		mb.setBackground(Color.WHITE);
		setJMenuBar(mb);
		setLayout(new FlowLayout());

		// adding menus on menu bar
		JMenu master = new JMenu("MASTER");
		master.setForeground(Color.BLACK);

		JMenu info = new JMenu("INFORMATION");
		info.setForeground(Color.BLACK);

		JMenu user = new JMenu("USER");
		user.setForeground(Color.BLACK);

		JMenu report = new JMenu("REPORT");
		report.setForeground(Color.BLACK);

		JMenu utility = new JMenu("UTILITY");
		utility.setForeground(Color.BLACK);

		JMenu rateus = new JMenu("RATE US");
		rateus.setForeground(Color.BLACK);

		JMenu contact = new JMenu("HELP");
		contact.setBackground(Color.BLACK);

		JMenu exit = new JMenu("EXIT");
		exit.setForeground(Color.BLACK);

		this.atype = atype;

		if (atype.equals("Admin")) {

			mb.add(master);

		} else if (atype.equals("Customer")) {

			mb.add(info);
			mb.add(user);
			mb.add(report);

		}

		mb.add(utility);
		mb.add(rateus);
		mb.add(contact);
		mb.add(exit);

		// adding menu items [Master][only admin can access these fields]
		newcust = new JMenuItem("New Customer");
		newcust.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
		Image ic2 = ic1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon ic3 = new ImageIcon(ic2);
		newcust.setIcon(ic3);
		newcust.setMnemonic('D');
		newcust.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		newcust.addActionListener(this);
		master.add(newcust);

		custdetails = new JMenuItem("Customer Details");
		custdetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon icn1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
		Image icn2 = icn1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon icn3 = new ImageIcon(icn2);
		custdetails.setIcon(icn3);
		// custdetails.setMnemonic('M');
		custdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		custdetails.addActionListener(this);
		master.add(custdetails);

		depdetails = new JMenuItem("Deposit Details");
		depdetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
		Image icon2 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon icon3 = new ImageIcon(icon2);
		depdetails.setIcon(icon3);
		// custdetails.setMnemonic('M');
		depdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		depdetails.addActionListener(this);
		master.add(depdetails);

		calculatebill = new JMenuItem("Calculate Bill");
		calculatebill.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image icon5 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon icon6 = new ImageIcon(icon5);
		calculatebill.setIcon(icon6);
		// custdetails.setMnemonic('M');
		calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		calculatebill.addActionListener(this);
		master.add(calculatebill);

		// adding menu items [Information]
		updateInfo = new JMenuItem("Update Information");
		updateInfo.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon update1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image update2 = update1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon update3 = new ImageIcon(update2);
		updateInfo.setIcon(update3);
		// updateInfo.setMnemonic('U');
		updateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		updateInfo.addActionListener(this);
		info.add(updateInfo);

		viewInfo = new JMenuItem("View Information");
		viewInfo.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon view1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
		Image view2 = view1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon view3 = new ImageIcon(view2);
		viewInfo.setIcon(view3);
		// custdetails.setMnemonic('M');
		viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		viewInfo.addActionListener(this);
		info.add(viewInfo);

		// adding menu items [User]
		paybill = new JMenuItem("Pay Bill");
		paybill.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon pay1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image pay2 = pay1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon pay3 = new ImageIcon(pay2);
		paybill.setIcon(pay3);
		// updateInfo.setMnemonic('U');
		paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		paybill.addActionListener(this);
		user.add(paybill);

		billdetails = new JMenuItem("Bill Details");
		billdetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon bd1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
		Image bd2 = bd1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon bd3 = new ImageIcon(bd2);
		billdetails.setIcon(bd3);
		// updateInfo.setMnemonic('U');
		billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		billdetails.addActionListener(this);
		user.add(billdetails);

		// adding menu items [Report]
		generateBill = new JMenuItem("Generate Bill");
		generateBill.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon gb1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
		Image gb2 = gb1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon gb3 = new ImageIcon(gb2);
		generateBill.setIcon(gb3);
		// updateInfo.setMnemonic('U');
		generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		generateBill.addActionListener(this);
		report.add(generateBill);

		// adding menu items [Utility]
		notepad = new JMenuItem("Notepad");
		notepad.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon notepad1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
		Image notepad2 = notepad1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon notepad3 = new ImageIcon(notepad2);
		notepad.setIcon(notepad3);
		// updateInfo.setMnemonic('U');
		notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		notepad.addActionListener(this);
		utility.add(notepad);

		calc = new JMenuItem("Calculator");
		calc.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon calc1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
		Image calc2 = calc1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon calc3 = new ImageIcon(calc2);
		calc.setIcon(calc3);
		// updateInfo.setMnemonic('U');
		calc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		calc.addActionListener(this);
		utility.add(calc);

		// adding menu items [rate us]
		feedback = new JMenuItem("Feedback Form");
		feedback.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon ext9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
		Image ext8 = ext9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon ext7 = new ImageIcon(ext8);
		feedback.setIcon(ext7);
		// updateInfo.setMnemonic('U');
		feedback.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		feedback.addActionListener(this);
		rateus.add(feedback);

		// adding menu items [contact us]
		reachus = new JMenuItem("Contact us");
		reachus.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon r1 = new ImageIcon(ClassLoader.getSystemResource("icon/call-up.png"));
		Image r2 = r1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon r3 = new ImageIcon(r2);
		reachus.setIcon(r3);
		// updateInfo.setMnemonic('U');
		reachus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		reachus.addActionListener(this);
		contact.add(reachus);

		// adding menu items [exit]
		ext = new JMenuItem("Exit the window");
		ext.setFont(new Font("Calibri", Font.PLAIN, 12));
		ImageIcon ext1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
		Image ext2 = ext1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon ext3 = new ImageIcon(ext2);
		ext.setIcon(ext3);
		// updateInfo.setMnemonic('U');
		ext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		ext.addActionListener(this);
		exit.add(ext);

		// Frame
		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setVisible(true);

		// System.out.println(getSize());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == newcust) {

			setVisible(true);
			new NewCustomer();

		} else if (e.getSource() == custdetails) {

			setVisible(true);
			new CustomerDetails();

		} else if (e.getSource() == depdetails) {

			setVisible(true);
			new DepositDetails();

		} else if (e.getSource() == calculatebill) {

			setVisible(true);
			new CalculateBill();

		} else if (e.getSource() == viewInfo) {

			setVisible(true);
			new ViewInformation(meterno);

		} else if (e.getSource() == updateInfo) {

			setVisible(true);
			new UpdateInfo(meterno);

		} else if (e.getSource() == billdetails) {

			setVisible(true);
			new BillInfo(meterno);

		} else if (e.getSource() == notepad) {

			setVisible(true);
			try {

				Runtime.getRuntime().exec("notepad.exe");

			} catch (Exception ae) {
				ae.printStackTrace();
			}

		} else if (e.getSource() == calc) {

			setVisible(true);
			try {

				Runtime.getRuntime().exec("calc.exe");

			} catch (Exception ae) {
				ae.printStackTrace();
			}

		} else if (e.getSource() == ext) {

			setVisible(false);

		} else if (e.getSource() == paybill) {

			setVisible(true);
			new PayBill(meterno);

		} else if (e.getSource() == generateBill) {

			setVisible(true);
			new GenerateBill(meterno);

		} else if (e.getSource() == feedback) {

			setVisible(true);
			new Feedback(meterno, atype, fname);
			
		} else if (e.getSource() == reachus) {
			
			setVisible(true);
			new Contact();
		}

	}

	public static void main(String[] args) {

		new Project("", "", "");
	}

}
