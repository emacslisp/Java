package com.dw.leetcode;

public class CountNumberTeams_5369 {
	public int numTeams(int[] rating) {
        int result = 0;
        
        for(int i=0;i<rating.length-2;i++) {
        	for(int j=i+1;j<rating.length - 1;j++) {
        		for(int k=j+1;k<rating.length;k++) {
        			if(rating[i] < rating[j] && rating[j] < rating[k]) {
        				result++;
        			} else if(rating[i] > rating[j] && rating[j] > rating[k]) {
        				result++;
        			}
        		}
        	}
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountNumberTeams_5369  s = new CountNumberTeams_5369();
		int[] rating = {1,2,3,4};
		System.out.println(s.numTeams(rating));
	}

}
