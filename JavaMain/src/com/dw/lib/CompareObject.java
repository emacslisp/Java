package com.dw.lib;

import java.util.Comparator;

public class CompareObject implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof String) {
			return compareImp((String) o1, (String) o2);
		} else if (o1 instanceof Integer) {
			return compareImp((Integer) o1, (Integer) o2);
		} else if (o1 instanceof Boolean) {
			return compareImp((Boolean) o1, (Boolean) o2);
		} else {
			System.err.println("it");
			return 1;
		}
	}

	public int compareImp(String o1, String o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		int len1 = s1.length();
		int len2 = s2.length();
		int n = Math.min(len1, len2);
		char v1[] = s1.toCharArray();
		char v2[] = s2.toCharArray();
		int pos = 0;

		while (n-- != 0) {
			char c1 = v1[pos];
			char c2 = v2[pos];
			if (c1 != c2) {
				return c1 - c2;
			}
			pos++;
		}
		return len1 - len2;
	}

	public int compareImp(Integer o1, Integer o2) {
		int val1 = o1.intValue();
		int val2 = o2.intValue();
		return (val1 < val2 ? -1 : (val1 == val2 ? 0 : 1));
	}

	public int compareImp(Boolean o1, Boolean o2) {
		return (o1.equals(o2) ? 0 : (o1.booleanValue() == true ? 1 : -1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] abc = new String[3];
		abc[0]="abc";
		abc[1]="ghi";
		abc[2]="def";
		
		for(int i=0;i<abc.length;i++) {
			System.out.println(abc[i]);
		}
		
		java.util.Arrays.sort(abc, new CompareObject()); 
		
		for(int i=0;i<abc.length;i++) {
			System.out.println(abc[i]);
		}
	}

}
