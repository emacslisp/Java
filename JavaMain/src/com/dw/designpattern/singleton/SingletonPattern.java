package com.dw.designpattern.singleton;

//@example: Java Design Pattern - Singleton Pattern
public class SingletonPattern {
	   public static void main(String[] args) {

		      //illegal construct
		      //Compile Time Error: The constructor SingleObject() is not visible
		      //SingleObject object = new SingleObject();

		      //Get the only object available
		      Singleton object = Singleton.getInstance();
		      Singleton object1 = Singleton.getInstance();
		      //show the message
		      object.showMessage();
		      
		      System.out.println(object == object1);
		   }
}
