package com.dw.lib.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
public class jsoupTest {
	
	public static void printByClass(Document doc, String className) {
		Elements e = doc.getElementsByClass(className);
		if(e == null) return;
		String output = e.toString();
		if(output.equals("")) return;
		
		System.out.println(jtidyTest.html2text(output));
	}
	
	public static void printByTag(Document doc, String tagName) {
		Elements e = doc.getElementsByTag(tagName);
		if(e == null) return;
		String output = e.toString();
		if(output.equals("")) return;
		
		for(Element x: e) {
			System.out.println(jtidyTest.html2text(x.toString()));
		}
	}
	
	public static void printUsage() {
		System.out.println("jdict [word list]");
		System.out.println("jdict -e [word list]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			if(args.length <= 0) {
				printUsage();
			}
			
			boolean e2e = false;
			int index = 0;
			if(args[0] == "-e") {
				e2e = true;
				index = 1;
			}
			
			//String word = args[0];
			
			String[] className = {
					"phonetic",
					"dict-basic-ul", 
					"layout detail", 
					"layout dual",
					"layout en", 
					"layout sort",
					"layout anno",
					"layout auth",
					"layout nfo",
					"layout nwd"
					};

			
			for (int i = index; i < args.length; i++) {
				System.out.println(String.format("%s: ", args[i]));

				Document doc = Jsoup.connect(String.format("http://dict.cn/%s", args[i])).get();
				for (String s : className)
					printByClass(doc, s);
				if(e2e) {
					Document docE2E = Jsoup.connect(String.format("http://www.dict.org/bin/Dict?Form=Dict2&Database=*&Query=%s", args[i])).get();
					printByTag(docE2E,"pre");
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
