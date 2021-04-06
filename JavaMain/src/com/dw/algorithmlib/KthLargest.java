package com.dw.algorithmlib;

import java.util.PriorityQueue;

public class KthLargest {
	int k;
	PriorityQueue<Integer> q;
	
	public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>();
        for(int x: nums) {
        	q.add(x);
        }
    }
    
    public int add(int val) {
        q.add(val);
        
        while(q.size() > this.k) {
        	q.poll();
        }
        
        return q.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4, 5, 8 ,2};
		KthLargest k = new KthLargest(3, a );
		
		int r = k.add(3);
		System.out.println(r);
		r = k.add(5);
		System.out.println(r);
		r = k.add(10);
		System.out.println(r);
		r = k.add(9);
		System.out.println(r);
		r = k.add(4);
		System.out.println(r);
	}

}
