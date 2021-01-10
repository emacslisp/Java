package com.dw.lib.cli;

import java.util.List;

import com.dw.lib.FileUtils;

public class CatCLI {

	public static void main(String[] args) {
		try {
			if (args.length < 1){
				System.out.println("jcat to view a text file");
				System.out.println("jcat <text file>");
				return;
			}
			
			FileUtils utils = new FileUtils();
			for(int i=0;i<args.length;i++) {
				System.out.println(args[i] + ":");
				List<String> result = utils.fileToList(args[i]);
				for(String s : result) {
					System.out.println(s);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
