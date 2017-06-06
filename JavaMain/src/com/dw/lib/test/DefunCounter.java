package com.dw.lib.test;

import java.io.*;
import java.util.regex.Pattern;

public class DefunCounter {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] FILENAME = { "/path/to/lisp.el" };
		try {
			int total = 0;
			for (int i = 0; i < FILENAME.length; i++) {
				BufferedReader br = new BufferedReader(new FileReader(FILENAME[i]));
				int counter = 0;
				String sCurrentLine;
				Pattern pattern = Pattern.compile("\\(defun .*");

				while ((sCurrentLine = br.readLine()) != null) {
					// System.out.println(sCurrentLine);

					if (pattern.matcher(sCurrentLine).find())
						counter++;

				}
				br.close();
				total += counter;
				
				System.out.println(FILENAME[i] + "\t" + counter);
			}
			System.out.println("Total " + total);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
