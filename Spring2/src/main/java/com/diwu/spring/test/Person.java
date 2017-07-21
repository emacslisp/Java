package com.diwu.spring.test;

import java.security.acl.Permission;

public class Person {
	private int id;
	private String name;
	
	private int taxId;
	


	public Person() {
		
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + "]";
	}
	
	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void speak() {
		System.out.println("This is person class!!!");
	}
}
