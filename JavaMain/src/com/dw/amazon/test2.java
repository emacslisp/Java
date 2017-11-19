package com.dw.amazon;

import java.util.ArrayList;
import java.util.List;

public class test2 {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsLessKDist(String inputString, int num)
	{
        // WRITE YOUR CODE HERE
    	
    	List<String> result = new ArrayList<String>();
    	int[] mark = new int[26];
    	
    	for(int i=(num-1);i<inputString.length();i++) {
    		for(int k=0;k<26;k++) mark[k] = 0;
    		for(int j=i-(num-1);j<=i;j++) {
    			mark[inputString.charAt(j) - 'a']++;
    		}
    		
    		int counter = 0;
    		int moreThanTwo = 0;
    		for(int k=0;k<mark.length;k++) {
    			if(mark[k]==2) counter++;
    			if(mark[k]>2) moreThanTwo++;
    		}
    		
    		if(counter == 1 && moreThanTwo == 0) {
    			String s = inputString.substring(i-(num-1), i+1);
    			if(!result.contains(s))
    			result.add(s);
    		}
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*test2 t = new test2();
		
		List<String> result = t.subStringsLessKDist("awaglk", 4);
		
		for(String s:result) {
			System.out.println(s);
		}*/
		Integer x = new Integer(1);
		System.out.println(x==1);
		
	}

}
