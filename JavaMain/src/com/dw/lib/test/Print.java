package com.dw.lib.test;

public class Print {
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		String p = "/asdf/asdf/i";
		String[] inputs = p.split("/");
		for(String x: inputs) {
			System.out.println(x);
		}
	}
}
