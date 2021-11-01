package com.dw.leetcode;

public class CheckifAllCharactersHaveEqualNumberofOccurrences_1941 {

    public boolean areOccurrencesEqual(String s) {
    	int[] b = new int[26];
    	
    	for(int i=0;i<b.length;i++) {
    		b[i] = 0;
    	}
    	
        for(char c : s.toCharArray()) {
        	b[c-'a']++;
        }
        int num = 0;
        for(int i=0;i<b.length;i++) {
    		if(b[i] != 0) {
    			num = b[i];
    			break;
    		}
    	}
        
        for(int i=0;i<b.length;i++) {
     		if(b[i] != 0 && b[i] != num) {
     			return false;
     		}
     	}
        
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
