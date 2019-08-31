package com.dw.designpattern.singleton;

//@example: Java Design Pattern - Singleton Pattern
public class SingletonPattern {
	public static void main(String[] args) {

		// illegal construct
		// Compile Time Error: The constructor SingleObject() is not visible
		// SingleObject object = new SingleObject();

		// Get the only object available
		Singleton object = Singleton.getInstance();
		Singleton object1 = Singleton.getInstance();
		// show the message
		object.showMessage();

		System.out.println(object == object1);
		
		Singleton2 object2 = Singleton2.getInstance();
		Singleton2 object3 = Singleton2.getInstance();
		object2.showMessage();
		System.out.println(object2 == object3);
	}
}
