package com.dw.lib;

import java.util.Properties;
import java.io.*;

public class PropertiesHelper {

	private Properties _prop;

	public PropertiesHelper() {
		_prop = new Properties();;
	}

	public void readProperties(String fileName) {
		try {
			InputStream in = PropertiesHelper.class.getResourceAsStream("/" + fileName);
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			_prop.load(bf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get value by key
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return _prop.getProperty(key);
	}
	
	public static void main(String[] args) {
		PropertiesHelper helper = new PropertiesHelper();
		helper.readProperties("hibernate.properties");
		System.out.println(helper.getProperty("hibernate.connection.url"));
	}
}
