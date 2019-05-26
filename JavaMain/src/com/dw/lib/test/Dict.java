package com.dw.lib.test;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dw.lib.FileUtils;
import com.dw.lib.MysqlHelper;
import com.dw.lib.RegexService;
import com.dw.lib.StringService;

public class Dict {
	String[] className = { "phonetic", "dict-basic-ul", "layout detail", "layout dual", "layout en",
			"layout sort", "layout anno", "layout auth", "layout nfo", "layout nwd" };
	
	public String elementsToString(Elements elements) {
		StringService ss = new StringService();
		for (Element e : elements) {
			if (e == null)
				continue;
			String output = e.toString();
			if (output.equals(""))
				continue;
			
			output = Jsoup.parse(output).text();
			if (!output.equals(""))
				ss.appendLine(output);
		}
		return ss.toString();
	}
	
	public String getDictCN(String word) {
		Document doc;
		try {
			doc = Jsoup.connect(String.format("http://dict.cn/%s", word)).get();

			StringService ss = new StringService();

			for (String s : className) {
				Elements elements = doc.getElementsByClass(s);
				String output = elementsToString(elements);
				if(!output.equals("")) {
					ss.appendLine(output);
				}
			}
			
			return ss.toString();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
		return "";
	}
	
	public String getDictOrg(String word) {
		Document doc;
		try {
			doc = Jsoup.connect(String.format("http://www.dict.org/bin/Dict?Form=Dict2&Database=*&Query=%s", word))
					.get();

			Elements e = doc.getElementsByTag("prev");
			return elementsToString(e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {

		try {
			MysqlHelper mysql = new MysqlHelper("jdbc:mysql://localhost:3306/dict?useSSL=true", "root", "123456");
			FileUtils file = new FileUtils();
			List<String> words = file.fileToList("/Users/ewu/test/dict.txt");
			RegexService regex = new RegexService();
			Dict dict = new Dict();
			for (String word : words) {
				if (regex.isAllLetterAndNumber(word)) {
					System.out.println(word);
					String dictCN = dict.getDictCN(word);
					String dictOrg = dict.getDictOrg(word);
					mysql.executeQuery("insert into dict(word, dict_cn, dict_org) values ( '" + word + "','" + dictCN + "','" + dictOrg + "')");
				}
			}
			/*
			 * String test = "9th"; RegexService regex = new RegexService();
			 * System.out.println(regex.isAllLetterAndNumber(test));
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
