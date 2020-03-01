package com.dw.algorithmlib;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	TreeNode root;
	
	/**
	 * calc treeHigh which is maxDepth
	 * @param node
	 * @return Tree high
	 */
	public int treeHigh(TreeNode node)  
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
        System.out.print(node.val + " "); 
  
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
    	
    	
   	 System.out.println("Deleting node:" + nodeRef.val);
   	 deleteTree(nodeRef); 
         
        nodeRef=null; 
    } 
    
    // ===============================
    int leftNode(int i) {
    	return 2*i+1;
    }
    
    int rightNode(int i) {
    	return 2*i+2;
    }
    
    public TreeNode arrayToTree(Integer[] a) {
    	// Integer[] a = {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
    	Queue<Integer> q = new LinkedList<>();
    	
    	q.add(0);
    	TreeNode head = new TreeNode(a[0].intValue());
    	HashMap<Integer, TreeNode> map = new HashMap<>();
    	map.put(0, head);
    	
    	while(q.size() > 0) {
    		Integer index = q.poll();
    		
    		if(a[index] == null) {
    			continue;
    		}
    		
    		if(map.get(index) == null) {
    			map.put(index, new TreeNode(a[index].intValue()));
    		}
    		
    		TreeNode node = map.get(index);
    		int left = leftNode(index.intValue());
    		int right = rightNode(index.intValue());
    		
    		if(left < a.length && a[left] != null) {
    			map.put(left, new TreeNode(a[left]));
    			node.left = map.get(left);
    			q.add(left);
    		}
    		
    		if (right < a.length && a[right] != null) {
	    		map.put(right, new TreeNode(a[right]));
	    		node.right = map.get(right);
	    		q.add(right);
    		}
    	}
    	
    	return head;
    }
    // ============================

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
