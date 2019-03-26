package com.dw.amazon;

import java.util.*;

public class cells {
	
    public List<Integer> cellCompete(int[] states, int days)
    {
    	 List<Integer> result = new ArrayList<Integer>();
    	 
    	 int start = 0;
    	 int end = 0;
    	 
    	 for(int i=0;i<days;i++) {
    		 if(i>0) {
    			 int counter = 0;
    			 for(Integer m : result) {
    				 states[counter++] = m;
    			 }
    			 
    			 result.clear();
    		 }
    		 
    		 for(int k=0;k<states.length;k++) {
    			 if (k == 0 ) {
    				 result.add(states[1] == start? 0 : 1);
    				 continue;
    			 }
    			 
    			 if(k == states.length - 1) {
    				 result.add(states[k-1] == end? 0: 1);
    				 continue;
    			 }
    			 
    			 result.add(states[k-1] == states[k+1]? 0: 1);
    		 }
    	 }
    	 
    	 return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cells c= new cells();
		// int[] states = {1, 0, 0, 0, 0, 1, 0, 0};
		int[] states = {1, 1, 1, 0, 1, 1, 1, 1};
		int days = 2;
		List<Integer> result = c.cellCompete(states, days);
		
		for(Integer i : result) {
			System.out.print(i + "\t");
		}
	}

}
