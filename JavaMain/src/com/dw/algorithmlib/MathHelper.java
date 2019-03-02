package com.dw.algorithmlib;

public class MathHelper {
	
    public boolean isSquare(int n) {
    	int t = (int)Math.sqrt(n);
    	
    	return t*t == n;
    }
    
    // @todo: add two large number using String
    public String add(String num1, String num2) {
    	int maxLength = num1.length() > num2.length()? num1.length() : num2.length();
    	int minLenght = num1.length() > num2.length()? num2.length() : num1.length();
    	
    	char[] result = new char[maxLength];
    	
    	return new String(result);
    }
    
    // @todo: multiply two large number using String
    public String Multiple(String num1, String num2) {
    	String result = "";
    	
    	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
