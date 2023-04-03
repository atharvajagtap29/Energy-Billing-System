package EBS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GenerateBill extends JFrame implements ActionListener {

	JComboBox<String> month;
	JTextArea area;
	JButton bill;

	String meter;

	public GenerateBill(String meter) {
		// TODO Auto-generated constructor stub
		super("GENERATE ELECTRICITY BILL");

		this.meter = meter;

		setLayout(new BorderLayout());

		Panel p = new Panel();
		

		JLabel heading = new JLabel("GENERATE BILL");
		JLabel meterno = new JLabel(meter);

		String s[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December" };
		month = new JComboBox<String>(s);

		int defaultrows = 50;
		int defaultcolumns = 15;
		area = new JTextArea(defaultrows, defaultcolumns);
		area.setText(
				"\n\n\t   ------Click on the------\n\t generate bill button to get\n\t bill of the selected month");
		area.setFont(new Font("Railway", Font.CENTER_BASELINE, 20));

		JScrollPane pane = new JScrollPane(area);

		bill = new JButton("GENERATE BILL");
		bill.addActionListener(this);

		p.add(heading);
		p.add(meterno);
		p.add(month);
		add(p, "North");

		add(pane, "Center");

		add(bill, "South");

		Image i1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(i1);
		setSize(530, 750);
		setLocation(500, 30);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String newmonth = (String) month.getSelectedItem();

		try {

			Conn c = new Conn();
			area.setText("                   Powershell Corporation Limited\n ELECTRICITY BILL GENERATED FOR THE MONTH\n\tOF "
					+ newmonth + ", 2023\n\n\n");
			String query = "select * from customer where meter_no = '"+meter+"'";
			//String query = "select * from customer where meter_no = '352242'";

			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				area.append("\n   Customer Name:   " + (rs.getString("name")));
				area.append("\n   Meter Number:   " + (rs.getString("meter_no")));
				area.append("\n   Address:   " + (rs.getString("address")));
				area.append("\n   City:   " + (rs.getString("city")));
				area.append("\n   State:   " + (rs.getString("state")));
				area.append("\n   Customer Email:   " + (rs.getString("email")));
				area.append("\n   Phone Number:   " + (rs.getString("phone")));
				area.append("\n   Bill Month:   " + newmonth);
				area.append("\n-----------------------------------------------------------------------------");
				//area.append("\n");
			}
			
			
			String query2 = "select * from meter_info where meter_no = '"+meter+"'";
			rs = c.s.executeQuery(query2);

			while (rs.next()) {
				area.append("\n   Meter Location:   " + (rs.getString("meter_location")));
				area.append("\n   Meter Type:   " + (rs.getString("meter_type")));
				area.append("\n   Phase Code:   " + (rs.getString("phase_code")));
				area.append("\n   Bill Type:   " + (rs.getString("bill_type")));
				area.append("\n   Bill for:   " + (rs.getString("days"))+"days");
				area.append("\n-----------------------------------------------------------------------------");
			}
			
			area.append("\n   Cost Per Unit:   "+CalculateBill.cost_per_unit);
			area.append("\n   Meter Rent:   "+CalculateBill.meter_rent);
			area.append("\n   Service Charge:   "+CalculateBill.service_charge);
			area.append("\n   Service Tax:   "+CalculateBill.service_tax);
			area.append("\n   Swachh Bharat Yojna:   "+CalculateBill.swaach_bharat_yojna);
			area.append("\n   Fixed tax:   "+CalculateBill.fixed_tax);
			area.append("\n-----------------------------------------------------------------------------");
			
			
			
			String query3 = "select * from bill where meter_no = '"+meter+"' and month = '"+newmonth+"'";
			
			rs = c.s.executeQuery(query3);
			
			while (rs.next()) {
				area.append("\n   Current Month:   " + (rs.getString("month")));
				area.append("\n   Units consumed:   " + (rs.getString("units_consumed")));
				area.append("\n   Total Charges:   " + (rs.getString("total_bill")));
				area.append("\n-----------------------------------------------------------------------------");
				area.append("\n   Total Payable Amount:   " + (rs.getString("total_bill")));
				area.append("\n   Payment Status:   " + (rs.getString("status")));
				
//				if(rs.getString("total_bill").equals("")) {
//					area.append("\n   No amount generated:   " + (rs.getString("total_bill")));
//				}
//				else {
//					area.append("\n   Total Payable Amount:   " + (rs.getString("total_bill")));
//				}
				//area.append("\n");
			}
			
		} catch (Exception ae) {
			ae.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new GenerateBill("");
	}

}
