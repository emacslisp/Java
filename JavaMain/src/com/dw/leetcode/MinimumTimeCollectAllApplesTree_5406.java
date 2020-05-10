package com.dw.leetcode;

import java.util.*;

// https://leetcode.com/contest/weekly-contest-188/problems/minimum-time-to-collect-all-apples-in-a-tree/
public class MinimumTimeCollectAllApplesTree_5406 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    
    	boolean hasNothing = true;
    	for(boolean x: hasApple) {
    		if (x) {
    			hasNothing = false;
    			break;
    		}
    	}
    	
    	if(hasNothing) {
    		return 0;
    	}
    	
    	 HashMap<Integer, List<Integer>> graph = new HashMap<>();
    	 
    	 for(int i=0;i<edges.length;i++) {
			 if(graph.get(edges[i][0]) == null) {
				 graph.put(edges[i][0], new ArrayList<Integer>());
			 }
			 List<Integer> list = graph.get(edges[i][0]);
			 list.add(edges[i][1]);
    	 } 	 
    	
         int result =  dfs(0, graph, hasApple);

    	 
    	 return result*2;
    	
    }
    
    private int dfs(int src, HashMap<Integer, List<Integer>> graph, List<Boolean> hasApple) {
    	
    	List<Integer> n = graph.get(src);
    	
    	if (n == null) {
    		return 0;
    	}
    	
    	int result = 0;
    	for(Integer x : n) {
    		int t = dfs(x, graph, hasApple);
    		
    		if(t > 0) {
    			t += 1;
    		}
    		
    		if(t == 0 && hasApple.get(x)) {
    			t += 1;
    		}
    		
    		result += t;
    	}
    	
    	return result;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumTimeCollectAllApplesTree_5406 s = new MinimumTimeCollectAllApplesTree_5406();
		int n = 4;
		
		boolean[] arr = {true, true, true, true};
		List<Boolean> hasApple = new ArrayList<Boolean>();
		int[][] edges = {
				{0,1},{1,2},{0,3}
		};
		
		for(int i=0;i<arr.length;i++) {
			hasApple.add(arr[i]);
		}
		
		System.out.println(s.minTime(n, edges, hasApple));
	}

}
