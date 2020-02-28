package com.dw.leetcode;

public class ClosestDivisors_1362 {
    public int[] closestDivisors(int num) {
        int[] result1 = new int[2];
        int[] result2 = new int[2];
        
        int num1 = num + 1;
        int num2 = num + 2;
        
        int[] interval = new int[2];
        for(int i=(int) Math.sqrt(num1); i >= 0;i--) {
        	if(num1 % i == 0) {
        		interval[0] = num1/i - i;
        		result1[0] = i;
        		result1[1] = num1/i;
        		break;
        	}
        }
        
        for(int i=(int) Math.sqrt(num2); i >= 0;i--) {
        	if(num2 % i == 0) {
        		interval[1] = num2/i - i;
        		result2[0] = i;
        		result2[1] = num2/i;
        		break;
        	}
        }
        
        if(interval[0] < interval[1]) {
        	return result1;
        }
        
        return result2;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestDivisors_1362 s = new ClosestDivisors_1362();
		int[] result = s.closestDivisors(999);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}
