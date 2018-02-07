package com.dw.lib;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
	
    public String readFile(String path, Charset encoding) throws IOException 
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
	public String fileToString(String filePath) throws IOException {
        String s = readFile(filePath,Charset.defaultCharset());

       	return s;
	}
	
	public void stringToFile(String content, String filePath) throws IOException {
		BufferedWriter writer = null;
		writer = new BufferedWriter( new FileWriter( filePath));
		writer.write(filePath);
		writer.flush();
		writer.close();
	}
}
