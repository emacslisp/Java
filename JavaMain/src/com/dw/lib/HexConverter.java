package com.dw.lib;

public class HexConverter {
	
	public String decHex(int number, int base) {
		String letterTable = "0123456789ABCDEF";
		
		int n = number;
		StringBuilder sb = new StringBuilder();
		do {
			sb.append(letterTable.charAt(n%base));
			n = n/base;
		} while(n > 0);
		return sb.reverse().toString();
	}
	
	//@todo: create hex converter 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HexConverter converter = new HexConverter();
		System.out.println(converter.decHex(11000, 16));
	}

}
