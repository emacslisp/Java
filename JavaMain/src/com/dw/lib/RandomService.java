package com.dw.lib;

import java.util.Random;
import java.util.UUID;

public class RandomService {
	
	
	/*
	 * 
	 * @param length randomString lenght
	 * */
	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<=length/32;i++) {
			sb.append(UUID.randomUUID().toString().replace("-", ""));
		}
		
		return sb.toString().substring(0, length);
	}
	
	public static int UUIDRandom(int baseNum) {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");

		int total = 0;
		for (int i = 0; i < uuid.length(); i++) {
			char c = uuid.charAt(i);
			int num = 0;
			if (c >= '0' && c <= '9') {
				num = c - '0';
			}

			if (c >= 'a' && c <= 'z') {
				num = c - 'a' + 10;
			}

			int base = 1;
			for (int j = 0; j < i; j++) {
				base *= 16;
				base %= baseNum;
			}

			total += num * base;
		}
		return total % baseNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String output = RandomService.randomString(10);
		System.out.println(output);
	}

}
