package com.dw.leetcode;

public class TwoFurthestHousesWithDifferentColors_5930 {

    public int maxDistance(int[] colors) {
    	int result = 0;
    	for(int i=0;i<colors.length;i++) {
    		for(int j=i+1;j<colors.length;j++) {
    			if(colors[i]!=colors[j]) {
    				int diff = Math.abs(j-i);
    				if(diff > result) {
    					result = diff;
    				}
    			}
    		}
    	}
    	
    	return result;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] colors = {1,8,3,8,3};
		TwoFurthestHousesWithDifferentColors_5930 t = new TwoFurthestHousesWithDifferentColors_5930();
		
		int result = t.maxDistance(colors);
		System.out.println(result);
	}

}
