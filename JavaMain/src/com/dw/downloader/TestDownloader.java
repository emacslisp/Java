package com.dw.downloader;

import java.io.IOException;
import java.net.*;

public class TestDownloader {
	public static void main(String[] args) {
	    int len = 0;
	    String path = "http://dl1.video.varzesh3.com/video/clip93/12/video/havashi/top5_save_derby_dortmond.mp4";
	    URL url;
		try {
			url = new URL(path);
		
		    URLConnection connectUrl = url.openConnection();
		    System.out.println(len = connectUrl.getContentLength());
		    System.out.println(connectUrl.getContentType());
	    
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
