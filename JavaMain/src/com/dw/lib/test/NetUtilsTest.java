package com.dw.lib.test;

import com.dw.lib.NetUtils;

public class NetUtilsTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NetUtils.ping("www.google.com");
		HttpDownloadToFileTest();
	}
	
	public static void ping() {
		NetUtils.ping("www.google.com");
	}
	
	public static void HttpDownloadToFileTest() {
		NetUtils.HttpDownload("http://www.google.com.au", "/Users/di.wu/test/1.html");
	}
	
}
