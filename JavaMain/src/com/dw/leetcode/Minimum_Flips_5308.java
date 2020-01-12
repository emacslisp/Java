package com.dw.leetcode;

public class Minimum_Flips_5308 {
	
    public int minFlips(int a, int b, int c) {
        int result = 0;

        int counter = 32;
        while ((counter--) > 0) {
        	int al = a&1;
        	int bl = b&1;
        	int cl = c&1;
        	
        	a >>= 1;
        	b >>= 1;
        	c >>= 1;

        	if ((al | bl) == cl) {
        		continue;
        	}
        	else {
        		if(cl == 0) {
        			if(al != 0) result++;
        			if(bl != 0) result++;
        		}
        		
        		if (cl == 1) {
        			result++;
        		}
        	}
        	
        	
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Flips_5308 s= new Minimum_Flips_5308();
		
		System.out.println(s.minFlips(176, 543, 20));
	}

}
