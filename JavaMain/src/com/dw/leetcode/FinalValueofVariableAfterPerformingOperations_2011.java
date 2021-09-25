package com.dw.leetcode;

import java.util.HashMap;

public class FinalValueofVariableAfterPerformingOperations_2011 {

    public int finalValueAfterOperations(String[] operations) {
    	HashMap<String, Integer> map = new HashMap<>();
    	
    	map.put("X++", 1);
    	map.put("++X", 1);
    	map.put("X--", -1);
    	map.put("--X", -1);
    	int result = 0;
    	for(String x:operations) {
    		result += map.get(x);
    	}
    	
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
