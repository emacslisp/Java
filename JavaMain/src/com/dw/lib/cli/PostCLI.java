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
import com.dw.lib.JsonOp;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PostCLI {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("post <config file> <output file>");
			System.out.println("post <config file> #output default to output.txt ");
			return;
		}
		
		String outputFile = "output.txt";
		if(args.length >= 2) {
			outputFile = args[1]; 
		}
		
		try {
			FileUtils utils = new FileUtils();
			String config = utils.fileToString(args[0]);
		
			JsonParser parser = new JsonParser();
			JsonObject data = parser.parse(config).getAsJsonObject();
			
			HttpURLConnection connection = null;
			String urlStr = data.get("url").getAsString();
			String method = data.get("method").getAsString();
			JsonObject headers = data.get("headers").getAsJsonObject();
			JsonObject body = data.get("body").getAsJsonObject();
			
			URL url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();

			// set http connection attribute

			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(method.toUpperCase()); // GET、POST、DELETE、INPUT
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			
			Set<Entry<String, JsonElement>> entrySet = headers.entrySet();
			
			for(Entry<String,JsonElement> entry : entrySet){
				connection.setRequestProperty(entry.getKey(), entry.getValue().getAsString()); // set require format to json
			}
			connection.connect();
			
			OutputStream out = connection.getOutputStream();
			out.write(body.toString().getBytes());
			out.flush();
			out.close();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			
			JsonOp jsonOp = new JsonOp();
			String outStr = jsonOp.JsonFormater(sb.toString());
			System.out.println(outStr);
			utils.stringToFile(outStr, outputFile);
			
			reader.close();
			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
