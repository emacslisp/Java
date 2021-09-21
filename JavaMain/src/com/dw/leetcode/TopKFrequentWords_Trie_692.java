package com.dw.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords_Trie_692 {
	
	static class Trie {
        int count = 0;
        String key = null;
        Trie[] a = new Trie[26];
    }
	
    public List<String> topKFrequent(String[] words, int k) {
    	Trie trie = new Trie();
    	
    	for (String word : words) {
            insert(trie, word);
        }
    	
    	PriorityQueue<Trie> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int compare = Integer.compare(o2.count, o1.count);
            return compare != 0 ? compare : o1.key.compareTo(o2.key);
        });
    	
    	fillInQ(priorityQueue, trie);
    	
    	List<String> mostFrequent = new LinkedList<>();
        int index = 0;
        while (!priorityQueue.isEmpty() && index++ < k) {
            mostFrequent.add(priorityQueue.poll().key);
        }

        return mostFrequent;
    }
    
    void fillInQ(PriorityQueue<Trie> priorityQueue, Trie trie) {
        if (trie != null) {
            for (Trie e : trie.a) {
            	if(e == null) continue;
                if (e.count != 0) {
                    priorityQueue.add(e);
                    // System.out.println(e.key);
                    // System.out.println(e.count);
                }
                fillInQ(priorityQueue, e);
            }
        }
    }
    
    void insert(Trie trie, String s) {
        Trie current = trie;
        // fill in trie
        for (char ch : s.toCharArray()) {
        	if(current.a[ch - 'a'] != null) {
        		current = current.a[ch - 'a'];
        	} else {
        		current.a[ch - 'a'] = new Trie();
        		current = current.a[ch - 'a'];
        	}
        }
        
        // important
        current.key = s;
        ++current.count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		TopKFrequentWords_Trie_692 s = new TopKFrequentWords_Trie_692();
		List<String> result = s.topKFrequent(input, 4);
		for (String x : result) {
			System.out.println(x);
		}
	}

}
