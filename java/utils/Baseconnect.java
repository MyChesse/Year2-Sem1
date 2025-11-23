package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Baseconnect {
	
     public static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		String username = "root" ;
		String password = "y1234";
		
		Class.forName("com.mysql.jdbc.Driver");	
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/marks?characterEncoding=utf8",username,password);
		
		return com;
	}

	public static Statement getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}


