package com.dw.algorithmlib;

public class ArrayHelper {
	
	public static <E> E[] revertArray(E[] inputArray) {
		
		int i = 0;
		
		while(i<inputArray.length) {
			int end = inputArray.length - i - 1;
			if(end>i) {
				break;
			}
			
			E temp = inputArray[i];
			inputArray[i]=inputArray[end];
			inputArray[end] = temp;
			
			i++;
		}
		
		return inputArray;
	}

	/**
	 * generic print Array
	 * @param inputArray
	 */
	public static <E> void printArray(E[] inputArray) {
		// Display array elements
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[] intArray = { 1, 2, 3, 4, 5 };
	      Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
	      Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

	      System.out.println("Array integerArray contains:");
	      printArray(intArray);   // pass an Integer array

	      System.out.println("\nArray doubleArray contains:");
	      printArray(doubleArray);   // pass a Double array

	      System.out.println("\nArray characterArray contains:");
	      printArray(charArray);   // pass a Character array
	}

}
