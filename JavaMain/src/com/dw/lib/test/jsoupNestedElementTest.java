package com.dw.lib.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class jsoupNestedElementTest {
	
	public static String html2text(String html) {
	    return Jsoup.parse(html).text();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc;
		try {
			Document docOxford = Jsoup.connect(String.format("https://en.oxforddictionaries.com/definition/%s", "dictionary")).get();
			Elements ElementsUl = docOxford.getElementsByClass("semb");
			for (Element elementLi : ElementsUl) {
				Elements provinceEl = elementLi.getElementsByTag("li");
				for (Element e : provinceEl) {
					if(e == null) continue;
					String output = e.toString();
					System.out.println(html2text(output));
					//System.out.println(output);
				}
			}
			
		} catch (Exception e) {
			
		}
	}

}
