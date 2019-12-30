package com.dw.algorithmlib;

public class ArrayAsQueue {
	int BUF_SIZE = 64; // because we are using & rather than %, so BUF_SIZE should be 2^n

	int data;
	int head;
	int tail;
	int buf[] = new int[BUF_SIZE];
	
	int inc(int a) {
		return (a+1) & (BUF_SIZE - 1);
	}
	
	int dec(int a) {
		return (a-1) & (BUF_SIZE - 1);
	}
	
	boolean empty() {
		return head == tail;
	}
	
	int left() {
		return (tail - head - 1) & (BUF_SIZE - 1);
	}
	
	int last() {
		return buf[(head - 1) & (BUF_SIZE - 1)];
	}
	
	boolean full() {
		return left() == 0;
	}
	
	int chars() {
		return (head - tail) & (BUF_SIZE - 1);
	}
	
	void put(int a) {
		buf[head] = a;
		head = inc(head);
		// System.out.println("###head: " + head);
	}

	int get() {
		int result = buf[tail];
		tail = inc(tail);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayAsQueue s = new ArrayAsQueue();
		for(int i=0;i<50;i++) {
			s.put(i);
		}
		
		for(int i=0;i<10;i++) {
			System.out.println("###" + s.get());
		}
		
		for(int i=0;i<10;i++) {
			s.put(100+i);
		}
		
		while(!s.empty()) {
			System.out.println(s.get());
		}
	}

}
