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
			System.out.println("post <config file> <body file> <output file>");
			System.out.println("post <config file> <body file> #output default to output.txt ");
			System.out.println("example config:");
			System.out.println("{");
			System.out.println("    \"url\":\"https://jsonplaceholder.typicode.com/posts\",");
			System.out.println("    \"method\": \"post\",");
			System.out.println("    \"bodyType\": \"json\",");
			System.out.println("    \"headers\": {");
			System.out.println("        \"Content-type\": \"application/json; charset=UTF-8\",");
			System.out.println("        \"Authorization\": \"Basic xxxxxxxxx\"");
			System.out.println("    }");
			System.out.println("}");

			return;
		}
		
		String outputFilePath = "output.txt";
		if(args.length >= 2) {
			outputFilePath = args[1]; 
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
