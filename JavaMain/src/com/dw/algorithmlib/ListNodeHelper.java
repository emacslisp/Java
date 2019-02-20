package com.dw.algorithmlib;

public class ListNodeHelper {

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
		
		ListNodeHelper helper = new ListNodeHelper();
		helper.printList(header);
	}

}
