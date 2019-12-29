package com.dw.algorithmlib;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	
	public char val;
	public TrieNode[] hash;
	public boolean isWord;
	
	public TrieNode(char c) {
		this.val = c;
		this.hash = new TrieNode[26];
		this.isWord = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieNode root=new TrieNode(' ');
		
		List<String> words = new ArrayList<String>();
		words.add("");
		
		for(String word : words) {
			TrieNode current = root;
			for(int i=0;i<word.length();i++) {
				char c = word.charAt(i);
				
				if(current.hash[c-'a'] == null) {
					current.hash[c-'a'] = new TrieNode(c);
				}
				
				current = current.hash[word.charAt(i)-'a'];
				
				if(i == word.length() - 1) {
					current.isWord = true;
				}
			}
		}
	}

}
