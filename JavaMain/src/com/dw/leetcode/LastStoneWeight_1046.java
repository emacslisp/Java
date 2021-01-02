package com.dw.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight_1046 {

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer> (Collections.reverseOrder());
		
		for(int x : stones) {
			pq.add(x);
		}
		
		int l1 = pq.poll();
		
		while(!pq.isEmpty()) {
			int l2 = pq.poll();
			if(l1 == l2) {
				if(!pq.isEmpty()) {
					l1 = pq.poll();
				} else {
					return 0;
				}
			} else {
				pq.add(Math.abs(l1 - l2));
				l1 = pq.poll();
			}
		}
		return l1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LastStoneWeight_1046 s = new LastStoneWeight_1046();
		int[] stones = {
			2,2
		};
		int result = s.lastStoneWeight(stones);
		System.out.println(result);
	}

}
