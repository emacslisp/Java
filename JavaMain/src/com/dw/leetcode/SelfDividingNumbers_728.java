package com.dw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	for(int i=left;i<=right;i++) {
    		
    		int t = i;
    		
    		boolean isTrue = true;
    		
    		while(t > 0) {
    			int b = t%10;
    			if(b == 0) {
    				isTrue = false;
    				break;
    			}
    			
    			if(i%b !=0 ) {
    				isTrue = false;
    				break;    				
    			}
    			    			
    			t= (t - b)/10;
    		}
    		
    		if(isTrue) {
    			result.add(i);
    		}
    		
    	}
    	
    	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelfDividingNumbers_728 s = new SelfDividingNumbers_728();
		
		for(Integer i : s.selfDividingNumbers(1,22)) {
			System.out.println(i);
		}
	}

}
