package com.dw.amazon;

import java.util.*;

public class CollectionsSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> parts = new ArrayList<Integer>();
		parts.add(5);
		parts.add(4);
		parts.add(3);
		parts.add(2);
		parts.add(1);
		Collections.sort(parts);
		
		for(Integer i : parts) {
			System.out.print(i + "\t");
		}
	}

}
