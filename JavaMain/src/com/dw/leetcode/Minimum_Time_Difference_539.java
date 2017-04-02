package com.dw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//@example: Leetcode - 414. Third Maximum Number - https://leetcode.com/problems/minimum-time-difference/#/description
public class Minimum_Time_Difference_539 {

	public static int getMin(String s) {
		String[] s1 = s.split(":");
		int s1_hours = Integer.parseInt(s1[0]);
		int s1_minutes = Integer.parseInt(s1[1]);

		return s1_hours * 60 + s1_minutes;
	}

	public static int getMinMinutes(String s1, String s2) {
		int total_min1 = getMin(s1);
		int total_min2 = getMin(s2);

		return Math.min(Math.abs(total_min1 - total_min2), 24 * 60 - Math.abs(total_min1 - total_min2));
	}

	public static int findMinDifference(List<String> timePoints) {
		String[] str = new String[timePoints.size()];

		for (int i = 0; i < str.length; i++) {
			str[i] = timePoints.get(i);
		}

		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {

				int totalMinutes1 = getMin(str1);
				int totalMinutes2 = getMin(str2);

				if (totalMinutes1 > totalMinutes2)
					return 1;
				if (totalMinutes1 < totalMinutes2)
					return -1;

				return 0;
			}
		};

		Arrays.sort(str, comparator);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < str.length - 1; i++) {
			int temp = getMinMinutes(str[i], str[i + 1]);

			if (temp < min)
				min = temp;
		}

		int temp = getMinMinutes(str[0], str[str.length - 1]);

		if (temp < min)
			min = temp;

		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> test = new ArrayList<String>();
		test.add("05:31");
		test.add("22:08");
		test.add("00:35");
		System.out.println(findMinDifference(test));

	}

}
