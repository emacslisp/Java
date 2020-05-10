package com.dw.leetcode;
import java.util.*;
//https://leetcode.com/contest/weekly-contest-188/problems/build-an-array-with-stack-operations/
public class BuildArrayWithStackOperations_5404 {

	public List<String> buildArray(int[] target, int n) {
		List<String> result = new ArrayList<String>();
		int start = target[0];
		
		for(int i=1;i<start;i++) {
			result.add("Push");
			result.add("Pop");
		}
		
		result.add("Push");
		
        for(int i=1;i<target.length;i++) {
        	if(target[i] - start == 1) {
        		start = target[i];
        		result.add("Push");
        		continue;
        	}
        	else {
        		for(int j=start + 1;j<target[i];j++) {
        			result.add("Push");
        			result.add("Pop");
        		}
        		start = target[i];
        		result.add("Push");
        	}
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildArrayWithStackOperations_5404 s= new BuildArrayWithStackOperations_5404();
		int[] target = {2,3,4};
		int n = 4;
		List<String> results = s.buildArray(target, n);
		
		for(String x : results) {
			System.out.println(x);
		}
	}

}
