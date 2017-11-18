package com.dw.leetcode;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.*;

import org.w3c.dom.NamedNodeMap;

//@todo: finish clone graph with 133

public class Clone_Graph_133 {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	private Map<Integer,UndirectedGraphNode> nodeMap = new HashMap<Integer,UndirectedGraphNode>();
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	return clone(node);
    }
    
    public UndirectedGraphNode clone(UndirectedGraphNode node) {
    	if(node == null) return null;
    	
    	if(nodeMap.containsKey(node.label)) {
    		return nodeMap.get(node.label);
    	}
    	
    	UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    	nodeMap.put(node.label, newNode);
    	
    	for(UndirectedGraphNode n: node.neighbors) {
    		newNode.neighbors.add(clone(n));
    	}
    	
    	return newNode;
    }

	public static void main(String[] args) {

	}
}
