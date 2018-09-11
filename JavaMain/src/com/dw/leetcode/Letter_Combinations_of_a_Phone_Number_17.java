package com.dw.leetcode;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number_17 {
	static final char[][] number = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }
	};
	
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
    	if(digits.length() == 0){
            return new ArrayList<>(); 
        }
    	
    	foo(digits, 0, 0, digits.length(), new ArrayList<Character>(), result);
    	return result;
    }
    
    public void foo(String digits, int index, int total, int len, List<Character> temp, List<String> result) {
    	if(total == len) {
    		StringBuilder stringBuilder = new StringBuilder();
    		for(Character c: temp) {
    			stringBuilder.append(c);
    		}
    		result.add(stringBuilder.toString());
    		return;
    	}
    	
    	int numberIndex = Integer.parseInt(Character.toString(digits.charAt(index)));
    	
    	for(char c: number[numberIndex - 2]) {
    		temp.add(c);
    		foo(digits, index+1, total+1, len, temp, result);
    		temp.remove(temp.size() - 1);
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Letter_Combinations_of_a_Phone_Number_17 s = new Letter_Combinations_of_a_Phone_Number_17();
		System.out.println(s.letterCombinations("234"));
	}

}
