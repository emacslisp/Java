package com.dw.amazon;

public class GCD {
	
	int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
	
	int findGCDInArray(int arr[], int n) 
    { 
        int result = arr[0]; 
        for (int i = 1; i < n; i++) 
            result = gcd(arr[i], result); 
  
        return result; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 4, 6, 8, 10};
		int num = 5;
		
		GCD gcd = new GCD();
		System.out.println(gcd.findGCDInArray(arr, num));
	}

}
