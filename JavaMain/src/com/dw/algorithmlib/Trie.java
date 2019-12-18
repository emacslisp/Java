package com.dw.algorithmlib;

public class Trie {
	
	static final int ALPHABET_SIZE = 26; 
	
	static class TrieNode 
    { 
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
       
        // isEndOfWord is true if the node represents 
        // end of a word 
        boolean isEndOfWord; 
          
        TrieNode(){ 
            isEndOfWord = false; 
            for (int i = 0; i < ALPHABET_SIZE; i++) 
                children[i] = null; 
        } 
    }; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
