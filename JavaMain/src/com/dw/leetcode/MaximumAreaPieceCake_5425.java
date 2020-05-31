package com.dw.leetcode;

import java.util.Arrays;

public class MaximumAreaPieceCake_5425 {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int[] hc = new int[horizontalCuts.length + 2];
        int[] vc = new int[verticalCuts.length + 2];
        
        hc[0] = 0;
        hc[hc.length - 1] = h;
        
        for(int i=0;i<horizontalCuts.length;i++) {
        	hc[i+1] = horizontalCuts[i];
        }
        
        vc[0] = 0;
        vc[vc.length - 1] = w;
        for(int i=0;i<verticalCuts.length;i++) {
        	vc[i+1] = verticalCuts[i];
        }
        
        long maxInterval = 0;
        
        for(int i=0;i<hc.length - 1;i++) {
        	if(hc[i+1] - hc[i] > maxInterval) {
        		maxInterval = hc[i+1] - hc[i];
        	}
        }
        
        long maxIntervalV = 0;
        
        for(int i=0;i<vc.length - 1;i++) {
        	if(vc[i+1] - vc[i] > maxIntervalV) {
        		maxIntervalV = vc[i+1] - vc[i];
        	}
        }
        
        long result = (maxInterval * maxIntervalV) % 1000000007L;
        
        return (int) result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumAreaPieceCake_5425 s = new MaximumAreaPieceCake_5425();
		int h = 50;
		int w = 14;
		int[] horizontalCuts = {37,40,41,30,27,10,31};
		int[] verticalCuts = {2,1,9,5,4,12,6,13,11};
		System.out.println(s.maxArea(h, w, horizontalCuts, verticalCuts));
	}

}
