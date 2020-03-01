package com.dw.leetcode;

import java.util.ArrayList;
import java.util.List;

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
		TreeNode root = new TreeNode(1);
		
		TreeNode l1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(4);
		
		root.left = l1;
		root.right = r1;
		
		TreeNode l2 = new TreeNode(2);
		TreeNode r2 = new TreeNode(2);
		l1.right = r2;
		r1.left = l2;
		
		TreeNode l3 = new TreeNode(1);
		TreeNode l3_1 = new TreeNode(6);
		TreeNode r3_1 = new TreeNode(8);
		
		r2.left = l3;
		l2.left = l3_1;
		l2.right = r3_1;
		
		TreeNode l4 = new TreeNode(1);
		TreeNode r4 = new TreeNode(3);
		r3_1.left = l4;
		r3_1.right = r4;
		
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(8);
		// head.next.next.next.next = new ListNode(8);
		
		LinkedListInBinaryTree_5348 s= new LinkedListInBinaryTree_5348();
		System.out.println(s.isSubPath(head, root));
	}

}
