package com.dw.algorithmlib.test;

import com.dw.algorithmlib.ArrayHelper;

public class ArrayHelperTest {
	
	public static void revertArrayTest() {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Integer[] revertedArray = ArrayHelper.revertArray(intArray);
		
		ArrayHelper.printArray(revertedArray);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		revertArrayTest();
	}

}
