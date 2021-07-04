package main;

import java.io.File;
import java.io.IOException;

public class BootstrapEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		File homeFile = null;
		File bootstrapJar = new File(userDir, "bootstrap.jar");
		
		if (bootstrapJar.exists()) {
			File f = new File(userDir, "..");
			try {
				homeFile = f.getCanonicalFile();
			} catch (IOException ioe) {
				homeFile = f.getAbsoluteFile();
			}
		}
		
		if (homeFile == null) {
			// Second fall-back. Use current directory
			File f = new File(userDir);
			try {
				homeFile = f.getCanonicalFile();
			} catch (IOException ioe) {
				homeFile = f.getAbsoluteFile();
			}
		}
		System.out.println(homeFile.getAbsolutePath());
	}

}
