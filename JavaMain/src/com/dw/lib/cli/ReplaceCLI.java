package com.dw.lib.cli;

import java.io.IOException;
import java.util.regex.Pattern;

import com.dw.lib.FileUtils;

public class ReplaceCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length == 0 || args.length != 2) {
			System.out.println("replace '/old-string/new-string/' <fileName>");
			System.out.println("ignore case replacement");
			System.out.println("replace '/old-string/new-string/i' <fileName>");
			return;
		}
		
		FileUtils fileUtils = new FileUtils();
		
		String inputRegx = args[0];
		String filePath = args[1];
		
		try {
			
			String fileContent = fileUtils.fileToString(filePath);
			String[] inputs = inputRegx.split("/");
			
			Pattern p;
			if(inputs.length == 4 && inputs[3].equals("i")) {
				p = Pattern.compile(inputs[1], Pattern.CASE_INSENSITIVE);
			} else {
				p = Pattern.compile(inputs[1]);
			}
			
			fileContent = p.matcher(fileContent).replaceAll(inputs[2]);
			
			fileUtils.stringToFile(fileContent, filePath);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
