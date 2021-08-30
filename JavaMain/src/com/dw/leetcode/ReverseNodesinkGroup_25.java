package com.dw.leetcode;

import java.util.*;

import com.dw.algorithmlib.LinkedListAlgorithm;
import com.dw.algorithmlib.ListNode;

public class ReverseNodesinkGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> s = new Stack<ListNode>();
        Queue<ListNode> q = new LinkedList<ListNode>();
        
    	ListNode p = head;
    	ListNode result = new ListNode(-1);
    	ListNode pn = result;
    	
    	while (p != null) {
    		s.push(new ListNode(p.val));
    		q.add(new ListNode(p.val));
    		
    		if(s.size()==k) {
    			
    			while(s.size() > 0) {
    				pn.next = s.pop();
    				pn = pn.next;
    			}
    			
    			q.clear();
    		}
    		
    		p = p.next;
    	}
    	
    	if(s.size() >0 && s.size() < k) {
    		while(q.size() > 0) {
    			pn.next = q.poll();
    			pn = pn.next;
    		}
    	}
    	
    	return result.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		int k = 1;
		LinkedListAlgorithm la = new LinkedListAlgorithm();
		ListNode head = la.arrayToLinkedList(a);
		ReverseNodesinkGroup_25 rng = new ReverseNodesinkGroup_25();
		
		ListNode result = rng.reverseKGroup(head, k);
		la.printListNode(result);
	}

}
