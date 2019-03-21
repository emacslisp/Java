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
    
    void mirror() 
    { 
        root = mirror(root); 
    } 
  
    TreeNode mirror(TreeNode node) 
    { 
        if (node == null) 
            return node; 
  
        /* do the subtrees */
        TreeNode left = mirror(node.left); 
        TreeNode right = mirror(node.right); 
  
        /* swap the left and right pointers */
        node.left = right; 
        node.right = left; 
  
        return node; 
    } 
    
    void inOrder() 
    { 
        inOrder(root); 
    } 
  
    /* Helper function to test mirror(). Given a binary 
       search tree, print out its data elements in 
       increasing sorted order.*/
    void inOrder(TreeNode node) 
    { 
        if (node == null) 
            return; 
  
        inOrder(node.left); 
        System.out.print(node.data + " "); 
  
        inOrder(node.right); 
    } 
    
    void deleteTree(TreeNode node) 
    { 
        // In Java automatic garbage collection 
        // happens, so we can simply make root 
        // null to delete the tree 
        root = null; 
    } 
      
    /* Wrapper function that deletes the tree and  
       sets root node as null  */
    void deleteTreeRef(TreeNode nodeRef) 
    { 
    	if(nodeRef == null) return;
    	
    	
    	deleteTreeRef(nodeRef.left);

    	deleteTreeRef(nodeRef.right);
    	
    	
   	 System.out.println("Deleting node:" + nodeRef.data);
   	 deleteTree(nodeRef); 
         
        nodeRef=null; 
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
        
        System.out.println("Inorder traversal of input tree is :"); 
        tree.inOrder(); 
        System.out.println(""); 
        
        /* convert tree to its mirror */
        tree.mirror(); 
  
        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : "); 
        tree.inOrder(); 
        
        tree.deleteTreeRef(tree.root); 
        System.out.println("Tree deleted"); 
	}

}
