package com.dw.leetcode;

public class LongestWordinDictionary_720 {
	
	class TrieNode {
		public char val;
		public TrieNode[] hash;
		public boolean isWord;
		
		public TrieNode(char c) {
			this.val = c;
			this.hash = new TrieNode[26];
			this.isWord = false;
		}
		
        public StringBuilder dfs(StringBuilder res){
            
            StringBuilder max=new StringBuilder();
            for(int i=0;i<26;i++){
                if(hash[i]!=null && hash[i].isWord){
                    StringBuilder temp=new StringBuilder();
                    temp.append(hash[i].val);
                    temp.append(hash[i].dfs(temp));
                    if(temp.length() > max.length()) // this is very important, it will choose first letter always
                        max=temp;
                }
            }
            return max;
        }
	}

	public String longestWord(String[] words) {
		TrieNode root=new TrieNode(' ');
		
		for(String word: words) {
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
		
		StringBuilder sb = new StringBuilder();
		
		sb = root.dfs(sb);
		
		return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		LongestWordinDictionary_720 s = new LongestWordinDictionary_720();
		System.out.println(s.longestWord(words));
	}

}
