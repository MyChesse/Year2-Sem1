package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
	
	public static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		String username = "root" ;
		String password = "y1234";
		
		Class.forName("com.mysql.jdbc.Driver");	
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/tezt?characterEncoding=utf8",username,password);
		
		return com;
	}
	

	
}
