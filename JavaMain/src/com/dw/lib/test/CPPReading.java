package com.dw.lib.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dw.lib.FileUtils;

public class CPPReading {

	public static void main(String[] args) {
		FileUtils fileUtils = new FileUtils();
		String mainPath = "/Users/ewu/test/cpp/";
		StringBuilder sb = new StringBuilder();
		List<String> output = new ArrayList<String>();
		try {
			List<String> lines = fileUtils.fileToList("/Users/ewu/test/1.txt");
			
			for(String line : lines) {
				String[] paths = line.split("/");
				sb.append(mainPath);
				for(int i=0;i<paths.length-1;i++) {
					if(!paths[i].equals("."))
						sb.append(paths[i] + "/");
				}
				output.add("mkdir -p " + sb.toString());
				output.add("cp " + line + " " + sb.append(paths[paths.length-1]));
				sb.setLength(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String s: output) {
			System.out.println(s);
		}
		
	}

}
