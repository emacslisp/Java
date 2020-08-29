package com.dw.lib;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrepUtils {
	private static void printUsageAndExit() {
		
	}
	
	public void grep(String path, String r) {
		FileUtils fileUtils = new FileUtils();

		List<Path> result = fileUtils.listFiles(path, false);
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile(r);
		 
		
		for (Path p : result) {
			try {
				sb.setLength(0);
				List<String> s = fileUtils.fileToList(p.toString());
				for(int i=0;i<s.size();i++) {
					String line = s.get(i);
					Matcher m = pattern.matcher(line); 
					if (m.find()) {
						sb.append((i+1) + ": " + line + System.lineSeparator());
					}
				}
				
				if(sb.length() > 0) {
					System.out.println(p.toString());
					System.out.println(sb.toString());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrepUtils grepUtils = new GrepUtils();
		
		grepUtils.grep("/Users/ewu/test", "System.out.print");
	}

}
