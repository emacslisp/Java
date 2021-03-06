package com.dw.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Number_of_Operations_to_Make_Network_Connected_5309 {
	public int makeConnected(int n, int[][] connections) {
        int result = 0;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            connect(graph, connection[0], connection[1]);
            connect(graph, connection[1], connection[0]);
        }
        
        int components = 0;
        int remainCables = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                remainCables += bfs(v, graph, visited);
                components++;
            }
        }
        
        int needCables = components - 1; // Need cable to connect components
        return remainCables >= needCables ? needCables : -1;
    }
	
	int bfs(int src, Map<Integer, List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        int numVertices = 1;
        HashSet<String> edges = new HashSet<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            if (graph.get(u) != null) {
                for (int v : graph.get(u)) {
                    edges.add(Math.min(u, v) + "_" + Math.max(u, v));
                    if (!visited[v]) {
                        visited[v] = true;
                        numVertices++;
                        q.offer(v);
                    }
                }
            }
        }
        return edges.size() - (numVertices - 1); // Return the remain number of cables
    }
	
	private void connect(Map<Integer, List<Integer>> graph, Integer v1, Integer v2) {
	        if (graph.get(v1) == null) graph.put(v1, new LinkedList<>());
	        graph.get(v1).add(v2);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] connections = {{17,51},{33,83},{53,62},{25,34},{35,90},{29,41},{14,53},{40,84},{41,64},{13,68},{44,85},{57,58},{50,74},{20,69},{15,62},{25,88},{4,56},{37,39},{30,62},{69,79},{33,85},{24,83},{35,77},{2,73},{6,28},{46,98},{11,82},{29,72},{67,71},{12,49},{42,56},{56,65},{40,70},{24,64},{29,51},{20,27},{45,88},{58,92},{60,99},{33,46},{19,69},{33,89},{54,82},{16,50},{35,73},{19,45},{19,72},{1,79},{27,80},{22,41},{52,61},{50,85},{27,45},{4,84},{11,96},{0,99},{29,94},{9,19},{66,99},{20,39},{16,85},{12,27},{16,67},{61,80},{67,83},{16,17},{24,27},{16,25},{41,79},{51,95},{46,47},{27,51},{31,44},{0,69},{61,63},{33,95},{17,88},{70,87},{40,42},{21,42},{67,77},{33,65},{3,25},{39,83},{34,40},{15,79},{30,90},{58,95},{45,56},{37,48},{24,91},{31,93},{83,90},{17,86},{61,65},{15,48},{34,56},{12,26},{39,98},{1,48},{21,76},{72,96},{30,69},{46,80},{6,29},{29,81},{22,77},{85,90},{79,83},{6,26},{33,57},{3,65},{63,84},{77,94},{26,90},{64,77},{0,3},{27,97},{66,89},{18,77},{27,43}};
		
		int n = 100;
		
		Number_of_Operations_to_Make_Network_Connected_5309 s = new Number_of_Operations_to_Make_Network_Connected_5309();
		System.out.println(s.makeConnected(n, connections));
	}

}
