package com.dw.amazon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Combine {
	int minimumTime(int numOfParts, List<Integer> parts)
    {
        // WRITE YOUR CODE HERE
		int result = 0;
		if(parts.size() == 0) return 0;
		if(parts.size() == 1) return parts.get(0);
		Collections.sort(parts);
		
		List<Integer> resultList = new ArrayList<Integer>();
		int prev = parts.get(1) + parts.get(0);
		resultList.add(prev);
		
		for(int i=2; i<numOfParts;i++) {
			prev += parts.get(i);
			resultList.add(prev);
		}
		
		
		for(Integer i: resultList) {
			result+=i;
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		
		
		int[] arr = {1, 2, 5, 10, 35, 89};
		List<Integer> parts = new ArrayList<Integer>();
		Random rand = new Random();
				
		for(int i=1;i<=1000000;i++) {
			parts.add(1 + rand.nextInt(100));
		}
		
		int numOfParts = 1000000;
		Combine c = new Combine();
		
		System.out.println(c.minimumTime(numOfParts, parts));
	}
}
