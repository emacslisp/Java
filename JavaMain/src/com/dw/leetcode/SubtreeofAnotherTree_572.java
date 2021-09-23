package com.dw.leetcode;

import com.dw.algorithmlib.BinaryTree;
import com.dw.algorithmlib.TreeNode;

public class SubtreeofAnotherTree_572 {

    boolean isEqual(TreeNode node, TreeNode n) {
    	if(node == null && n== null) return true;
    	if(node == null || n== null) return false;
    	
    	if(node.val != n.val) 
    		return false;
    	
    	return isEqual(node.left, n.left) && isEqual(node.right, n.right);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        
        if(root.val == subRoot.val && isEqual(root, subRoot)) {
        	return true;
        }
        
        return  isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		
		Integer[] root = {3,4,5,1,2};
		Integer[] subRoot = {4, 1, 2};
		TreeNode r1 = bt.arrayToTree2(root);
		TreeNode r2 = bt.arrayToTree2(subRoot);
		
		SubtreeofAnotherTree_572 s = new SubtreeofAnotherTree_572();
		
		System.out.println(s.isSubtree(r1, r2));
	}

}
