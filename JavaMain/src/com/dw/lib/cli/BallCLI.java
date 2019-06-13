package com.dw.lib.cli;

import java.util.*;
import java.util.HashSet;
import java.util.UUID;

import com.dw.lib.RandomService;

public class BallCLI {

	public static List<Integer> generate() {
		HashSet<Integer> hash = new HashSet<>();
		List<Integer> numbers = new ArrayList<Integer>();
		for (int k = 0; k < 8; k++) {
			if (k < 7) {
				int result = RandomService.UUIDRandom(35);

				if (!hash.contains(result)) {
					numbers.add((result == 0? 35: result));
					hash.add(result);
				} else {
					k--;
					continue;
				}
			} else {
				Collections.sort(numbers);
				int result = RandomService.UUIDRandom(20);
				numbers.add(result == 0? 20: result);
			}
		}
		
		return numbers;
	}

	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				System.out.println("ball to generate 8 number");
				System.out.println("ball <how many you want to generate>");
				return;
			}

			int num = Integer.parseInt(args[0]);
			List<Integer> result = null;
			for (int i = 0; i < num; i++) {
				result = generate();
				for (Integer x: result) {
					System.out.printf("%d ", x);
				}
				System.out.println();
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
