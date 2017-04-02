package com.dw.leetcode;

/*
 * 
 * */
public class Base_7_504 {

	public static String revert(String s)
	{
		char[] array = s.toCharArray();
		
		for(int i=0;i<array.length/2;i++) {
			char temp = array[i];
			array[i]=array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		
		return new String(array);
	}
	
	public static String convertToBase7(int num) {
	     String result = "";
	     if(num == 0) return "0";
	     int n = Math.abs(num);
	     
	     while(n>0)
	     {
	    	 int a = n%7;
	    	 n = (n-n%7)/7;
	    	 
	    	 result += ("" + a);
	     }
	     
	     String opStr = (num<0? "-" : "");
	     
	     return opStr + revert(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToBase7(-7));
	}

}
