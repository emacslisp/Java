package com.diwu.spring.test;

import java.security.acl.Permission;

public class Person {
	private int id;
	private String name;
	
	private int taxId;
	
	private Address address;

	public Address getAddress() {
		return address;
	}
	
	
	public static Person getInstance(int id, String name) {
		System.out.println("Creating Person using factory method.");
		return new Person(id,name);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person() {
		
	}
	
	public void onCreate() {
		System.out.println("Person created: " + this);
	}
	
	public void onDestroy() {
		System.out.println("Person destory");
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + ", address=" + address + "]";
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