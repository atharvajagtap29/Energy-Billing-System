package EBS;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class DepositDetails extends JFrame implements ActionListener {

	Choice meterno;
	JComboBox<String> month;
	JTable table;
	JButton search, print;

	public DepositDetails() {
		// TODO Auto-generated constructor stub
		super("Bill Details");

		JLabel lblmeterno = new JLabel("SEARCH BY METER NUMBER");
		lblmeterno.setBounds(20, 40, 200, 20);
		add(lblmeterno);

		meterno = new Choice();
		meterno.setBounds(240, 40, 150, 20);
		add(meterno);

		try {

			Conn c = new Conn();
			String query = "select * from customer";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				meterno.add(rs.getString("meter_no"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblmonth = new JLabel("SEARCH BY MONTH");
		lblmonth.setBounds(20, 80, 200, 20);
		add(lblmonth);

		String s[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December" };
		month = new JComboBox<String>(s);
		month.setBounds(240, 80, 150, 20);
		add(month);

		table = new JTable();
		try {

			Conn c = new Conn();
			String query2 = "select * from bill";
			ResultSet rs = c.s.executeQuery(query2);

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 130, 700, 600);
		add(sp);

		// creating buttons

		search = new JButton("SEARCH");
		search.setBackground(Color.BLACK);
		search.setForeground(Color.WHITE);
		search.setBounds(430, 60, 100, 25);
		search.addActionListener(this);
		add(search);

		print = new JButton("PRINT");
		print.setBackground(Color.BLACK);
		print.setForeground(Color.WHITE);
		print.setBounds(550, 60, 100, 25);
		print.addActionListener(this);
		add(print);

		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setSize(700, 700);
		setLocation(450, 80);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(new Color(249, 246, 238));
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == search) {

			try {

				String query = "select * from bill where meter_no = '" + meterno.getSelectedItem() + "' and month = '"
						+ month.getSelectedItem() + "'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);

				table.setModel(DbUtils.resultSetToTableModel(rs));

			} catch (Exception ae) {
				ae.printStackTrace();
			}

		} else if (e.getSource() == print) {
			try {
				table.print();
			} catch (Exception ae) {
				ae.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		new DepositDetails();

	}

}
