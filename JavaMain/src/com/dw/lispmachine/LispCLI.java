package com.dw.lispmachine;

import java.util.List;

import com.dw.lib.FileUtils;

public class LispCLI {

	public static void main(String[] args) {
		try {
			if (args.length != 1){
				System.out.println("lisp <lisp-file>");
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
