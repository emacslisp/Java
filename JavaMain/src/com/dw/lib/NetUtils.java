package com.dw.lib;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtils {
	public static void ping(String host, int counter) {
		String ipAddress = "127.0.0.1";
		InetAddress inet;
		try {
			/*
			inet = InetAddress.getByName(ipAddress);

			System.out.println("Sending Ping Request to " + ipAddress);
			System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");*/

			//ipAddress = "173.194.32.38";
			inet = InetAddress.getByName(host);

			while(counter > 0) {
				System.out.println("Sending Ping Request to " + ipAddress);
				System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
				counter--;
			}
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
			
			if(path == null)
				path = FilenameUtils.getName(url.getPath());
			
			HttpURLConnection connectUrl = (HttpURLConnection) url.openConnection();
		    //connectUrl.setRequestProperty("Range", "Bytes=0-1024");
		    //System.out.println(len = connectUrl.getContentLength());
		    System.out.println(connectUrl.getContentType());
		    
		    boolean redirect = false;
		    
		    // normally, 3xx is redirect
			int status = connectUrl.getResponseCode();
			if (status != HttpURLConnection.HTTP_OK) {
				if (status == HttpURLConnection.HTTP_MOVED_TEMP
					|| status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER)
				redirect = true;
			}
		
			// following multiple redirect
			while(redirect) {
				
				String newUrl = connectUrl.getHeaderField("Location");

				// get the cookie if need, for login
				String cookies = connectUrl.getHeaderField("Set-Cookie");

				// open the new connnection again
				connectUrl = (HttpURLConnection) new URL(newUrl).openConnection();
				
				// done first time redirect.
				redirect = false;
				
				// normally, 3xx is redirect
				status = connectUrl.getResponseCode();
				if (status != HttpURLConnection.HTTP_OK) {
					if (status == HttpURLConnection.HTTP_MOVED_TEMP
						|| status == HttpURLConnection.HTTP_MOVED_PERM
							|| status == HttpURLConnection.HTTP_SEE_OTHER)
					redirect = true;
				}
			}
			
			double totalFileSize = connectUrl.getContentLength(); 
			
		    connectUrl.connect();
		    File file = new File(path);
		    file.createNewFile();					// create a new file for each url
		    
		    OutputStream outputStream = null;
		    outputStream = new FileOutputStream(file);
		    System.out.println("Download file name: " + path);
		    InputStream inputStream = connectUrl.getInputStream();
		    int read = 0;
			byte[] bytes = new byte[len];
			double off = 0;
		    while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
				off += read;
				
				System.out.printf("\r%.2f%%", (off/totalFileSize) * 100);
			}
		    
		    System.out.println();
		    
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
