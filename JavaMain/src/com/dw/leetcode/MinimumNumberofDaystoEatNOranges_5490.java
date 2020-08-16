package com.dw.leetcode;

import java.util.HashMap;

public class MinimumNumberofDaystoEatNOranges_5490 {
	
	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	public int minDays(int n) {
		
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.put(3, 2);
		
		
		
		return foo(n);
    }
	
	public int foo(int n) {		
		if(hashMap.containsKey(n))
			return hashMap.get(n);
		
		int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c = Integer.MAX_VALUE;
		
		if(n%3 == 0 && n%2 == 0) {
			b = foo(n/3) + 1;
			a = foo(n/2) + 1;
		} 
		else if (n%3 == 0) {
			
			b = foo(n/3) + 1;
			c = foo(n - 1) + 1;
			
			
		}
		else if(n%2 == 0) {
			a = foo(n/2) + 1;
			
			c = foo(n - 1) + 1;
		}
		else {
			c = foo(n - 1) + 1;
		}
		
		int d = Math.min(Math.min(a,  b), c);
		
		hashMap.put(n, d);
		return d;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumNumberofDaystoEatNOranges_5490 s = new MinimumNumberofDaystoEatNOranges_5490();
		int n = 84806671;
		
		int result = s.minDays(n);
		System.out.println(result);
	}

}
