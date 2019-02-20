package com.dw.algorithmlib;

public class ReverseLinkedList {
	static ListNode head;
    
    /**
     * 
     * @param head
     * @return
     */
    public ListNode revertList(ListNode head) {
    	if(head == null) return null;
        if(head.next == null) return head;
        
    	ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null) {
        	next = current.next;
        	current.next = prev;
        	prev = current;
        	current = next;
        }
        return prev;
    }
    
    /** 
     * revert half of list
     * @param head head of a list
     * @return 
     * */
    public ListNode reverseHalfList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode pointer = head;
        int counter = 0;
        while(pointer != null) {
        	counter++;
        	pointer = pointer.next;
        }
        
        int middle = counter/2;
        
        // idea is easy, we reverset half linked list 
        // then compare each one calling startOne.val == startTwo.val
        // startOne = startOne.next
        // startTwo = startTwo.next
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while(middle>0) {
        	next = current.next;
        	current.next = prev;
        	prev = current;
        	current = next;
        	middle--;
        }
        
        return prev;
    }
}
