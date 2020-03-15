package com.dw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
    	List<Integer> result = new ArrayList<Integer>();
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int m=0;m<matrix.length;m++) {
    	
    		int min = 1000000;
    		int minM = 0;
    		int minN = 0;
    		for(int n=0;n<matrix[0].length;n++) {
	    		// find min of column
	    		if(matrix[m][n] < min) {
	    			min = matrix[m][n];
	    			minM = m;
	    			minN = n;
	    		}
	    	}
    		
    		map.put(minM*matrix[0].length + minN, 1);

    	}
    	
    	for(int n=0;n<matrix[0].length;n++) {
    		int max = 0;
    		int maxM = 0;
    		int maxN = 0;
    		for(int m=0;m<matrix.length;m++) {
    			// find max of row
    			if(matrix[m][n] > max) {
    				max = matrix[m][n];
    				maxM = m;
    				maxN = n;
    			}
    		}
    		
	    	
	    	if(map.get(maxM*matrix[0].length + maxN) != null) {
	    		result.add(matrix[maxM][maxN]);
	    	}
    	}
    	
    	
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		
		LuckyNumbersInAMatrix s = new LuckyNumbersInAMatrix();
		List<Integer> result = s.luckyNumbers(matrix);
		
		for(Integer m: result) {
			System.out.println(m);
		}
	}

}
