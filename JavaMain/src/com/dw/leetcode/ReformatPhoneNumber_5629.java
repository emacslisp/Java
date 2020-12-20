package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-220/problems/reformat-phone-number/
public class ReformatPhoneNumber_5629 {

	public String reformatNumber(String number) {
		StringBuilder sb = new StringBuilder();
		
		String filtedNumber = number.replace(" ", "").replace("-", "");
		
		int length = filtedNumber.length();
		int startIndex = 0;
		int endIndex = startIndex + 3;
		while(length > 4) {
			String t = filtedNumber.substring(startIndex, endIndex);
			startIndex = endIndex;
			endIndex = startIndex +3;
			sb.append(t + "-");
			length -= 3;
		}
		
		if(length == 4) {
			String t1 = filtedNumber.substring(startIndex, startIndex+2);
			String t2 = filtedNumber.substring(startIndex+2, startIndex+4);
			sb.append(t1 + "-" + t2);
		}
		
		if (length == 3 || length == 2) {
			sb.append(filtedNumber.substring(startIndex, startIndex + length));
		}
		return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReformatPhoneNumber_5629 s= new ReformatPhoneNumber_5629();
		String input = "123 4-5678";
		String result = s.reformatNumber(input);
		
		System.out.println(result);
	}

}
