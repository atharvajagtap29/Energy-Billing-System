package EBS;

import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class BillInfo extends JFrame{
	
	BillInfo(String meter){
		super("Customer Bill Information");
		
		JTable table = new JTable();
		
		try {
			
			Conn c = new Conn();
			String query = "select * from bill where meter_no = '"+meter+"'";
			ResultSet rs = c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 0, 700, 650);
		add(sp);
		
		
		
		
		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setSize(700, 650);
		setLocation(450, 100);
		getContentPane().setBackground(new Color(249, 246, 238));
		setResizable(false);
		//setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BillInfo("");
	}
}
