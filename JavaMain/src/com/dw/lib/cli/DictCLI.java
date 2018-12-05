package com.dw.lib.cli;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DictCLI {
	
	public static String html2text(String html) {
	    return Jsoup.parse(html).text();
	}
	
	public static void printElementText(Element e) {
		if(e == null) return;
		String output = e.toString();
		if(output.equals("")) return;
		
		System.out.println(html2text(output));
	}
	
	public static void printElements(Elements elements) {
		for(Element e : elements) {
			printElementText(e);
		}
	}
	
	public static void printByClass(Document doc, String className) {
		Elements e = doc.getElementsByClass(className);
		printElements(e);
	}
	
	public static void printByTag(Document doc, String tagName) {
		Elements e = doc.getElementsByTag(tagName);
		printElements(e);
	}
	
	public static void printUsage() {
		System.out.println("jdict [word list]");
		System.out.println("jdict -e [word list]");
	}
	
	public static void main(String[] args) {
		try {
			
			if(args.length <= 0) {
				printUsage();
				return;
			}
			
			boolean e2e = false;
			int index = 0;
			if(args[0].equals("-e")) {
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
					
					// TODO: try to find a good way to parse oxford dictionaries 
					/*Document docOxford = Jsoup.connect(String.format("https://en.oxforddictionaries.com/definition/%s", args[i])).get();
					Elements ElementsUl = docOxford.getElementsByClass("semb");
					for (Element elementLi : ElementsUl) {
						Elements provinceEl = elementLi.getElementsByTag("li");
						printElements(provinceEl);
					}*/
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
