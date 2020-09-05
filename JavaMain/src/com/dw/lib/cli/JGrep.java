package com.dw.lib.cli;

import java.util.ArrayList;
import java.util.List;

import com.dw.lib.GrepUtils;

public class JGrep {

	private static void printUsageAndExit() {
		System.out.println("jgrep <regex> <path> --exclude <ex1, ex2>");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> excludeList = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("-")) {
				switch (args[i]) {
				case "--exclude":
					String[] sList = args[i + 1].split(",");
					for (String s : sList) {
						excludeList.add(s.trim());
					}
					break;
				case "--help":
					printUsageAndExit();
					break;
				}
			}
		}

		GrepUtils grepUtils = new GrepUtils();
		grepUtils.grep(args[1], args[0], excludeList);

	}

}
