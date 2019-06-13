package com.dw.lib.cli;

import java.util.HashSet;

import com.dw.lib.RandomService;

public class OZLottoCLI {
	public static void generate() {
HashSet<Integer> hash = new HashSet<>();
		
		int counter = 1;
		
		while(counter <= 7) {
			int result = RandomService.UUIDRandom(35);

			if (!hash.contains(result)) {
				System.out.print((result == 0? 45: result) + " ");
				hash.add(result);
			} 
		}
		
		counter = 1;
		System.out.print("  ");
		
		while(counter <= 2) {
			int result = RandomService.UUIDRandom(35);

			if (!hash.contains(result)) {
				System.out.print((result == 0? 45: result) + " ");
				hash.add(result);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if (args.length != 1) {
				System.out.println("ozl to generate 7 win number and 2 Supps number");
				System.out.println("ozl <how many you want to generate>");
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
