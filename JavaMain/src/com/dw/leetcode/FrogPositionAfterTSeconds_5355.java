package com.dw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class FrogPositionAfterTSeconds_5355 {
	int levelTo = 0;
	int parentNode = 0;
	LinkedList<Integer> list = new LinkedList<Integer>();
	
    public double frogPosition(int n, int[][] edges, int t, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i=0;i<edges.length;i++) {
    		if(map.get(edges[i][0]) == null) {
    			map.put(edges[i][0], new ArrayList<Integer>());
    		}
    		
    		if(map.get(edges[i][1]) == null) {
    			map.put(edges[i][1], new ArrayList<Integer>());
    		}
    		
    		 ArrayList<Integer> nodes = map.get(edges[i][0]);
    		 nodes.add(edges[i][1]);
    		 
    		 map.get(edges[i][1]).add(edges[i][0]);
        }
    	boolean visit[] = new boolean[n+1];
    	for(int i=0;i<visit.length;i++) {
    		visit[i] = false;
    	}
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        dfs(map, 1, target, 0, stack, visit);
        if(levelTo > t) return 0;
        
        // very strange but have to do that
    	if(target == 1 && (map.get(target) == null || map.get(target).size() == 0)) { 
    		return 1;
    	}
    	else if (target == 1 && map.get(target).size() > 0) {
    		return 0;
    	}
    	
        if(levelTo < t) {
        	if( map.get(target).size() > 1) return 0;
        }
        
        if(list.size() == 0) return 0;
        
        double result = 1;
        for(int x : list) {
        	if(x==1)
        		result *= (double)1/(double)(map.get(x).size());
        	else
        		result *= (double)1/(double)(map.get(x).size() - 1);
        }
        
        return result;
    }
    
    
	void dfs (HashMap<Integer, ArrayList<Integer>> map, int root, int target, int level,  Stack<Integer> stack, boolean visit[]) {
		if(map.get(root) == null) {
			return;
		}
		
		if(root == target) {
			levelTo = level;
		}
		
		visit[root] = true;
		
		ArrayList<Integer> nodes = map.get(root);
		
		for(int p : nodes) {
			if(visit[p]) continue;
			
			if(p == target) {
				parentNode = root;
				levelTo = level + 1;
				stack.forEach(x -> {
					list.add(x);
		        });
				return;
			}
			
			stack.push(p);
			dfs(map, p, target, level + 1, stack, visit);
			stack.pop();
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[][] edges = {
				{2, 1},
				{3, 2},
				{4, 1},
				{5, 1},
				{6, 4},
				{7, 1},
				{8, 7}
		};
		
		int n = 8;
		int t = 7;
		int target = 7;*/
		
		/*
		int[][] edges = {
				{1, 2},
				{1, 3},
				{1, 7},
				{2, 4},
				{2, 6},
				{3, 5}
		};
		
		int n = 7;
		int t = 20;
		int target = 6;*/
		
		int[][] edges = {
				{2, 1},
				{3, 2},
				{4, 1}
		};
		
		int n = 4;
		int t = 4;
		int target = 1;
		
		FrogPositionAfterTSeconds_5355 s = new FrogPositionAfterTSeconds_5355();
		
		System.out.println(s.frogPosition(n, edges, t, target));
	}

}
