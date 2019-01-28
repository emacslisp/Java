package com.dw.lib.cli;

import java.util.HashSet;
import java.util.UUID;

public class BallCLI {

	public static int BallRandom(int baseNum) {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");

		int counter = 0;
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
			for (int j = 0; j < counter; j++) {
				base *= 16;
				base %= baseNum;
			}
			counter++;

			total += num * base;
		}
		return total;
	}

	public static void generate() {
		HashSet<Integer> hash = new HashSet<>();

		for (int k = 0; k < 8; k++) {
			if (k < 7) {
				int total = BallRandom(35);
				int result = total % 35;

				if (!hash.contains(result)) {
					System.out.print((result == 0? 35: result) + " ");
					hash.add(result);
				} else {
					k--;
					continue;
				}
			} else {
				int total = BallRandom(20);
				int result = total % 20;
				System.out.print(result == 0? 20: result);
			}
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				System.out.println("ball to generate 8 number");
				System.out.println("ball <how many you want to generate>");
				return;
			}

			int num = Integer.parseInt(args[0]);

			for (int i = 0; i < num; i++) {
				generate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
