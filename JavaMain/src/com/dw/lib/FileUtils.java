package com.dw.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
	
	/**
	 * 
	 * @param path
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
    private String readFile(String path, Charset encoding) throws IOException 
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    /**
     * read file into one whole string, large file should be careful
     * @param path of files
     * @return File string
     */
	public String fileToString(String filePath) throws IOException {
        String s = readFile(filePath,Charset.defaultCharset());

       	return s;
	}
	
	/**
	 * file content to list of String
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public List<String> fileToList(String filePath) throws IOException {
		List<String> result = new ArrayList<String>();
		
		try {
			FileInputStream fstream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		    String line;
		    while ((line = br.readLine()) != null) {
		       // process the line.
		    	result.add(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * append string to file
	 * @param content
	 * @param filePath
	 * @throws IOException
	 */
	public void appendStringToFile(String content, String filePath) throws IOException {
		StringBuffer sb = new StringBuffer();
		String s = readFile(filePath,Charset.defaultCharset());
		sb.append(s);
		sb.append(content);
		stringToFile(sb.toString(), filePath);
	}
	
	/**
	 * write string to file
	 * @param content
	 * @param filePath
	 * @throws IOException
	 */
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
		List<Path> paths = listFiles(rootDirectory, false);
		
		return 0;
	}
	
	/**
	 * 
	 * @param rootDirectory
	 * @return
	 */
	public static List<Path> listFiles(String rootDirectory, boolean isIncludingEmptyFolder)
	{
	    List<Path> files = new ArrayList<Path>();
	    listFiles(rootDirectory, files, isIncludingEmptyFolder);

	    return files;
	}
	
	/**
	 * get related path from absoluted path
	 * @param base
	 * @param file
	 * @return
	 */
	public static String relative(final File base, final File file) {
		final int rootLength = base.getAbsolutePath().length();
		final String absFileName = file.getAbsolutePath();
		final String relFileName = absFileName.substring(rootLength + 1);
		return relFileName;
	}

	
	/**
	 * get full list of Files
	 * @param path
	 * @param collectedFiles
	 */
	private static void listFiles(String path, List<Path> collectedFiles, boolean isIncludingEmptyFolder)
	{
	    File root = new File(path);
	    File[] files = root.listFiles();

	    if (files == null)
	    {
	        return;
	    }
	    
	    if(files.length == 0 && isIncludingEmptyFolder) {
	    	// add empty folder here
	    	collectedFiles.add(root.toPath());
	    	return;
	    }

	    for (File file : files)
	    {
	        if (file.isDirectory())
	        {
	            listFiles(file.getAbsolutePath(), collectedFiles, isIncludingEmptyFolder);
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
	
	public String normalizePath(String path) {
		path = path.replaceFirst("^~", System.getProperty("user.home"));
		return Paths.get(path).toAbsolutePath().normalize().toString();
	}
	
	public static String getPathSplitter() {
		boolean isWindows = EnvironmentHelper.getOSType() == EnvironmentHelper.OSType.WIN;
		String pathSplitter = "/";

		if (isWindows) {
			pathSplitter = "\\";
		}
		return pathSplitter;
	}
	
	/**
	 * copy File Using Stream buffer
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	public void copyFileUsingStream(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	    	if(dest.isDirectory()) {
	    		String targetFileName = source.getName();
	    		String path = dest.getAbsolutePath().concat(FileUtils.getPathSplitter()).concat(targetFileName);
	    		dest = new File(path);
	    	}
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	    finally {
	        is.close();
	        os.close();
	    }
	}
	
	/**
	 * get a list of file from source folder and copy same struction to dest folder
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	public void copyFolderUsingStream(File source, File dest) throws IOException {
		if(dest.isFile()) {
			System.out.println(dest.getAbsolutePath() + " is a file, Target can not be a file");
			return;
		}
		
	    try {
	    	List<Path> fileList = listFiles(source.getAbsolutePath(), true);
	    	
	    	for(Path p : fileList) {
	    		File sourceFile = p.toFile();
	    		if(sourceFile.isDirectory()) {
	    			// mkdirs for empty folder
	    			sourceFile.mkdirs();
	    			continue;
	    		}
	    		
	    		String relatedPath = relative(source, p.toFile());
	    		File targetFile = new File(dest, relatedPath);
	    		if(!targetFile.getParentFile().exists()) {
	    			targetFile.getParentFile().mkdirs();
	    		}
	    		
	    		copyFileUsingStream(p.toFile(), targetFile);
	    	}
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
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
