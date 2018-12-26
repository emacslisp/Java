package com.dw.lib.test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.dw.lib.FileUtils;
import com.dw.lib.ZipUtils;

public class ZipTest {
	public static void main(String[] args) {
		ZipUtils appZip = new ZipUtils();
		
		FileUtils fileUtils = new FileUtils();
		
		System.out.println(fileUtils.normalizePath("~/test"));
		
		appZip.zipIt(new File(fileUtils.normalizePath("~/test")), new File("output.zip"));
	}
}
