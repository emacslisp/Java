package com.dw.lib.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class YouDaoCLI {
	public static void printByClass(Document doc, String className) {
		Elements e = doc.getElementsByClass(className);
		if(e == null) return;
		String output = e.toString();
		if(output.equals("")) return;
		
		System.out.println(jtidyTest.html2text(output));
	}
	
	public static void printById(Document doc, String id) {
		Element e = doc.getElementById(id);
		if(e == null) return;
		String output = e.toString();
		if(output.equals("")) return;
		
		System.out.println(jtidyTest.html2text(output));
	}
	
	public static void printUsage() {
		System.out.println("youdao [word list]");
		System.out.println("youdao -p [word list]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			if(args.length <= 0) {
				printUsage();
			}
			
			boolean pronaunce = false;
			
			if(args[0] == "-p") {
				pronaunce = true;
			}
			
			//String word = args[0];
			
			String[] className = {
					
					};
			
			String[] IdList = {
					"phrsListTab",
					"webTransToggle",
					"tPETrans-all-trans",
					"collinsResult",
					"synonyms",
					"relWordTab",
					"bilingual",
					"originalSound",
					"authority"
					};

			for (int i = 0; i < args.length; i++) {
				System.out.println(String.format("%s: ", args[i]));

				Document doc = Jsoup.connect(String.format("http://www.youdao.com/w/eng/%s", args[i])).get();
				for (String s : className)
					printByClass(doc, s);
				
				for (String s : IdList)
					printById(doc, s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
