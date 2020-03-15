package com.dw.leetcode;

import java.util.ArrayList;

import com.dw.algorithmlib.BinaryTree;
import com.dw.algorithmlib.TreeNode;

public class BalanceBinarySearchTree_5179 {
	public TreeNode balanceBST(TreeNode root) {
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		storeBSTNodes(root, nodes);
		
		int n = nodes.size();
		
		return buildBalancedTree(nodes, 0, n-1);
		
    }
	
	void storeBSTNodes(TreeNode root, ArrayList<TreeNode> nodes) {
		if (root == null) 
			return; 

		storeBSTNodes(root.left, nodes); 
		nodes.add(root); 
		storeBSTNodes(root.right, nodes); 
	}
	
	TreeNode buildBalancedTree( ArrayList<TreeNode> nodes, int start, int end) {
		if (start > end) 
			return null; 

		int mid = (start + end) / 2; 
		TreeNode node = nodes.get(mid); 

		node.left = buildBalancedTree(nodes, start, mid - 1); 
		node.right = buildBalancedTree(nodes, mid + 1, end); 

		return node; 
	}
	
	void preOrder(TreeNode node) 
	{ 
		if (node == null) 
			return; 
		System.out.print(node.val + " "); 
		preOrder(node.left); 
		preOrder(node.right); 
	} 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nodes = {1,null,2,null,3,null,4,null,null};
		
		BinaryTree binaryTree = new BinaryTree();
		
		TreeNode root = binaryTree.arrayToTree(nodes);
		
		BalanceBinarySearchTree_5179 s= new BalanceBinarySearchTree_5179();
		
		TreeNode result = s.balanceBST(root);
		
		s.preOrder(result);
	}

}
