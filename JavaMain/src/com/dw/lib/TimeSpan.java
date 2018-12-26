package com.dw.lib;

public class TimeSpan {
	
	long start = System.nanoTime();
	
	public TimeSpan() {
		
	}
	
	public long span() {
		long end = System.nanoTime();
		return (end - start)/1000000;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
