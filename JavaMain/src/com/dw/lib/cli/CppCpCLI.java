package com.dw.lib.cli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dw.lib.FileUtils;

public class CppCpCLI {

	public static void help() {
		System.out.println("cppcp  <input file> <output folder> <sh-output>");
		System.out.println("output folder: ./cpp/");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 3) {
			help();
			return;
		}
		
		FileUtils fileUtils = new FileUtils();
		String mainPath = args[1];
		StringBuilder sb = new StringBuilder();
		List<String> output = new ArrayList<String>();
		try {
			List<String> lines = fileUtils.fileToList(args[0]);
			
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
			
			fileUtils.listToFile(output, args[2]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
