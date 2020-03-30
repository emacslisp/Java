package com.dw.lib.cli;


import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dw.lib.FileUtils;
import com.dw.lib.MysqlHelper;
import com.dw.lib.RegexService;
import com.dw.lib.StringService;


/*
 * drop table dictionary;
CREATE TABLE IF NOT EXISTS dictionary (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  word VARCHAR(80),
  dict_cn TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci ,
  dict_org TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci ,
  CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
  INDEX(word)
) engine=InnoDB;
 */

public class GetDictCLI {
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
			if (!output.equals("")) {
				ss.appendLine(StringService.StringToUTF8(output));
			}
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
				if(!output.trim().equals("")) {
					ss.append(output);
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

			Elements e = doc.getElementsByTag("pre");
			return elementsToString(e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "";
	}
	
	public static String filterString(String s) {
		return s.replace("\\", "").replace("'","\\'");
	}

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(GetDictCLI.class);
		DOMConfigurator.configure(GetDictCLI.class.getResource("log4j_toFile.xml"));
		long sleepTime = 15 * 1000;
		try {
			String username = System.getenv("Dict_UserName");
			String password = System.getenv("Dict_Password");
			String dictPath = System.getenv("Dict_PATH");
			
			if(username == null || password == null) {
				System.out.println("Please set env value Dict_UserName and Dict_Password");
				return;
			}
			
			MysqlHelper mysql = new MysqlHelper("jdbc:mysql://localhost:3306/dict?useSSL=true&useUnicode=yes&characterEncoding=UTF-8", username, password);
			logger.debug("connect to localhost dict successfully");
			FileUtils file = new FileUtils();
			List<String> words = file.fileToList(dictPath);
			logger.debug("load word list successfully");
			RegexService regex = new RegexService();
			GetDictCLI dict = new GetDictCLI();
			for (String word : words) {
				if (regex.isAllLetterAndNumber(word)) {
					try {
						logger.debug(word);

						String checkSql = "select * from dictionary where word='" + word + "'";

						ResultSet result = mysql.executeQuery(checkSql);

						int count = 0;
						while (result.next()) {
						    ++count;
						}
						
						if(count >= 1) {
							continue;
						}

						String dictCN = dict.getDictCN(word);
						String dictOrg = dict.getDictOrg(word);
						dictCN = filterString(dictCN);
						dictOrg = filterString(dictOrg);

						String sqlStatement = "insert into dictionary(word, dict_cn, dict_org) values ( '" + word
								+ "','" + dictCN + "','" + dictOrg + "')";
						logger.debug(sqlStatement);

						mysql.executeUpdate(sqlStatement);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.error(e.toString());
					}

					Thread.sleep(sleepTime);
				}
			}
			
			mysql.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.toString());
		}
	}
}


