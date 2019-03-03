package com.dw.algorithmlib.test;

import com.dw.algorithmlib.ListNode;
import com.dw.algorithmlib.ReverseLinkedList;

public class ReverseLinkedListTest {
	
	public static void ReverseLinkedListRecursion() {
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		ListNode head = new ListNode(intArray[0]);
		ListNode pointer = head;
		for(int i = 1; i< intArray.length; i++) {
			pointer.next = new ListNode(intArray[i]);
			pointer = pointer.next;
		}
		
		ListNode result = reverseLinkedList.revertListRecursion(head);
		
		reverseLinkedList.printListNode(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedListRecursion();
	}

}
