package com.dw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentWords_692 {

	static class Pair {
		int seq;
		String word;
	}

	public int compareString(String s1, String s2) {
		if (s1 == s2)
			return 0;

		for (int i = 0; i < (s1.length() > s2.length() ? s2.length() : s1.length()); i++) {
			if (s1.charAt(i) > s2.charAt(i)) {
				return 1;
			}

			if (s1.charAt(i) < s2.charAt(i)) {
				return -1;
			}
		}

		return s1.length() > s2.length() ? -1 : 1;
	}

	public List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<>();

		HashMap<String, Integer> map = new HashMap<>();

		for (String s : words) {
			Integer i = map.get(s);
			if (i == null) {
				map.put(s, 1);
			} else {
				map.put(s, i + 1);
			}
		}
		Pair[] pairs = new Pair[map.keySet().size()];
		int index = 0;
		for (String s : map.keySet()) {
			pairs[index] = new Pair();
			pairs[index].seq = map.get(s);
			pairs[index].word = s;
			index++;
		}

		Comparator<Pair> comparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair pair1, Pair pair2) {

				if (pair1.seq > pair2.seq)
					return -1;
				if (pair1.seq < pair2.seq)
					return 1;

				if (pair1.seq == pair2.seq) {
					return compareString(pair1.word, pair2.word);
				}

				return 0;
			}
		};

		Arrays.sort(pairs, comparator);

		for (int i = 0; i < k; i++) {
			result.add(pairs[i].word);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		TopKFrequentWords_692 s = new TopKFrequentWords_692();
		List<String> result = s.topKFrequent(input, 4);
		for (String x : result) {
			System.out.println(x);
		}

	}

}
