package com.dw.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ReachaNumber_754 {
	public class Step {
		public int value;
		public int step;
		Step(int value, int step) {
			this.value = value;
			this.step = step;
		}
	}
	
	public int reachNumber(int target) {
		target = Math.abs(target);
		if (target == 0)
			return 0;

		int count = 0, step = 0;
		while (true) {
			count++;
			step += count;
			if (step == target || step > target && (step - target) % 2 == 0)
				return count;
		}
		
		//return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReachaNumber_754 s= new ReachaNumber_754();
		System.out.println(s.reachNumber(100));
	}

}
