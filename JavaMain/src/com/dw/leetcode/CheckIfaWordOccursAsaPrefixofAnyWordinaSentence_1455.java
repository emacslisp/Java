package com.dw.leetcode;

public class CheckIfaWordOccursAsaPrefixofAnyWordinaSentence_1455 {
	public int isPrefixOfWord(String sentence, String searchWord) {
        
		String[] s = sentence.split(" ");
		
		for(int i=0;i<s.length;i++) {
			if(s[i].startsWith(searchWord)) {
				return i+1;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIfaWordOccursAsaPrefixofAnyWordinaSentence_1455 s = new CheckIfaWordOccursAsaPrefixofAnyWordinaSentence_1455();
		String sentence = "i love eating burger";
		String searchWord = "burg";
		
		int result = s.isPrefixOfWord(sentence, searchWord);
		System.out.println(result);
	}

}
