package com.dw.leetcode;

public class ChangeMinimumCharacterstoSatisfyOneofThreeConditions_5662 {
	public int count(String a, String b) {
		int result = Integer.MAX_VALUE;
		int t = 0;
		for(int i=1;i<26;i++) {
			t = 0;
			for(int j=0;j<a.length();j++) {
				if((a.charAt(j) - 'a') >=i) t++;
			}
			
			for(int j=0;j<b.length();j++) {
				if((b.charAt(j) - 'a') <i) t++;
			}
			result = Math.min(result, t);
		}
		
		return result;
	}
	public int minCharacters(String a, String b) {

        int[] v = new int[26];
        for(int i=0;i<26;i++) {
        	v[i] = 0;
        }
        
        for(int i=0;i<a.length();i++) {
            v[a.charAt(i) - 'a'] += 1;
        }
        
        for(int i=0;i<b.length();i++) {
            v[b.charAt(i) - 'a'] += 1;
        }
        
        int condition1 = count(a, b);
        int condition2 = count(b, a);

        // condition 3;
        int max = 0;

        for(int i=0;i<26;i++) {
            if(max < v[i]) {
                max = v[i];
            }
        }

        max = a.length() + b.length() - max;

        return Math.min(max, Math.min(condition1, condition2));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChangeMinimumCharacterstoSatisfyOneofThreeConditions_5662 s = new ChangeMinimumCharacterstoSatisfyOneofThreeConditions_5662();
		String a = "da";
		String b = "cced";
		// String a = "ace";
		// String b = "abe";
		
		a = "a";
		b = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		System.out.println(s.minCharacters(a, b));
	}

}
