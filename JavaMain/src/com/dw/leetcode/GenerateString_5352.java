package com.dw.leetcode;

public class GenerateString_5352 {
	
	public String generateTheString(int n) {
		if(n == 1) return "a";
		
		String result = "";
		
		if (n%2 == 0) {
			for(int i=0;i<n-1;i++)
				result+= "a";
			
			result+="b";
		}
		else {
			for(int i=0;i<n-2;i++)
				result+= "a";
			
			result+="b";
			result+="c";
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateString_5352 s = new GenerateString_5352();
		System.out.println(s.generateTheString(3));
	}

}
