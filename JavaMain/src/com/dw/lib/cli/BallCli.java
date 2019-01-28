package com.dw.lib.cli;

import java.util.HashSet;
import java.util.UUID;

public class BallCli {

	public static int BallRandom() {
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
				base %= 35;
			}
			counter++;

			total += num * base;
		}
		return total;
	}

	public static void generate() {
		HashSet<Integer> hash = new HashSet<>();

		for (int k = 0; k < 8; k++) {

			int total = BallRandom();

			if (k < 7) {
				int result = total % 35;
				if (result == 0) {
					k--;
					continue;
				}
				if (!hash.contains(result)) {
					System.out.print(result + " ");
					hash.add(result);
				} else {
					k--;
					continue;
				}
			} else {
				int result = total % 20;
				if (result == 0) {
					k--;
					continue;
				}
				System.out.print(total % 20 + " ");
			}
		}
	}

	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				System.out.println("ball to view a text file");
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
