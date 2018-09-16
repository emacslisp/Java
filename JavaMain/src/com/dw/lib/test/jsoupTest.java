package com.dw.lib.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
public class jsoupTest {
	
	public static void printByClass(Document doc, String className) {
		Elements e = doc.getElementsByClass(className);
		String output = e.toString();
		if(output.equals("")) return;
		
		System.out.println(jtidyTest.html2text(output));
	}
	
	public static void printUsage() {
		System.out.println("jdict [word list]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			if(args.length <= 0) {
				printUsage();
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

			for (int i = 0; i < args.length; i++) {
				System.out.println(String.format("%s: ", args[i]));

				Document doc = Jsoup.connect(String.format("http://dict.cn/%s", args[i])).get();
				for (String s : className)
					printByClass(doc, s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
