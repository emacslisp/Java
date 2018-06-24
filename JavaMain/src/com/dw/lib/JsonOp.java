package com.dw.lib;

import java.io.IOException;

import com.google.gson.*;

public class JsonOp {

	
	public String JsonFormater(String uglyJsonString) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJsonString);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}
	
	public void FormatJson(String inputfile, String outputFile) throws IOException {
		FileUtils fileUtils = new FileUtils();
		fileUtils.stringToFile(JsonFormater(fileUtils.fileToString(inputfile)),outputFile);
	}
}
