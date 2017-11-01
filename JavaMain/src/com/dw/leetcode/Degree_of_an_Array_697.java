package com.dw.leetcode;

import java.util.HashMap;

public class Degree_of_an_Array_697 {
	
	public static class Node {
		public int counter = 0;
		public int positionMin = 0;
		public int positionMax = 0;
	}

    public static int findShortestSubArray(int[] nums) {
    	
    	if(nums == null || nums.length == 0) return 0;
        
        HashMap<Integer, Node> hMap = new HashMap<>();
        int counter = 1;
        for(int i = 0;i<nums.length;i++) {
        	if(hMap.get(nums[i]) == null) {
        		Node node = new Node();
        		node.counter = 1;
        		node.positionMin = i;
        		node.positionMax = i;
        		hMap.put(nums[i], node);
        	}
        	else {
        		Node node = hMap.get(nums[i]);
        		node.counter++;
        		
        		if(node.counter > counter)
        			counter = node.counter;
        		
        		if(i < node.positionMin)
        			node.positionMin = i;
        		
        		if(i > node.positionMax) 
        			node.positionMax = i;
        		
        		hMap.put(nums[i], node);
        	}
        		
        }
        
        int max = Integer.MAX_VALUE;
        
        for(int i : hMap.keySet()) {
        	Node node = hMap.get(i);
        	if(node.counter == counter) {
        		int len = node.positionMax - node.positionMin;
        		if(len < max)
        			max = len;
        	}
        }
        
        return max + 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1};
		
		System.out.println(findShortestSubArray(array));
	}

}
