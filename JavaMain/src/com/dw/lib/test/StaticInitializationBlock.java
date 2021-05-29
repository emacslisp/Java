package com.dw.lib.test;

public class StaticInitializationBlock {
	
	static  
    {  
        System.out.println("STATIC BLOCK");  
    } 
	
	public StaticInitializationBlock() {
		System.out.println("constructor");
	}

	public static void main(String[] args) {

		StaticInitializationBlock block = new StaticInitializationBlock();
		
		System.out.println("MAIN METHOD");
		
	}

}
