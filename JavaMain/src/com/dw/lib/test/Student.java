package com.dw.lib.test;

public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	public Student(int n, String firstName, String lastName) {
		studentId = n;
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public int getStudentID() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return String.format("%s %s", this.firstName,this.lastName);
	}
}