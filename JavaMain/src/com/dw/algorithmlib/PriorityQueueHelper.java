package com.dw.algorithmlib;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueHelper {
	
	public PriorityQueue<Integer> pq;
	
	public PriorityQueueHelper(boolean isMaxHeap) {
		if (isMaxHeap) {
			pq = new PriorityQueue<Integer> (Collections.reverseOrder());
		} else {
			pq = new PriorityQueue<Integer> ();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueueHelper pqh = new PriorityQueueHelper(true);
		pqh.pq.add(4);
		pqh.pq.add(10);
		pqh.pq.add(8);
		pqh.pq.add(30);
		pqh.pq.add(20);
		System.out.println(pqh.pq.poll());
	}

}
