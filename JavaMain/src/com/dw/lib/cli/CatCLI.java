package com.dw.lib.cli;

import java.util.List;

import com.dw.lib.FileUtils;

public class CatCLI {

	public static void main(String[] args) {
		try {
			if (args.length != 1){
				System.out.println("jcat to view a text file");
				System.out.println("jcat <text file>");
				return;
			}
			
			FileUtils utils = new FileUtils();
			List<String> result = utils.fileToList(args[0]);
			for(String s : result) {
				System.out.println(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
