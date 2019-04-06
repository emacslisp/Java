package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class googlecodejam_2018_Qualification_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*FileInputStream instream = null;
		PrintStream outstream = null;

		try {
			instream = new FileInputStream("/Users/ewu/test/0.txt");
			outstream = new PrintStream("/Users/ewu/test/0.out");
			System.setIn(instream);
			System.setOut(outstream);
		} catch (Exception e) {
			System.err.println("Error Occurred");
		}*/

		Scanner in = new Scanner(System.in);
		String strT = in.nextLine();
		int T = Integer.parseInt(strT);

		for (int i = 0; i < T; i++) {
			System.out.print(String.format("Case #%d: ", (i + 1)));

			String line = in.nextLine();

			String[] temp = line.split(" ");

			int D = Integer.parseInt(temp[0]);
			String P = temp[1];
			
			int prefix = 1;
			int total[] = new int[101];
			int index = 0;
			int sCounter = 0;
			for(int m=0;m<P.length();m++) {
				char c = P.charAt(m);
				if(c == 'S') {
					total[index++] = prefix;
					sCounter++;
				}
				else if(c=='C') {
					prefix *= 2;
				}
			}
			
			int totalD = 0;
			for(int m=0; m<total.length;m++) {
				totalD += total[m];
			}
			
			if(totalD < D) {
				System.out.println(0);
				continue;
			}
			
			if(sCounter > D) {
				System.out.println("IMPOSSIBLE");
				continue;
			}

			int counter = 0;
			
			while(totalD > D) {
				int pointer = index -1;
				int flag = total[pointer];
				
				if(pointer == 0) {
					total[pointer] /= 2;
					totalD -= total[pointer];
					counter++;
					continue;
				}
				boolean f = true;
				for(int k=pointer -1;k>=0;k--) {
					if(total[k] != flag) {
						total[k + 1] /= 2;
						totalD -= total[k + 1];
						f = false;
						break;
					}
				}
				
				if(f) {
					total[0]/=2;
					totalD -= total[0];
				}
				
				counter++;
			}
			
			System.out.println(counter);
		}
	}
}
