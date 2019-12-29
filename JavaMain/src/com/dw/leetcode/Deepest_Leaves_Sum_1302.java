package com.dw.leetcode;

import com.dw.algorithmlib.TreeNode;

//@type: tree

public class Deepest_Leaves_Sum_1302 {
	int deepest;
	int sum = 0;
	
	int treeHigh(TreeNode node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = treeHigh(node.left); 
            int rDepth = treeHigh(node.right); 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    }
	
	int treeHigh(TreeNode node, int high) {
		if (node == null) 
            return 0; 
        else 
        { 
        	int next = ++high;
            /* compute the depth of each subtree */
            int lDepth = treeHigh(node.left, next); 
            int rDepth = treeHigh(node.right, next); 
   
            /* use the larger one */
           if(high == deepest) {
        	   sum+= node.data;
           }
           
           if (lDepth > rDepth) 
               return (lDepth + 1); 
            else 
               return (rDepth + 1); 
        } 
	}
	
    public int deepestLeavesSum(TreeNode root) {
        deepest = treeHigh(root);
               
        treeHigh(root, 0);
        
        return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        
        root.right.right = new TreeNode(6);
        
        root.left.left.left = new TreeNode(7); 
        root.right.right.right = new TreeNode(8); 
        
        Deepest_Leaves_Sum_1302 s = new Deepest_Leaves_Sum_1302();
        int result = s.deepestLeavesSum(root);
        System.out.println(result);
	}

}
