package com.dw.algorithmlib;

public class BinaryTree {
	
	TreeNode root;
	
	/**
	 * calc treeHigh which is maxDepth
	 * @param node
	 * @return Tree high
	 */
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
	
	/**
	 * Calculate Number of Tree Element
	 * @return Number of Tree Element
	 */
	int size() 
    { 
        return size(root); 
    } 
  
    int size(TreeNode node) 
    { 
        if (node == null) 
            return 0; 
        else
            return(size(node.left) + 1 + size(node.right)); 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree(); 
		   
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
   
        System.out.println("Height of tree is : " +  
                                      tree.treeHigh(tree.root));
        
        System.out.println("The size of binary tree is : "
                + tree.size()); 
	}

}
