package com.dw.leetcode;

//https://leetcode.com/contest/weekly-contest-186/problems/maximum-points-you-can-obtain-from-cards/
public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        
        int[] sl = new int[cardPoints.length];
        
        int[] sr = new int[cardPoints.length];
        
        sl[0] = cardPoints[0];
        sr[sr.length - 1] = cardPoints[sr.length - 1];
        
        for(int i=1;i<cardPoints.length;i++) {
        	sl[i] += sl[i-1] + cardPoints[i];
        }
        for(int i=cardPoints.length - 2;i>=0;i--) {
        	sr[i] += sr[i+1] + cardPoints[i];
        }
    	for (int i=-1;i<k;i++) {
    		
    		int left = 0;
    		int right = 0;
    		
    		if(i>=0)
    			left = sl[i];
    		
    		if(sr.length - k + i + 1 < sr.length)
    			right = sr[sr.length - k + i + 1];
    		
    		//System.out.println(sr.length - k - 1 + i);
    		
    		if(max < (left+right)) {
    			max = left+right;
    		}
    		
    	}
    	
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] cardPoints = {96,90,41,82,39,74,64,50,30};
		// int k = 8;
		
		int[] cardPoints = {2,2,2};
		int k = 2;
		
		MaximumPointsYouCanObtainfromCards x = new MaximumPointsYouCanObtainfromCards();
		System.out.println(x.maxScore(cardPoints, k));
	}

}
