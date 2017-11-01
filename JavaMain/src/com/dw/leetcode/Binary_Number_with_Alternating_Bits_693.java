package com.dw.leetcode;

public class Binary_Number_with_Alternating_Bits_693 {
	public static boolean hasAlternatingBits(int n) {
        
		if (n<=0) return false;
		int temp = n;
		int start = temp%2;
		temp /= 2;
		while(temp>0) {
			
			if(start == temp%2)
				return false;
			
			start = temp%2;
			temp /=2;
		}
		
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hasAlternatingBits(10));
	}

}
