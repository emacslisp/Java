package com.dw.leetcode;

import java.util.*;

public class MaximumNumberofAchievableTransferRequests_5526 {
	public int maximumRequests(int n, int[][] requests) {
        HashMap<Integer, List<Integer>> inMap = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, List<Integer>> outMap = new HashMap<Integer, List<Integer>>();
        
        for(int i=0;i<n;i++) {
        	inMap.put(i, new ArrayList<Integer>() );
        	outMap.put(i, new ArrayList<Integer>() );
        }
        
        for(int i=0;i<requests.length;i++) {
        	int s = requests[i][0];
        	int e = requests[i][1];

        	List<Integer> list = inMap.get(s);
        	list.add(e);

        	List<Integer> outList = outMap.get(e);
        	outList.add(s);
        }
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++) {
        	if(inMap.get(i) != null && outMap.get(i) != null 
        			) {
        		result.put(i, Math.min(inMap.get(i).size(), outMap.get(i).size()));
        	}
        }
        
        int counter=0;
        for(int i=0;i<n;i++) {
        	if(result.get(i) != null) {
        		System.out.println(i + " " + result.get(i));
        		counter += result.get(i);
        	}
        }
        return counter;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumNumberofAchievableTransferRequests_5526 s = new MaximumNumberofAchievableTransferRequests_5526();
		int n = 3;
		int[][] requests = {{0,0},{1,1},{0,0},{2,0},{2,2},{1,1},{2,1},{0,1},{0,1}};
		int result = s.maximumRequests(n, requests);
		System.out.println(result);
	}

}
