package com.dw.amazon;

//Test amazon sdk code
public class test4 {

	
	int[] array = new int[20];
	int start = array.length;
	
	public boolean isQueueEmpty() {
		return start == array.length;
	}
	
	public boolean isQueueFull() {
		return start == 0;
	}
	
	public void queue(int element) {
		if(!isQueueFull()) {
			start--;
			array[start] = element;
		}
		else {
			System.out.println("Queue is full");
		}
	}
	
	public Integer dequeue() {
		if(!isQueueEmpty()) {
			int result = array[start];
			start--;
			return result;
		}
		
		return null;
	}
	
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
			Integer temp = s.dequeue();
			System.out.println(temp);
			s.queue(i+100);
		}	
	}

}
