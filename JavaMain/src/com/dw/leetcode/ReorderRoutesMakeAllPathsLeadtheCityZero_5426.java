package com.dw.leetcode;

import java.util.*;

public class ReorderRoutesMakeAllPathsLeadtheCityZero_5426 {
	private int bfs(int src, HashMap<Integer, List<Integer>> inMap, HashMap<Integer, List<Integer>> outMap, boolean[] visited) {
		int counter = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(src);
		
		visited[src] = true;
		// System.out.println("Point " + src + " is visited");
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			List<Integer> n = inMap.get(node);
			
			if(n !=null) {
				for(int m : n) {
					if(!visited[m]) {
						visited[m] = true;
						queue.offer(m);
					}
				}
			}
			
			List<Integer> out = outMap.get(node);
			
			if(out !=null) {
				for(int m : out) {
					if(!visited[m]) {
						visited[m] = true;
						queue.offer(m);
						counter++;
					}
				}
			}
		}
		
		return counter;
	}
    public int minReorder(int n, int[][] connections) {
     
    	HashMap<Integer, List<Integer>> inMap = new HashMap<Integer, List<Integer>>();
    	HashMap<Integer, List<Integer>> outMap = new HashMap<Integer, List<Integer>>();
    	
    	for(int i=0;i<connections.length;i++) {
    		if (inMap.get(connections[i][1]) == null) {
    			inMap.put(connections[i][1], new ArrayList<Integer>());
    		}
    		
    		List<Integer> t = inMap.get(connections[i][1]) ;
    		
    		t.add(connections[i][0]);
    		
    		if (outMap.get(connections[i][0]) == null) {
    			outMap.put(connections[i][0], new ArrayList<Integer>());
    		}
    		
    		List<Integer> t1 = outMap.get(connections[i][0]) ;
    		
    		t1.add(connections[i][1]);
    	}
    	
    	boolean[] visited = new boolean[n];

    	int total = 0;
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                total += bfs(v, inMap, outMap, visited);
            }
        }
    	
    	return total;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderRoutesMakeAllPathsLeadtheCityZero_5426 s = new ReorderRoutesMakeAllPathsLeadtheCityZero_5426();
		int n = 3;
		int[][] connections = {{1,0},{2, 0}};
		System.out.println(s.minReorder(n, connections));
	}

}
