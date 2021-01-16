package com.dw.leetcode;
import java.util.*;
public class FindPositiveIntegerSolutionforaGivenEquation_1237 {
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i=1;i<=z;i++) {
        	for(int j=1;j<=z;j++) {
        		if(customfunction.f(i, j) == z) {
        			List<Integer> t = new ArrayList<Integer>();
        			t.add(i);
        			t.add(j);
        			result.add(t);
        		}
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPositiveIntegerSolutionforaGivenEquation_1237 s = new FindPositiveIntegerSolutionforaGivenEquation_1237();
		CustomFunction customfunction = new CustomFunction();
		int z = 5;
		List<List<Integer>> result = s.findSolution(customfunction, z);
		for(List<Integer> x: result) {
			for(int y: x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}

}
