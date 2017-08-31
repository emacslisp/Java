package com.dw.lib.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SplitPath {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String FILENAME = "/Users/ewu/dev/mysql/mysql-5.7.18/files.txt";
		try {

			BufferedReader br = new BufferedReader(new FileReader(FILENAME));

			String sCurrentLine;
			int counter = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				String[] str = sCurrentLine.split("/");
				System.out.println("br s -f " + str[str.length - 1] + " --match-declaration-file --func-regex .*");
				counter++;
			}
			
			for(int i=1;i<=counter;i++) {
				System.out.println("br com add " + i);
				System.out.println("bt");
				System.out.println("continue");
				System.out.println("DONE");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
