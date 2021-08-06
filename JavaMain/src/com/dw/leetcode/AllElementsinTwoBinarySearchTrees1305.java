package com.dw.leetcode;

import java.util.*;

import com.dw.algorithmlib.BinaryTree;
import com.dw.algorithmlib.TreeNode;

public class AllElementsinTwoBinarySearchTrees1305 {
	
	List<Integer> result = new ArrayList<Integer>();
	
	void foo(TreeNode r) {
		if(r == null) return;
		
		result.add(r.val);
		foo(r.right);
		foo(r.left);
	}

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    	
    	
    	foo(root1);
    	foo(root2);
    	
    	Collections.sort(result);
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllElementsinTwoBinarySearchTrees1305 s = new AllElementsinTwoBinarySearchTrees1305();
		
		TreeNode root1 = null;
		TreeNode root2 = null;
		
		BinaryTree binaryTree = new BinaryTree();
		Integer[] a = {2,1, 4};
		Integer[] b = {1,0,3};
		root1 = binaryTree.arrayToTree(a);
		root2 = binaryTree.arrayToTree(b);
		
		List<Integer> x = s.getAllElements(root1, root2);
		for(int y: x) {
			System.out.println(y);
		}
	}

}
