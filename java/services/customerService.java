package services;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import module.customer;
import utils.dbconnect;

public class customerService {

	public customer regcoustomer(customer cus) {
	    try {
	        Statement statement = dbconnect.getconnection().createStatement();

	        // Insert the customer
	        String insertQuery = "INSERT INTO customer (email, name, password) VALUES ('"
	                + cus.getEmail() + "','" + cus.getName() + "','" + cus.getPassword() + "')";
	        statement.executeUpdate(insertQuery);

	        // Now retrieve the inserted data
	        String selectQuery = "SELECT * FROM customer WHERE email = '" + cus.getEmail() + "'";
	        ResultSet rs = statement.executeQuery(selectQuery);

	        if (rs.next()) {
	            cus.setEmail(rs.getString("email"));
	            cus.setName(rs.getString("name"));
	            cus.setPassword(rs.getString("password"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return cus;
	}
	
	public boolean validate(customer cus) {
		
		try {
			
			String query = "SELECT * FROM customer WHERE email = '"+cus.getEmail()+"' and password = '"+cus.getPassword()+"'";
			
			Statement statement = dbconnect.getconnection().createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();


		}
		return false;
	}
	
	
	public ArrayList<customer> getAllcustomer(){
		try {
			ArrayList<customer> listCus = new ArrayList<customer>();
			
			String query = "select * from customer";
			
			
			Statement statement = dbconnect.getconnection().createStatement();
			 ResultSet rs = statement.executeQuery(query);
			 
			 //print loop
			 
			 while(rs.next()) {
				 customer cus = new customer();
				 cus.setEmail(rs.getString("email"));
				 cus.setName(rs.getString("name"));
		         cus.setPassword(rs.getString("password"));
				 listCus.add(cus);
			 }
			return listCus;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
	}
	
	
	public void updateCustomer (customer cus) {
		
		try {
			
			String query = "Update customer SET email = '"+cus.getEmail()+"',name = '"+cus.getName()+"',password ='"+cus.getPassword()+"' where email='"+cus.getEmail()+"' ";
			
			
			Statement statement =  dbconnect.getconnection().createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer (customer cus) {
		try {
			String query = "Delete from customer where email = '"+cus.getEmail()+"'";
			
			Statement statement =  dbconnect.getconnection().createStatement(); //get the connection of db
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
 