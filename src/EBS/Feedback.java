package EBS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Feedback extends JFrame implements ActionListener {

	// JTextField tf;
	// JTextArea tf;

	JRadioButton worse, avg, good, best, q2b1, q2b2, q2b3, q2b4, q3b1, q3b2, q3b3, q3b4, q4b1, q4b2, q4b3, q4b4, q5b1,
			q5b2, q5b3, q5b4;

	ButtonGroup group1, group2, group3, group4, group5;

	JButton back, submit;

	String meter, atype, fullName;

	public Feedback(String meter, String atype, String fullName) {
		// TODO Auto-generated constructor stub
		super("USER FEEDBACK");

		this.meter = meter;
		this.atype = atype;
		this.fullName = fullName;

//		this.meter = "213456";
//		this.atype = "Customer";
//		this.fullName = "Ved Jagtap";

		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(172, 216, 230));
		add(p);

		JLabel heading = new JLabel("USER EXPERIENCE RATING");
		heading.setFont(new Font("Tahoma", Font.BOLD, 22));
		heading.setBounds(180, 10, 500, 25);
		p.add(heading);

		JLabel txt = new JLabel(
				"<html>Dear User, please take your time to help us improving our application<br/> through this feedback form.</html>");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt.setBounds(10, 60, 1000, 45);
		p.add(txt);


		// question 1
		JLabel q1 = new JLabel("1) How would you rate your experience using this app?");
		q1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		q1.setBounds(10, 125, 350, 20);
		p.add(q1);

		worse = new JRadioButton("Worse");
		avg = new JRadioButton("Average");
		good = new JRadioButton("Good");
		best = new JRadioButton("Best");

		worse.setBounds(10, 150, 100, 20);
		worse.setBackground(new Color(172, 216, 230));
		worse.setActionCommand("Worse");

		avg.setBounds(130, 150, 100, 20);
		avg.setBackground(new Color(172, 216, 230));
		avg.setActionCommand("Average");

		good.setBounds(250, 150, 100, 20);
		good.setBackground(new Color(172, 216, 230));
		good.setActionCommand("Good");

		best.setBounds(370, 150, 100, 20);
		best.setBackground(new Color(172, 216, 230));
		best.setActionCommand("Best");

		group1 = new ButtonGroup();
		group1.add(best);
		group1.add(avg);
		group1.add(good);
		group1.add(worse);

		p.add(worse);
		p.add(avg);
		p.add(good);
		p.add(best);

		// question 2
		JLabel q2 = new JLabel("2) How likely are you to recommend this app to others on a scale of 1-10?");
		q2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		q2.setBounds(10, 200, 500, 20);
		p.add(q2);

		q2b1 = new JRadioButton("10");
		q2b2 = new JRadioButton("7-10");
		q2b3 = new JRadioButton("3-6");
		q2b4 = new JRadioButton("Less than 3");

		q2b1.setBounds(10, 220, 70, 20);
		q2b1.setBackground(new Color(172, 216, 230));
		q2b1.setActionCommand("10");

		q2b2.setBounds(130, 220, 100, 20);
		q2b2.setBackground(new Color(172, 216, 230));
		q2b2.setActionCommand("7-10");

		q2b3.setBounds(250, 220, 100, 20);
		q2b3.setBackground(new Color(172, 216, 230));
		q2b3.setActionCommand("3-6");

		q2b4.setBounds(370, 220, 100, 20);
		q2b4.setBackground(new Color(172, 216, 230));
		q2b4.setActionCommand("Less than 3");

		group2 = new ButtonGroup();
		group2.add(q2b1);
		group2.add(q2b2);
		group2.add(q2b3);
		group2.add(q2b4);

		p.add(q2b1);
		p.add(q2b2);
		p.add(q2b3);
		p.add(q2b4);

		// question 3
		JLabel q3 = new JLabel("3) Ease of software installation?");
		q3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		q3.setBounds(10, 270, 300, 20);
		p.add(q3);

		q3b1 = new JRadioButton("Satisfied");
		q3b2 = new JRadioButton("Neutral");
		q3b3 = new JRadioButton("Unsatisfied");
		q3b4 = new JRadioButton("N/A");

		q3b1.setBounds(10, 290, 100, 20);
		q3b1.setBackground(new Color(172, 216, 230));
		q3b1.setActionCommand("Satisfied");

		q3b2.setBounds(130, 290, 100, 20);
		q3b2.setBackground(new Color(172, 216, 230));
		q3b2.setActionCommand("Neutral");

		q3b3.setBounds(250, 290, 100, 20);
		q3b3.setBackground(new Color(172, 216, 230));
		q3b3.setActionCommand("Unsatisfied");

		q3b4.setBounds(370, 290, 100, 20);
		q3b4.setBackground(new Color(172, 216, 230));
		q3b4.setActionCommand("N/A");

		group3 = new ButtonGroup();
		group3.add(q3b1);
		group3.add(q3b2);
		group3.add(q3b3);
		group3.add(q3b4);

		p.add(q3b1);
		p.add(q3b2);
		p.add(q3b3);
		p.add(q3b4);

		// question 4
		JLabel q4 = new JLabel("4) Application Software compatibility?");
		q4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		q4.setBounds(10, 340, 300, 20);
		p.add(q4);

		q4b1 = new JRadioButton("Satisfied");
		q4b2 = new JRadioButton("Neutral");
		q4b3 = new JRadioButton("Unsatisfied");
		q4b4 = new JRadioButton("N/A");

		q4b1.setBounds(10, 360, 100, 20);
		q4b1.setBackground(new Color(172, 216, 230));
		q4b1.setActionCommand("Satisfied");

		q4b2.setBounds(130, 360, 100, 20);
		q4b2.setBackground(new Color(172, 216, 230));
		q4b2.setActionCommand("Neutral");

		q4b3.setBounds(250, 360, 100, 20);
		q4b3.setBackground(new Color(172, 216, 230));
		q4b3.setActionCommand("Unsatisfied");

		q4b4.setBounds(370, 360, 100, 20);
		q4b4.setBackground(new Color(172, 216, 230));
		q4b4.setActionCommand("N/A");

		group4 = new ButtonGroup();
		group4.add(q4b1);
		group4.add(q4b2);
		group4.add(q4b3);
		group4.add(q4b4);

		p.add(q4b1);
		p.add(q4b2);
		p.add(q4b3);
		p.add(q4b4);

		// question 5
		JLabel q5 = new JLabel("5) Customer service experience?");
		q5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		q5.setBounds(10, 410, 300, 20);
		p.add(q5);

		q5b1 = new JRadioButton("Satisfied");
		q5b2 = new JRadioButton("Neutral");
		q5b3 = new JRadioButton("Unsatisfied");
		q5b4 = new JRadioButton("N/A");

		q5b1.setBounds(10, 430, 100, 20);
		q5b1.setBackground(new Color(172, 216, 230));
		q5b1.setActionCommand("Satisfied");

		q5b2.setBounds(130, 430, 100, 20);
		q5b2.setBackground(new Color(172, 216, 230));
		q5b2.setActionCommand("Neutral");

		q5b3.setBounds(250, 430, 100, 20);
		q5b3.setBackground(new Color(172, 216, 230));
		q5b3.setActionCommand("Unsatisfied");

		q5b4.setBounds(370, 430, 100, 20);
		q5b4.setBackground(new Color(172, 216, 230));
		q5b4.setActionCommand("N/A");

		group5 = new ButtonGroup();
		group5.add(q5b1);
		group5.add(q5b2);
		group5.add(q5b3);
		group5.add(q5b4);

		p.add(q5b1);
		p.add(q5b2);
		p.add(q5b3);
		p.add(q5b4);

		// final buttons

		submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(180, 510, 100, 25);
		submit.addActionListener(this);
		p.add(submit);

		back = new JButton("EXIT");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(330, 510, 100, 25);
		back.addActionListener(this);
		p.add(back);

		Image im1 = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(im1);
		setSize(650, 650);
		setLocation(450, 50);
		// setLayout(null);
		setResizable(false);
		getContentPane().setBackground(new Color(249, 246, 238));
		setVisible(true);

		// System.out.println(getSize());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String que1 = null, que2 = null, que3 = null, que4 = null, que5 = null;

		if (e.getSource() == submit) {
			// question1

			boolean proceed = true; // initially proceed is true

			try {
				que1 = group1.getSelection().getActionCommand();
				que2 = group2.getSelection().getActionCommand();
				que3 = group3.getSelection().getActionCommand();
				que4 = group4.getSelection().getActionCommand();
				que5 = group5.getSelection().getActionCommand();

			} catch (Exception ae) {
				proceed = false;  // if user does not answer all the questions of the form proceed will be set to false, and if proceed is false it wont go further
				System.out.println("User did not answer all the questions");
				JOptionPane.showMessageDialog(null, "All questions must be answered");
			}

			if (proceed != false) {
				try {

					String query = "insert into feedback values('" + fullName + "', '" + meter + "', '" + atype
							+ "', '" + que1 + "', '" + que2 + "', '" + que3 + "', '" + que4 + "', '" + que5 + "')";

					Conn c = new Conn();
					c.s.executeUpdate(query);

					JOptionPane.showMessageDialog(null, "Your response added successfully!");
					setVisible(false);

				}

				catch (Exception ae) {
					ae.printStackTrace();
				}
			}

		}

		else if (e.getSource() == back) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Feedback("", "", "");
	}

}
