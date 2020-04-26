package com.dw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    	
    	HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    	int maxRow = 0;
        for(int i=0;i<nums.size();i++) {
        	int row = nums.get(i).size();

        	for(int j=0;j< row;j++) {
        		if(map.get(i+j) == null) {
        			map.put(i+j, new ArrayList<Integer>());
        		}
        		
        		ArrayList<Integer> list = map.get(i+j);
        		
        		list.add(nums.get(i).get(j));
        		
        		if(maxRow < i+j) {
        			maxRow = i+j;
        		}
        	}
        }
        
        List<Integer> temp = new ArrayList<Integer>();
        for(int i=0;i<=maxRow;i++) {
        	ArrayList<Integer> list = map.get(i);
        	for(int j=list.size()-1;j>=0;j--) {
        		temp.add(list.get(j));
        	}
        }
        int[] result = new int[temp.size()];
        int c = 0;
        for(Integer x: temp) {
        	result[c++] = x;
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] s = {{1,2,3,4,5},{6,7},{8},{9,10,11},{12,13,14,15,16}};
		
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		
		for(int i=0;i<s.length;i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int j=0;j<s[i].length;j++) {
				temp.add(s[i][j]);
			}
			nums.add(temp);
		}
		DiagonalTraverseII x = new DiagonalTraverseII();
		
		int[] result = x.findDiagonalOrder(nums);
		
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}

}
