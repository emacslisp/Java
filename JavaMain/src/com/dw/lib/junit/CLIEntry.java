/**
 * 
 */
package com.dw.lib.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dw.lib.FileUtils;

import junit.framework.Assert;

/**
 * @author ewu
 *
 */
public class CLIEntry {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		FileUtils fileUtil = new FileUtils();
		try {
			List<String> result = fileUtil.fileToList("/Users/ewu/test/1.txt");
			Assert.assertEquals(result.size(), 226);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPath() {
		File file = new File("/Users/ewu/dev/cpp/bochs-cli/main.cpp");
		
		String fileName = file.getName();
		Assert.assertEquals(fileName, "main.cpp");
	}
	
	@Test
	public void testRegexSuccess() {
		File file = new File("/Users/ewu/dev/cpp/bochs-cli/main.h");
		
		String fileName = file.getName();
		Pattern pattern = Pattern.compile(".*.h");
		
		Matcher m = pattern.matcher(fileName);
		boolean b = m.matches();  
		Assert.assertEquals(b, true);
	}
	
	@Test
	public void testRegexFailed() {
		File file = new File("/Users/ewu/dev/cpp/bochs-cli/main.hpp");
		
		String fileName = file.getName();
		Pattern pattern = Pattern.compile(".*.h");
		
		Matcher m = pattern.matcher(fileName);
		boolean b = m.matches();  
		Assert.assertEquals(b, false);
	}
	
	@Test
	public void testRecurise() {
		FileUtils fileUtils = new FileUtils();
		String mainPath = "/Users/ewu/dev/bochs-src/bochs-20180819";
		String outputFolder = "/Users/ewu/test/cpp1";
		
		if (!mainPath.endsWith("/")) {
			mainPath += "/";
		}
		
		if (!outputFolder.endsWith("/")) {
			outputFolder += "/";
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
