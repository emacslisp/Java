package com.dw.lib.test;

import com.dw.lib.EnvironmentHelper;
import com.dw.lib.FileUtils;

public class WhereCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if (args.length != 1){
				System.out.println("List all execute file within PATH environment");
				System.out.println("jwhere <execute file>");
				return;
			}
			
			String path = EnvironmentHelper.getEnv("PATH");
			String[] paths = path.split(":");
			String executeFile = args[0];
			FileUtils utils = new FileUtils();
			String pathSplitter = EnvironmentHelper.getOSType() == EnvironmentHelper.OSType.WIN? "\\": "/";
			
			for(String p : paths) {
				if(p.endsWith(pathSplitter)) {
					p = p.substring(0, p.length() - 2);
				}
				String tempFullPath = p + pathSplitter + executeFile;
				if(utils.isExisted(tempFullPath)) {
					System.out.println(tempFullPath);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
