package com.dw.downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class TestDownloader {
	public static void main(String[] args) {
	    int len = 0;
	    String path = "http://dl1.video.varzesh3.com/video/clip93/12/video/havashi/top5_save_derby_dortmond.mp4";
	    URL url;
		try {
			url = new URL(path);
		
		    URLConnection connectUrl = url.openConnection();
		    connectUrl.setRequestProperty("Range", "Bytes=0-1024");
		    System.out.println(len = connectUrl.getContentLength());
		    System.out.println(connectUrl.getContentType());
		    connectUrl.connect();
		    File file = new File("/Users/ewu/test/test.mp4");
		    
		    OutputStream outputStream = null;
		    outputStream = new FileOutputStream(new File("/Users/ewu/test/test.mp4"));
		    
		    InputStream inputStream = connectUrl.getInputStream();
		    int read = 0;
			byte[] bytes = new byte[1024];
		    while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		    
		    outputStream.flush();
		    outputStream.close();
	    
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
