package com.dw.algorithmlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
    
    /**
     * Convert Tree to Array
     * @param root - Tree Root Node
     * @return List<Integer> - List of Integer
     */
    public List<Integer> treeToArray(TreeNode root) {
    	Queue<TreeNode> q = new LinkedList<>();
    	
    	q.add(root);
    	
    	List<Integer> result = new ArrayList<>();
    	
    	while(q.size() > 0) {
    		TreeNode p = q.peek();
    		
    		if(p == null) {
    			result.add(null);
    			q.poll();
    			continue;
    		}
    		
    		result.add(p.val);
    		q.poll();
    		
    		if(p.left == null && p.right == null) continue;
    		
    		q.add(p.left);
    		q.add(p.right);
    	}
    	
    	return result;
    }
    
    public TreeNode arrayToTree2(Integer[] a) {
    	Queue<TreeNode> q = new LinkedList<>();
    	TreeNode head = new TreeNode(a[0].intValue());
    	
    	q.add(head);
    	TreeNode cur = null;
    	int count = 0;
    	
    	for (int i = 1; i < a.length; i++) {
    		TreeNode node = null;
    		if(a[i] != null)
    			node = new TreeNode(a[i].intValue());
    		
    		if(count == 0){
    			cur = q.poll();
    		}
    		
    		if(count==0){
	          count++;
	          cur.left = node;
	        }else {
	          count = 0;
	          cur.right = node;
	        }
    		
	        if(node != null){
	          q.add(node);
	        }
    	}
    	
    	return head;
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
		Integer[] a = {1, 2, 3, 4, null, null, 5};
        tree.root = tree.arrayToTree2(a);
        
        List<Integer> list = tree.treeToArray(tree.root);
        
        // Arrays.stream(list.toArray()).map(x -> x).forEach(System.out::println);
        for(Integer x : list) {
        	System.out.print(x);
        	System.out.print("\t");
        }
        
        System.out.print("\n");
   
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
