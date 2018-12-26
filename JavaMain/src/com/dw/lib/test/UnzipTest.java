package com.dw.lib.test;

import java.io.File;

import com.dw.lib.FileUtils;
import com.dw.lib.ZipUtils;

public class UnzipTest {
	
	public static void main(String[] args) {
		ZipUtils appZip = new ZipUtils();
		
		FileUtils fileUtils = new FileUtils();
		
		System.out.println(fileUtils.normalizePath("."));
		
		appZip.unzipIt("/Users/di.wu/test/ziptest/output.zip", "/Users/di.wu/test/ziptest");
	}
}
