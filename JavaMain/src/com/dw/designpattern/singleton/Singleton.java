package com.dw.designpattern.singleton;

public class Singleton {
	 //create an object of SingleObject
	   private static Singleton instance = new Singleton();

	   //make the constructor private so that this class cannot be
	   //instantiated
	   private Singleton(){}

	   //Get the only object available
	   //but this is not thread safe
	   /*
	   public static Singleton getInstance(){
	      return instance;
	   }*/
	   
	   public static Singleton getInstance() {
		    if (instance == null) {
		        synchronized (Singleton.class) {
		            if (instance == null){
		                Singleton t = new Singleton();
		                instance = t;
		            }
		        }
		    }
		    return instance;
		}

	   public void showMessage(){
	      System.out.println("Hello World!");
	   }
}
