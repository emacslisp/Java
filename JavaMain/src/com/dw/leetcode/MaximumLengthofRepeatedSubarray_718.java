package com.dw.leetcode;

public class MaximumLengthofRepeatedSubarray_718 {
	
	public int findLength(int[] A, int[] B) {
        if(A == null || B == null) return 0;
        
        int[][] dp = new int[A.length +1][B.length+1];
        int maxLen = 0;
        for(int i=0;i<=A.length;i++) {
        	for(int j=0;j<=B.length;j++) {
        		if(i==0||j==0) 
        			dp[i][j] = 0;
        		else
        		if(A[i-1] ==B[j-1] ) {
        			dp[i][j]=dp[i-1][j-1]+1;
        		}
        		
        		if(maxLen < dp[i][j]) {
        			maxLen = dp[i][j];
        		}
        	}
        }
        
        return maxLen;
    }
	
	public static void main(String[] args) {
		MaximumLengthofRepeatedSubarray_718 s= new MaximumLengthofRepeatedSubarray_718();
		
		int[] A= {1,2,3,2,1, 4};
		int[] B= {3,2,1,4,7};
		
		System.out.println(s.findLength(A, B));
	}
}
