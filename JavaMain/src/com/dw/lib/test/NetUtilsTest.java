package com.dw.lib.test;

import com.dw.lib.NetUtils;

public class NetUtilsTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NetUtils.ping("www.google.com");
		HttpDownloadToFileTest();
	}
	
	public static void ping() {
		NetUtils.ping("www.google.com", 1);
	}
	
	public static void HttpDownloadToFileTest() {
		NetUtils.HttpDownload("http://download.microsoft.com/download/9/5/A/95A9616B-7A37-4AF6-BC36-D6EA96C8DAAE/dotNetFx40_Full_x86_x64.exe", "/Users/ewu/test/1.exe");
	}
	
}
