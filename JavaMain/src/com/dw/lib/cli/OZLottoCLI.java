package com.dw.lib.cli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.dw.lib.RandomService;

public class OZLottoCLI {
	
	public static int T = 45;
	public static List<Integer> generate() {
		HashSet<Integer> hash = new HashSet<>();
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> numbers2 = new ArrayList<Integer>();
		
		int counter = 1;
		
		while(counter <= 7) {
			int result = RandomService.UUIDRandom(T);

			if (!hash.contains(result)) {
				counter++;
				numbers.add(result == 0? T: result);
				hash.add(result);
			} 
		}
		
		Collections.sort(numbers);
		
		counter = 1;
				
		while(counter <= 2) {
			int result = RandomService.UUIDRandom(T);

			if (!hash.contains(result)) {
				counter++;
				numbers2.add(result == 0? T: result);
				hash.add(result);
			}
		}
		
		Collections.sort(numbers2);
		
		for(Integer x: numbers2) {
			numbers.add(x);
		}
		
		return numbers;
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
			List<Integer> result = null;
			for (int i = 0; i < num; i++) {
				result = generate();
				int counter = 1;
				for(Integer x: result) {
					if(counter <= 7)
						System.out.print(x + " ");
					else {
						if(counter == 8) System.out.print("  ");
						System.out.print(x + " ");
					}
					counter++;
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
