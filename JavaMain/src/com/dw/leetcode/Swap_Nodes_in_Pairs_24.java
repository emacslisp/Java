package com.dw.leetcode;
import com.dw.algorithmlib.ListNode;
/*
https://leetcode.com/problems/swap-nodes-in-pairs/

24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

public class Swap_Nodes_in_Pairs_24 {
    public ListNode swapPairs(ListNode head) {
    	if(head == null) return head;
    	
    	if(head.next == null) return head;
    	
    	ListNode targetHead = null;
    	ListNode p1 = null;
    	ListNode p2 = null;
    	ListNode p3 = null;
    	ListNode prev = null;
    	
    	p1 = head;
    	int counter = 0;
    	while(p1 != null)  {
    		counter++;
    		p1 = p1.next;
    	}
    	
    	p3 = head;
    	targetHead = head.next;
    	
    	counter = counter%2 == 0? counter: counter-1;
    	
    	while(counter > 0) {
    		
    		p1 = p3;
    		p2 = p1.next;
    		p3 = p2.next;

    		
    		p2.next = p1;
    		p1.next = p3;
    		
    		// this part of code is very important, because when reverse, point to next may get lost.
    		// 
    		if(prev != null) {
    			prev.next = p2; 
    		}
    		
    		prev = p1;
    		
    		counter -= 2;
    	}
    	
    	return targetHead;
    }
    
    public void printList(ListNode target) {
    	ListNode p1 = target;
		while(p1 != null) {
			System.out.println(p1.val);
			p1 = p1.next;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2, 3, 4};
		ListNode header = new ListNode(1);
		ListNode current = header;
		for(int n : array) {
			current.next = new ListNode(n);
			current = current.next;
		}
		
		Swap_Nodes_in_Pairs_24 s = new Swap_Nodes_in_Pairs_24();
		s.printList(header);
		
		ListNode target = s.swapPairs(header);
		
		s.printList(target);
	}

}
