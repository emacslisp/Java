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
		NetUtils.HttpDownload("http://localhost:3060/v1/api/users?populate={user: true}&select='customer'", "1.json");
	}
	
}
