package com.lab;

public class User {
	private String email;
	private String password;
	
	private String message;
	
	public User(String username, String password) {
		// TODO Auto-generated constructor stub
		this.email = username;
		this.password = password;
	}
	
	/*
	 * this constructor is for servlet useBean only
	 * since useBean would take default constructor with empty function
	 */
	public User() {
		
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public boolean validate() {
		
		if(this.email == null) {
			this.message = "No Email Address Set";
			return false;
		}
		
		if(!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
			message = "invalid email";
			return false;
		}
		
		if(this.password == null) {
			this.message = "No password Set";
			return false;
		}
		
		if(this.password.length() < 8) {
			message = "password must be at lease 8 characters.";
			return false;
		}
		else if(this.password.matches("\\w*\\s+\\w*")) {
			message = "password cannot contain space.";
			return false;
		}
		return true;
	}
}
