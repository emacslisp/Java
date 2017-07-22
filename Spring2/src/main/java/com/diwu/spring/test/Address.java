package com.diwu.spring.test;

public class Address {
	private String street;
	private String postcode;
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + "]";
	}

	public void init() {
		System.out.println("Address init.");
	}
	
	public void destroy() {
		System.out.println("Address destroy.");
	}
	
	public Address(String street, String postcode) {
		this.street = street;
		this.postcode = postcode;
	}
}
