package com.dw.introduction_to_algorithms;

import java.util.ArrayList;
import java.util.List;

//@example: Undirected Graph Node defined  - {1,2,3#2,4#6,6}
public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
