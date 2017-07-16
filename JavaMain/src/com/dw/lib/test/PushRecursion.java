package com.dw.lib.test;

public class PushRecursion {
	public int[] reverseArray(int[] array) {
		foo(array[0],array,0);
		return array;
	}
	
	public void foo(int c, int[] array, int index) {
		if(index == array.length - 1) {
			array[array.length - 1 - index] = c;
		}
		
		foo(array[index+1],array,index+1);
		array[array.length - 1 - index] = c;
	}
	
	public static void print(String s) {
		int[] array = {1,2,3,4,5};
		PushRecursion pushRecursion = new PushRecursion();
		int[] t = pushRecursion.reverseArray(array);
		
		for(int i=0;i<t.length;i++)
			System.out.print(String.format("%d\t", t[i]));
	}
}
