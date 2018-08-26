package com.dw.leetcode;

public class Palindrome_Linked_List_234 {
	
    public boolean isPalindrome(ListNode head) {
        
        if(head == null) return true;
        if(head.next == null) return true;
        
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
        
        ListNode startOne = prev;
        ListNode startTwo = counter%2==0? next : next.next;
        
        middle = counter/2;
        while(middle>0) {
        	if(startOne.val != startTwo.val)
        		return false;
        	startOne = startOne.next;
        	startTwo = startTwo.next;
        	middle--;
        }
        
        return true;
    }

	public static void main(String[] args) {
		 int[] array = {1,2,3,3,3,1};
		 ListNode pointer = null;
		 ListNode header = new ListNode(array[0]);
		 ListNode start = header;
		 
		 for(int i=1;i<array.length;i++) {
		         pointer = new ListNode(array[i]);
		         start.next = pointer;
		         start = pointer;
		 }
		 
		 Palindrome_Linked_List_234 s = new Palindrome_Linked_List_234();
		 System.out.println(s.isPalindrome(header));
	}

}
