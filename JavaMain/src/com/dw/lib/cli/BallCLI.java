package com.dw.lib.cli;

import java.util.HashSet;
import java.util.UUID;

import com.dw.lib.RandomService;

public class BallCLI {

	public static void generate() {
		HashSet<Integer> hash = new HashSet<>();

		for (int k = 0; k < 8; k++) {
			if (k < 7) {
				int result = RandomService.UUIDRandom(35);

				if (!hash.contains(result)) {
					System.out.print((result == 0? 35: result) + " ");
					hash.add(result);
				} else {
					k--;
					continue;
				}
			} else {
				int result = RandomService.UUIDRandom(20);
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
