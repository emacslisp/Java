package com.dw.lib;

import java.io.IOException;
import com.google.gson.*;

public class JsonOp {

	public String JsonFormater(String inputFile, String outputFile) throws IOException {
		FileUtils f = new FileUtils();
		String inputJson = f.fileToString(inputFile);
		return inputJson;
	}
	
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
	
	public static boolean isJSONValid(String jsonString) {
	    try {
	    	JsonParser parser = new JsonParser();
	    	parser.parse(jsonString);
	    } catch (JsonSyntaxException ex) {
	       return false;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonOp jsonOp = new JsonOp();
		//String formattedJson1="";
		try {
			jsonOp.FormatJson("/Users/di.wu/test/1.json", "/Users/di.wu/test/2.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(formattedJson1);
	}
}
