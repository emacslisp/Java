package com.dw.leetcode;

public class PeakIndexinaMountainArray_852 {
    public static int peakIndexInMountainArray(int[] A) {
    	
        int result = 1;
        for(int i=1;i<A.length;i++) {
        	if(A[i]>A[i-1]) {
        		continue;
        	}
        	else {
        		result = i;
        		break;
        	}
        }
        
        return result - 1;
    }
    
	public static void main(String[] args)
	{
		int[] A = {0,2,1,0};
		System.out.println(peakIndexInMountainArray(A));
	}
}
