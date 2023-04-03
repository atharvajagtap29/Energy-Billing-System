package EBS;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener {

	JTable table;
	JButton print;

	CustomerDetails() {
		super("Customer Details");

		table = new JTable();
		try {

			String query = "select * from customer";
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane sp = new JScrollPane(table);
		// sp.setBounds(0, 130, 700, 600);
		add(sp);

		print = new JButton("PRINT");
		/*
		 * print.setBackground(Color.BLACK); print.setForeground(Color.WHITE);
		 */
		// print.setBounds(550, 60, 100, 25);
		print.addActionListener(this);
		add(print, "South");

		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setSize(1200, 500);
		setLocation(200, 150);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		// setLayout(null);
		getContentPane().setBackground(new Color(249, 246, 238));
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == print) {
			try {
				table.print();
			} catch (Exception ae) {
				ae.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new CustomerDetails();
	}

}
