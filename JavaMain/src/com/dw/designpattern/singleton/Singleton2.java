package com.dw.designpattern.singleton;

public class Singleton2 {
	public static Singleton2 getInstance(){
	    return NestedClass.instance;
	}

	private static class NestedClass{
	    private static Singleton2 instance = new Singleton2();
	}
	
	public void showMessage() {
		System.out.println("Singleton using nested static class");
	}
}
