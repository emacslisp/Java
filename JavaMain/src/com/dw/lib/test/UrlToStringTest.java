package com.dw.lib.test;

import com.dw.lib.UrlToString;

public class UrlToStringTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String search = "stub";
		String result = UrlToString.getUrlAsHtmlString("http://www.dict.org/bin/Dict?Form=Dict1&Query=" + search + "&Strategy=*&Database=*");
		
		System.out.println(result);
	}
	
}
