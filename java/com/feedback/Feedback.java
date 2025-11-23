package com.feedback;

public class Feedback {

	private int id;
	private String name;
	private String email;
	private int phone;
	private String userName;
	private String password; //NOT NEED
	public Feedback(int id, String name, String email, int phone, String userName, String password) {
			
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
		}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getPhone() {
		return phone;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
}