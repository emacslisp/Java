package com.dw.leetcode;

public class Find_N_Unique_Integers_Sum_up_to_Zero_5295 {
	public int[] sumZero(int n) {
		if(n == 0) return new int[]{0};
        int[] result = new int[n];
        
        if(n%2 == 0) {
        	int max = -1 * n/2;
        	
        	for(int i = 0;i<n/2;i++) {
        		result[i] = max+i;
        	}
        	
        	for(int i = 0;i<n/2;i++) {
        		result[n/2+i] = (i+1);
        	}
        } else {
        	int max = -1 * (n - 1)/2;
        	for(int i = 0;i<n;i++) {
        		result[i] = max+i;
        	}
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_N_Unique_Integers_Sum_up_to_Zero_5295 s = new Find_N_Unique_Integers_Sum_up_to_Zero_5295();
		
		int[] result = s.sumZero(0);
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i] + "\t");
		}
		System.out.println();
	}

}
