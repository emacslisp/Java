package com.dw.lib.test;

import java.util.List;

import com.dw.lib.FileUtils;
import com.dw.lib.MysqlHelper;

public class Dict {
	public static void main(String[] args) {
		try {
			MysqlHelper mysql = new MysqlHelper("jdbc:mysql://localhost:3306/dict?useSSL=true", "root", "123456");
			FileUtils file = new FileUtils();
			List<String> words = file.fileToList("/Users/ewu/test/dict.txt");
			for(String word : words) {
				System.out.println(word);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
