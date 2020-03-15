package com.dw.leetcode;

import java.util.HashMap;

public class MaximumPerformanceOfTeam_5359 {
	int max = 0;
	int gSpeed[];
	int gEfficiency[];
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		gSpeed = speed;
		gEfficiency = efficiency;
        
        int[] data = new int[k];
        
        int[] arr = new int[speed.length];
        
        
        int localMax = 0;
        for(int i=1;i<=k;i++) {
        	for(int j=0;j<arr.length;j++) {
            	arr[j] = j;
            }
        	
        	for(int j=0;j<data.length;j++) {
            	data[j] = 0;
            }
        	
        	
          combination(arr, data, 0, n-1, 0, i);
          if(localMax < max)
        	  localMax = max;
        }
       
        return localMax;
    }
	
	void combination(int[] arr, int[] data, int start, int end, int index, int k) {
		if (index == k) 
		{ 
			// a new combination
			int sum = 0;
			int minEff = 100000000;
			for (int j=0; j<k; j++) {
				sum+=gSpeed[data[j]];
				if(gEfficiency[data[j]] < minEff) {
					minEff = gEfficiency[data[j]];
				}
			}
			
			if(max < sum*minEff) {
				max = sum*minEff;
			}
			return;
		} 
		
		for (int i=start; i<=end && end-i+1 >= k-index; i++) 
		{ 
			data[index] = arr[i]; 
			combination(arr, data, i+1, end, index+1, k); 
		} 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumPerformanceOfTeam_5359 s = new MaximumPerformanceOfTeam_5359();
		int n = 6;
		int speed[] = {2,10,3,1,5,8};
		int efficiency[] = {5,4,3,9,7,2};
		int k = 4;
		int max = s.maxPerformance(n, speed, efficiency, k);
		System.out.println(max);
	}

}
