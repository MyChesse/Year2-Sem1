package com.feedback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static List<Feedback> validate(String userName, String password){
		
		ArrayList<Feedback> feed = new ArrayList<>();

		try {

			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from feedback where userName='" + userName + "' and password='" + password + "'";

			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id =rs.getInt(1);
				String name= rs.getString(2);
				String email= rs.getString(3);
				int phone= rs.getInt(4);
				String userU= rs.getString(5);
				String passU= rs.getString(6);
				
				Feedback f = new Feedback(id,name,email,phone,userU,passU);
				feed.add(f);
			}
			
		}
		catch(Exception e){ 
			e.printStackTrace(); //print the error
		}
		
		return feed;
	}
	
	public static boolean insertfeedback(String name, String email, String phone, String username, String password) {
		boolean isSuccess=false;
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into feedback values(0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')"; //Quarry (pass the values)
			int rs = stmt.executeUpdate(sql); //Can't use executeQuarry, Use executeUpdate 
			//Data insert successfully,executeUpdate return 1
			//Data insert unsuccessfully,executeUpdate return 0
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){ 
			e.printStackTrace(); //print the error	
		}
		
		return isSuccess; //return true or false to FeedbackInsert.java
	}
	
	public static boolean updatefeedback(String id, String name, String email, String phone, String username, String password) {
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			String sql = "update feedback set name = '"+name+"',email ='"+email+"',phone ='"+phone+"',username ='"+username+"',password ='"+password+"'"
						+ "where id = '"+id+"'"; //update the details for owner of this id
			int rs = stmt.executeUpdate(sql);
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){ 
			e.printStackTrace(); //print the error	
		} 
		
		return isSuccess;
	}
	
	public static List<Feedback> getFeedbackDetails(String id){
		
		int convertedId = Integer.parseInt(id);
		
		ArrayList<Feedback> feed = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			String sql = "select * from feedback where id='"+convertedId+"'"; //select all from feedback according to there id
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { //if entered id has details its true and show details
				int id1 = rs.getInt(1);
				String name = rs.getNString(2);
				String email = rs.getNString(3);
				int phone = rs.getInt(4);
				String username = rs.getNString(5);
				String password = rs.getNString(6);
				
				Feedback f = new Feedback(id1, name, email, phone, username, password);
				feed.add(f);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return feed;
	}
	
	public static boolean deleteFeedback(String id) {
		
		int feedId = Integer.parseInt(id);
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			String sql = "delete from feedback where id = '" + feedId + "'";
			int r = stmt.executeUpdate(sql);
			
			if(r>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
	

