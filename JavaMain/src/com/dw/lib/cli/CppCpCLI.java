package com.dw.lib.cli;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import com.dw.lib.EnvironmentHelper;
import com.dw.lib.FileUtils;

public class CppCpCLI {

	public static void help() {
		System.out.println("cppcp  <input folder> <output folder>");
		System.out.println("use path");
		System.out.println("output folder: ./cpp/");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			help();
			return;
		}
		
		FileUtils fileUtils = new FileUtils();
		String mainPath = args[0];
		String outputFolder = args[1];
		boolean isWindows = EnvironmentHelper.getOSType() == EnvironmentHelper.OSType.WIN;
		
		if(isWindows) {
			if (!mainPath.endsWith("\\")) {
				mainPath += "\\";
			}
		} else {
			if (!mainPath.endsWith("/")) {
				mainPath += "/";
			}
		}
		
		if(isWindows) {
			if (!outputFolder.endsWith("\\")) {
				outputFolder += "\\";
			}
		} else {
			if (!outputFolder.endsWith("/")) {
				outputFolder += "/";
			}
		}

		try {
			List<Path> headerFile = fileUtils.listFiles(mainPath, ".*.h");
			for(Path p : headerFile) {
				String outputFile = p.toString().replace(mainPath, outputFolder);
				File output = new File(outputFile);
				if(!fileUtils.isExisted(output.getParent())) {
					(new File(output.getParent())).mkdirs();
				}
				fileUtils.copyFileUsingStream(p.toFile(), output);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
