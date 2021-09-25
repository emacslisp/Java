package com.dw.leetcode;

import java.util.HashMap;

import com.dw.algorithmlib.LinkedListAlgorithm;
import com.dw.algorithmlib.ListNode;

public class RemoveDuplicatesfromSortedListII_82 {

    public ListNode deleteDuplicates(ListNode head) {
    	ListNode pHead = new ListNode(-1000);
    	pHead.next = head;
    	ListNode r = pHead;
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	ListNode p = pHead;
    	while (p!=null) {
    		map.put(p.val, map.getOrDefault(p.val, 0) + 1);
    		p = p.next;
    	}
    	
    	p = pHead.next;
    	ListNode p1 = pHead;
    	while (p!=null) {
    		if(map.get(p.val) > 1) {
    			p = p.next;
    		} else {
    			p1.next = p;
    			p1 = p;
    			p = p.next;
    		}
    	}
    	if(p1.next != p) p1.next = p;
        
        return r.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListAlgorithm ll = new LinkedListAlgorithm();
		int[] a= {1,1};
		ListNode head = ll.arrayToLinkedList(a);
		RemoveDuplicatesfromSortedListII_82 ss = new RemoveDuplicatesfromSortedListII_82();
		ListNode result = ss.deleteDuplicates(head);
		ll.printListNode(result);
	}

}
