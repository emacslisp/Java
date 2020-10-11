package com.dw.leetcode;
import java.util.*;

public class MaximalNetworkRank_5536 {
	public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, List<Integer>> inMap = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, List<Integer>> outMap = new HashMap<Integer, List<Integer>>();
        
        for(int i=0;i<roads.length;i++) {
        	int x = roads[i][0];
        	int y = roads[i][1];
        	
        	List<Integer> tx = inMap.get(x);
        	
        	if(tx == null) {
        		inMap.put(x, new ArrayList<Integer>());
        		tx = inMap.get(x);
        	}
        	
        	tx.add(y);
        	
        	List<Integer> ty = outMap.get(y);
        	
        	if(ty == null) {
        		outMap.put(y, new ArrayList<Integer>());
        		ty = outMap.get(y);
        	}
        	
        	ty.add(x);
        }
        
        int maxSum = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0;j<n;j++) {
        		if(i==j) {
        			continue;
        		}
        		int sum = 0;
        		List<Integer> t1 = inMap.get(i);
        		if(t1 != null) {
        			sum+=t1.size();
        		}
        		List<Integer> t2 = outMap.get(i);
        		if(t2 != null) {
        			sum+=t2.size();
        		}
        		
        		t1 = inMap.get(j);
        		if(t1 != null) {
        			sum+=t1.size();
        			if(t1.contains(i)) {
        				sum -=1;
        			}
        		}
        		
        		t2 = outMap.get(j);
        		if(t2 != null) {
        			sum+=t2.size();
        			if(t2.contains(i)) {
        				sum -=1;
        			}
        		}
        		
        		if(maxSum < sum) {
        			maxSum = sum;
        		}
        	}
        }
        
        return maxSum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
		
		MaximalNetworkRank_5536 s = new MaximalNetworkRank_5536();
		
		int result = s.maximalNetworkRank(n, roads);
		System.out.println(result);
	}

}
