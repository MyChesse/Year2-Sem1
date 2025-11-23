package com.feedback;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	//step 1
	private static String url="jdbc:mysql://localhost:3306/examsite";
	private static String user ="root";
	private static String pass = "rashmika";
	private static Connection con; //connection object
	
	public static Connection getConnection() {
		//step 3
		try {
			Class.forName("com.mysql.jdbc.Driver"); //database connection class
			con = DriverManager.getConnection(url, user, pass);
			
		}
		//step 2
		catch(Exception e){ 
			System.out.println("Database connection is not success");
		}
		
		return con;
	}	
}
