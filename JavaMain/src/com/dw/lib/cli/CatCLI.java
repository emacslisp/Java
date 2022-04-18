package com.dw.lib.cli;

import java.util.List;

import com.dw.lib.FileUtils;

public class CatCLI {

	public static void main(String[] args) {
		try {
			if (args.length < 1){
				System.out.println("jcat to view a text file");
				System.out.println("jcat -l <text file>");
				return;
			}
			
			FileUtils utils = new FileUtils();
			boolean state = false;
			
			for(int i=0;i<args.length;i++) {
				boolean showLine = args[i].equals("-l");
				if (showLine)  {
					state = true;
					continue;
				}
				
				System.out.println(args[i] + ":");
				List<String> result = utils.fileToList(args[i]);
				int lineNumber = 1;
				
				for(String s : result) {
					if (state) {
						System.out.print(lineNumber + ":\t");
						lineNumber++;
					}
					System.out.println(s);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
