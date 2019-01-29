package com.dw.getdict;

import java.net.URL;

/*
 * 
 */
public class Downloader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// GetRequest
		// "Accept-Ranges"
		// "Content-Disposition"
		String targetURL = "http://download.microsoft.com/download/9/5/A/95A9616B-7A37-4AF6-BC36-D6EA96C8DAAE/dotNetFx40_Full_x86_x64.exe";

		try {
			URL url = new URL(targetURL);
		} catch (Exception ex) {

		}
	}

}
