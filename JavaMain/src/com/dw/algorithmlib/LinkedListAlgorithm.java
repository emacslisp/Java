package com.dw.algorithmlib;

public class LinkedListAlgorithm {
	static ListNode head;
	/**
	 * 
	 * @param head
	 * @return
	 */
	public ListNode revertListRecursion(ListNode head) {
		if(head == null) return null;
        if(head.next == null) return head;
        ListNode current = head;
        ListNode next = head.next;
        head.next = null;
        
        return recursionMain(current, next);
	}
	
	private ListNode recursionMain(ListNode head, ListNode next) {
		if(next == null) return head;
		ListNode target = next.next;
		next.next = head;
		return recursionMain(next, target);
	}
    
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
    
    public void printListNode(ListNode head) {
    	ListNode pointer = head;
    	
    	while(pointer != null) {
    		System.out.print(pointer.val + "\t");
    		pointer = pointer.next;
    	}
    }
    
    // start functions for
    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode middle = middleElement(head);
        ListNode nextofMiddle = middle.next;
        middle.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextofMiddle);

        ListNode sortdList = merge(left, right);

        return sortdList;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }
        ListNode temp = null;
        if(left.val < right.val) {
            temp = left;
            temp.next = merge(left.next, right);
        } else {
            temp = right;
            temp.next = merge(left, right.next);
        }

        return temp;
    }

    private ListNode middleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode arrayToLinkedList(int[] a) {
    	
    	ListNode head = new ListNode(a[0]);
    	ListNode p = head;
    	for(int i=1;i<a.length;i++) {
    		p.next = new ListNode(a[i]);
    		p = p.next;
    	}
    	
    	return head;
    }
}
