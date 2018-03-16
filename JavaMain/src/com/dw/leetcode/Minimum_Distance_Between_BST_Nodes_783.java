package com.dw.leetcode;




public class Minimum_Distance_Between_BST_Nodes_783 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDiffInBST(TreeNode root) {
        int result = 0;
        if(root == null) return 0;
        
        help(root);
        
        return result;
    }
	
	public void help(TreeNode root) {
		if(root == null) return; 
		
		help(root.left);
		
		help(root.right);
	}
	
	public static void main(String[] args) {
		
	}
}
