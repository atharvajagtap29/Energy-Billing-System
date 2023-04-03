package EBS;

import java.sql.*;

// JDBC connection class

// making full JDBC connection in one class and using the object of that class every time 
public class Conn {
	
	Connection conn;
	Statement s;
	
	Conn(){
		
		try {
			
			// register the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricitybillingsystem", "root", "root");
			s = conn.createStatement();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
//		if(conn != null) {
//			System.out.println("Success");
//		}
	}
	
	public static void main(String[] args) {
		new Conn();
	}
}
