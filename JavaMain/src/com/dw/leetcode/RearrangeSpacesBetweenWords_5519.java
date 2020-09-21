package com.dw.leetcode;

public class RearrangeSpacesBetweenWords_5519 {
	public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        
        
        int spaceCounter = 0;
        for(int i=0;i<text.length();i++) {
        	if(text.charAt(i) == ' ') {
        		spaceCounter++;
        	}
        }
        
        if(words.length == 1) {
        	String leftSpace = "";
            for(int i=0;i<spaceCounter;i++) {
            	leftSpace+= " ";
            }
            
            return words[0] + leftSpace;
        }
        
        int num = spaceCounter/(words.length - 1);
        int left = spaceCounter - num * (words.length - 1);
        StringBuilder sb = new StringBuilder();
        for(String word: words) {
        	String temp = "";
        	for(int i=0;i<num;i++) {
        		temp+= " ";
        	}
        	sb.append(word + temp);
        }
        
        String leftSpace = "";
        for(int i=0;i<left;i++) {
        	leftSpace+= " ";
        }
        
        return sb.toString().trim() + leftSpace;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "  walks ";
		RearrangeSpacesBetweenWords_5519 s = new RearrangeSpacesBetweenWords_5519();
		System.out.println(s.reorderSpaces(text));
	}

}
