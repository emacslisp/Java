package com.dw.lib;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONService {
	
	public JsonObject fileToJson(String filePath) {
		FileUtils fileUtils = new FileUtils();
		String config;
		try {
			config = fileUtils.fileToString(filePath);
			JsonParser parser = new JsonParser();
			JsonObject data = parser.parse(config).getAsJsonObject();
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
