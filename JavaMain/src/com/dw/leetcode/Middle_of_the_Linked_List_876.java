package com.dw.leetcode;
import com.dw.algorithmlib.ListNode;

public class Middle_of_the_Linked_List_876 {
	
    public ListNode middleNode(ListNode head) {
    	if(head == null) return head;
        if(head.next == null) return head;
        if(head.next.next == null) return head.next;
        
        ListNode pointer = head;
        int counter = 0;
        int middle = 0;
        while(pointer != null) {
        	counter++;
        	pointer = pointer.next;
        }
        
        middle = counter/2;
        pointer = head;
        
        while(middle > 0) {
        	pointer = pointer.next;
        	middle--;
        }
        
        return pointer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5};
		ListNode pointer = null;
		ListNode header = new ListNode(array[0]);
		ListNode start = header;
		
		for(int i=1;i<array.length;i++) {
			pointer = new ListNode(array[i]);
			start.next = pointer;
			start = pointer;
		}
		
		Middle_of_the_Linked_List_876 s= new Middle_of_the_Linked_List_876();
		System.out.println(s.middleNode(header).val);
	}

}
