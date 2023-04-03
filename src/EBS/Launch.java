package EBS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Launch extends JFrame implements Runnable {

	Thread t; // reference of thread class and object name

	Launch() {

		super("POWERSHELL CORPORATION");
		
		JLabel tagline = new JLabel("Your ultimate source of clean energy!");
		tagline.setForeground(Color.WHITE);
		tagline.setFont(new Font("Georgia", Font.HANGING_BASELINE, 25));
		tagline.setBounds(20, 20, 500, 50);
		add(tagline);

		// getting, scaling and adding a label(Image) to the frame
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Launch3.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);

		setVisible(true); // gotta show user from start how the frame opens

		// adding imageIcon for our app
		Image iconImage = new ImageIcon(ClassLoader.getSystemResource("icon/appIcon2.png")).getImage();
		setIconImage(iconImage);

		int x = 1;
		for (int i = 25; i <= 600; i += 3.5, x++) {
			setSize(i + x, i);
			setLocation(700 - ((i + x) / 2) + 80, 400 - (i / 2));
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// creating frame
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(Color.YELLOW);
		setVisible(true);

		t = new Thread(this); // new obj created of thread class
		t.start(); // to call run
	}

	@Override
	public void run() { // here we put a hold of 3 seconds before closing of this frame and opening of
						// next
		try {

			Thread.sleep(4000);
			setVisible(false);
			new Login();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void main(String[] args) {

		new Launch();

	}

}
