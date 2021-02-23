package com.dw.lib.test;

import java.io.IOException;
import java.util.Random;

import com.dw.lib.FileUtils;

public class OJGenerateData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		FileUtils fileUtils = new FileUtils();
		String input = "";
		String output = "";
		for(int i=1;i<=100;i++) {
			int A = (1 + rand.nextInt(100000000));
			int B = (1 + rand.nextInt(100000000));
			input += (A + " " + B + "\n");
			output += (A + B) + "\n";
		}
		
		String basePath = "/Users/ewu/test";
		
		try {
			fileUtils.stringToFile(input, basePath + "/AB.in");
			fileUtils.stringToFile(output, basePath + "/AB.out");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
