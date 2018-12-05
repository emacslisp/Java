package com.dw.lib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
	
    public String readFile(String path, Charset encoding) throws IOException 
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    /*
     * read file into string, large file should be careful
     * @param path of files
     * @return File string
     */
	public String fileToString(String filePath) throws IOException {
        String s = readFile(filePath,Charset.defaultCharset());

       	return s;
	}
	
	public List<String> fileToList(String filePath) throws IOException {
		List<String> result = new ArrayList<String>();
		
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

			result = stream
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// save string to File, thow exception
	public void stringToFile(String content, String filePath) throws IOException {
		BufferedWriter writer = null;
		writer = new BufferedWriter( new FileWriter( filePath));
		writer.write(content);
		writer.flush();
		writer.close();
	}
	
	//get Max Size of Files under a folder
	// @todo: finish max File size
	public long maxFilesize(String rootDirectory) {
		List<Path> paths = listFiles(rootDirectory);
		
		return 0;
	}
	
	//get list of Path
	public static List<Path> listFiles(String rootDirectory)
	{
	    List<Path> files = new ArrayList<Path>();
	    listFiles(rootDirectory, files);

	    return files;
	}
	
	private static void listFiles(String path, List<Path> collectedFiles)
	{
	    File root = new File(path);
	    File[] files = root.listFiles();

	    if (files == null)
	    {
	        return;
	    }

	    for (File file : files)
	    {
	        if (file.isDirectory())
	        {
	            listFiles(file.getAbsolutePath(), collectedFiles);
	        } else
	        {
	            collectedFiles.add(file.toPath());
	        }
	    }
	}
	
	public boolean isExisted (String filePath) {
		boolean result = false;
		
		Path path = Paths.get(filePath);
		
		result = Files.exists(path);
		
		return result;
	}
	
	public boolean isFile(String filePath) {
		File file = new File(filePath);
		return file.isFile();
	}
	
	public boolean isDirectory(String filePath) {
		File file = new File(filePath);
		return file.isDirectory();
	}
	
	public static void main(String[] args) {

		FileUtils utils = new FileUtils();
		try {
			List<String> result = utils.fileToList("/Users/ewu/dev/java/JavaMain/src/com/dw/lib/FileUtils.java");
			for(String s : result) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
