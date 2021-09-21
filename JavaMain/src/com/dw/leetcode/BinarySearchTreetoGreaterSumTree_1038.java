package com.dw.leetcode;

import java.util.List;

import com.dw.algorithmlib.BinaryTree;
import com.dw.algorithmlib.TreeNode;

public class BinarySearchTreetoGreaterSumTree_1038 {

	public int foo(TreeNode root, int additional) {
		if(root == null) return additional;
		
		int t1 = foo(root.right, additional);
		
		root.val += t1;
		
		int t2 = foo(root.left, root.val);
		
		return t2;
	}
	
    public TreeNode bstToGst(TreeNode root) {
    	
    	foo(root, 0);
    	
    	return root;
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree(); 
		Integer[] a = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
		TreeNode root = tree.arrayToTree(a);
		
		BinarySearchTreetoGreaterSumTree_1038 x = new BinarySearchTreetoGreaterSumTree_1038();
		TreeNode y = x.bstToGst(root);
		
		List<Integer> result = tree.treeToArray(root);
		
		for(Integer t : result) {
			System.out.print(t);
			System.out.print("\t");
		}
		System.out.println();
		
	}

}
