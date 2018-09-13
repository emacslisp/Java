package com.dw.lib;

public class EnvironmentHelper {
	
	public static enum OSType {
		WIN,
		MACOS,
		UNIX,
		LINUX,
		SUNOS,
		UNKNOWN
	}
	
	public static String getEnv(String envName) {
		return System.getenv(envName);
	}
	
	public static OSType getOSType() {
		String OS = System.getProperty("os.name").toLowerCase();
		if(OS.indexOf("win") >= 0) {
			return OSType.WIN;
		}
		
		if (OS.indexOf("mac") >= 0) {
			return OSType.MACOS;
		}
		
		if (OS.indexOf("nux") >= 0) {
			return OSType.LINUX;
		}
		
		if (OS.indexOf("nix") >= 0 || OS.indexOf("aix") > 0 ) {
			return OSType.UNIX;
		}
		
		if (OS.indexOf("sunos") >= 0) {
			return OSType.SUNOS;
		}
		
		return OSType.UNKNOWN;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(EnvironmentHelper.getEnv("PATH"));
	}

}
