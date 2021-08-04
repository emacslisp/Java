package com.dw.leetcode;

import java.util.*;

public class WidestVerticalAreaetweenTwoPointsContainingNoPoints1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	for(int i=0;i<points.length;i++) {
    		list.add(points[i][0]);
    	}
    	
    	Collections.sort(list);
    	
    	int max = 0;
    	
    	for(int i=0;i<list.size()-1;i++) {
    		int temp = list.get(i+1) - list.get(i);
    		
    		if(max < temp) {
    			max = temp;
    		}
    	}
    	
    	return max;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WidestVerticalAreaetweenTwoPointsContainingNoPoints1637 s = new WidestVerticalAreaetweenTwoPointsContainingNoPoints1637();
		int[][] points={{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
		int result = s.maxWidthOfVerticalArea(points);
		System.out.println(result);
	}

}
