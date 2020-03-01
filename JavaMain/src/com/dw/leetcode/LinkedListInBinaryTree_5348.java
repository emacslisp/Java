package com.dw.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.dw.algorithmlib.BinaryTree;
import com.dw.algorithmlib.LinkedListAlgorithm;
import com.dw.algorithmlib.ListNode;
import com.dw.algorithmlib.TreeNode;

public class LinkedListInBinaryTree_5348 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        
    	int startVal = head.val;
    	
    	List<TreeNode> allNodes = new ArrayList<>();
    	searchNode(root, startVal, allNodes);
    	List<Boolean> result = new ArrayList<>();
    	for(TreeNode node : allNodes) {
    		ListNode p = head.next;
    		
	    	if (!isMatch(node.left, p) && !isMatch(node.right, p)) {
	    		result.add(false);
	    	}
    	}
    	return allNodes.size() > result.size();
    }
    
    boolean isMatch(TreeNode root, ListNode p) {
    	if(root == null && p == null)
    		return true;
    	
    	if(root == null && p != null)
    		return false;
    	
    	if(root != null && p == null)
    		return true;
    	
    	if(root.val == p.val) {
    		return isMatch(root.left, p.next) || isMatch(root.right, p.next);
    	}
    	
    	return false;
    }
    
    void searchNode(TreeNode root, int startVal, List<TreeNode> allNodes) {
    	if (root == null)
    		return;
    	
    	if (root.val == startVal)
    		allNodes.add(root);
    	
    	searchNode(root.left, startVal, allNodes);
    	searchNode(root.right, startVal, allNodes);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3};
		
		BinaryTree tree = new BinaryTree();
		LinkedListAlgorithm linkedList = new LinkedListAlgorithm();
		
		TreeNode root = tree.arrayToTree(a);
		
		//int[] b = {1, 4, 2, 6, 8};
		int[] b = {1, 4, 2, 6};
		ListNode head = linkedList.arrayToLinkedList(b);
		
		LinkedListInBinaryTree_5348 s= new LinkedListInBinaryTree_5348();
		System.out.println(s.isSubPath(head, root));
	}

}
