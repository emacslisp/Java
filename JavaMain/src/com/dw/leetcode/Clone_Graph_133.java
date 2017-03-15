package com.dw.leetcode;

import java.util.*;

//@todo: finish clone graph with 133

public class Clone_Graph_133 {
	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
	
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) return null;
    	
    	Map<Integer,UndirectedGraphNode> nodeMap = new HashMap<Integer,UndirectedGraphNode>();
    	Map<Integer,UndirectedGraphNode> rootMap = new HashMap<Integer,UndirectedGraphNode>();
    	
    	UndirectedGraphNode root = new UndirectedGraphNode(node.label);
    	
    	
    	
    	
    	return root;
    }
    
    public static void foo(UndirectedGraphNode node, UndirectedGraphNode root, Map<Integer,UndirectedGraphNode> nodeMap, Map<Integer,UndirectedGraphNode> rootMap) {
    	
    }

	public static void main(String[] args) {

	}
}
