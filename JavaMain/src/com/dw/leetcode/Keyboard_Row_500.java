package com.dw.leetcode;

import java.util.ArrayList;
import java.util.List;

//@example: Leetcode - 500. Keyboard Row - https://leetcode.com/problems/keyboard-row/#/description
public class Keyboard_Row_500 {
	
	public static boolean contains(String s, char a)
	{
		for(int i= 0;i<s.length();i++)
			if(a==s.charAt(i))
				return true;
		
		return false;
	}
	
	public static String[] findWords(String[] words) {
	    List<String> result = new ArrayList<String>();
	    String[] rows = new String[3];
		rows[0]="qwertyuiop";
		rows[1]="asdfghjkl";
		rows[2]="zxcvbnm";
		
		for(String w : words)
		{
			char[] temp = w.toLowerCase().toCharArray();
			String row = "";
			for(int i=0;i<=2;i++)
				if(contains(rows[i],temp[0]))
				{
					row = rows[i];
					break;
				}
			boolean flag = true;
			for(char a : temp) 
			{
				if(!contains(row,a))
				{
					flag = false;
					break;
				}
			}
			
			if(flag)
				result.add(w);
		}
		
		String[] stockArr = new String[result.size()];
	    
		return result.toArray(stockArr);
	}
	
	public static void main(String[] args) {
		String[] test = {"a","b"};
		
		String[] xx = findWords(test);
		
		for(String s : xx)
		{
			System.out.println(s);
		}
	}
}
