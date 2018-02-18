package com.dw.lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtils {
	public static void ping(String host) {
		String ipAddress = "127.0.0.1";
		InetAddress inet;
		try {
			/*
			inet = InetAddress.getByName(ipAddress);

			System.out.println("Sending Ping Request to " + ipAddress);
			System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");*/

			//ipAddress = "173.194.32.38";
			inet = InetAddress.getByName(host);

			System.out.println("Sending Ping Request to " + ipAddress);
			System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void HttpDownload(String urlPath, String path) {
	    int len = 1024;
	    //String path = "http://dl1.video.varzesh3.com/video/clip93/12/video/havashi/top5_save_derby_dortmond.mp4";
	    URL url;
		try {
			url = new URL(urlPath);
		
		    URLConnection connectUrl = url.openConnection();
		    //connectUrl.setRequestProperty("Range", "Bytes=0-1024");
		    //System.out.println(len = connectUrl.getContentLength());
		    System.out.println(connectUrl.getContentType());
		    connectUrl.connect();
		    File file = new File(path);
		    
		    OutputStream outputStream = null;
		    outputStream = new FileOutputStream(file);
		    InputStream inputStream = connectUrl.getInputStream();
		    int read = 0;
			byte[] bytes = new byte[len];
			int off = 0;
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
