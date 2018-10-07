package com.dw.lib.cli;

import com.dw.lib.EnvironmentHelper;
import com.dw.lib.FileUtils;
import java.util.*;

public class WhereCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if (args.length != 1){
				System.out.println("List all execute file within PATH environment");
				System.out.println("jwhere <execute file>");
				return;
			}
			
			boolean isWindows = EnvironmentHelper.getOSType() == EnvironmentHelper.OSType.WIN;
			String pathSplitter = "/";
			String envSplitter = ":";
			String pathExt = "";
			
			if (isWindows) {
				pathSplitter = "\\";
				envSplitter = ";";
				pathExt = EnvironmentHelper.getEnv("PATHEXT");
			}
			
			String path = EnvironmentHelper.getEnv("PATH");
			String[] paths = path.split(envSplitter);
			String executeFile = args[0];
			FileUtils utils = new FileUtils();
			
			List<String> result = new ArrayList<String>();
			
			for(String p : paths) {
				if(p.endsWith(pathSplitter)) {
					p = p.substring(0, p.length() - 2);
				}
				String tempFullPath = p + pathSplitter + executeFile;
				if(utils.isExisted(tempFullPath) && utils.isFile(tempFullPath)) {
					if(!result.contains(tempFullPath))
						result.add(tempFullPath);
				}
				
				if(isWindows) {
					for(String ext : pathExt.split(envSplitter)) {
						tempFullPath = p + pathSplitter + executeFile + ext.toLowerCase();
						if(utils.isExisted(tempFullPath) && utils.isFile(tempFullPath)) {
							if(!result.contains(tempFullPath))
								result.add(tempFullPath);
						}
					}
				}
			}
			
			for (String s: result) {
				System.out.println(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
