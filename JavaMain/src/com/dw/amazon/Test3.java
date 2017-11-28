package com.dw.amazon;

import com.mysql.fabric.xmlrpc.base.Array;

public class Test3 {

	public int startPointer = 0;
	public int endPointer = -1;
	public int queueSize = 0;
	public int[] array = new int[20];
	// may be interview question
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test3 s = new Test3();
		
		for(int i=0;i<20;i++) {
			s.queue(i);
	    }
		int firstElement = s.dequeue();
		
		s.queue(5);
		System.out.println(firstElement);
		s.queue(5);
		
		for(int i=0;i<220;i++) { 
			firstElement = s.dequeue();
			System.out.println(firstElement);
			s.queue(i+100);
		}		
	}
	
	public boolean isArrayFull() {
		if(queueSize == array.length) {
			return true;
		}
		return false;
	}
	
	public void queue(int element) {
		if(queueSize >= array.length) {
			System.out.println("Queue is full");
			return;
		}
		endPointer++;
		if(endPointer >= array.length) {
			endPointer %= array.length;
		}
		array[endPointer] = element;
		queueSize++;
	}
	
	public Integer dequeue() {
		if(queueSize == 0)
			return null;
		
		int result = array[startPointer];
		queueSize--;
		startPointer++;
		if(startPointer >= array.length) {
			startPointer %= array.length;
		}
		
		return result;
	}

}
