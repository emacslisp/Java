package com.dw.lib.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Set;

import com.dw.lib.FileUtils;
import com.dw.lib.HttpPostHelper;
import com.dw.lib.JsonOp;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PostCLI {

	public static void main(String[] args) {
		if(args.length == 0) {
			String[] helpInfo = {"post <config file> <body file> <output file>",
					"post <config file> <body file> #output default to output.txt ",
					"example config:",
					"{",
					"    \"url\":\"https://jsonplaceholder.typicode.com/posts\",",
					"    \"method\": \"post\",",
					"    \"bodyType\": \"json\",",
					"    \"headers\": {",
					"        \"Content-type\": \"application/json; charset=UTF-8\",",
					"        \"Authorization\": \"Basic xxxxxxxxx\"",
					"    }",
					"}",
					"<body file> is json file or xml file"};
			
			for(String s : helpInfo) {
				System.out.println(s);
			}

			return;
		}
		
		String outputFilePath = "output.txt";
		if(args.length >= 3) {
			outputFilePath = args[2]; 
		}
		
		try {
			HttpPostHelper helper = new HttpPostHelper();
			if (args.length == 1) {
				helper.Post(args[0], null, outputFilePath);
			}
			else if(args.length == 2) {
				helper.Post(args[0], args[1], outputFilePath);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
