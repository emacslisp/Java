package com.dw.lib.test;

import java.io.*;
import java.net.*;

import com.dw.lib.HttpPostHelper;
import com.dw.lib.JsonOp;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PostTest {

	public static void main(String[] args) {
		
		//getTest();
		//postTest();
		HttpPostHelper helper = new HttpPostHelper();
		
		helper.Post("/Users/di.wu/test/tails.json", null);
	}
	
	public static void getTest() {
		HttpURLConnection connection = null;
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
			connection = (HttpURLConnection) url.openConnection();

			// set http connection attribute

			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET"); // GET、POST、DELETE、INPUT
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.connect();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			JsonOp jsonOp = new JsonOp();
			
			System.out.println(jsonOp.JsonFormater(sb.toString()));
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
	
	public static void postTest() {
		HttpURLConnection connection = null;
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			connection = (HttpURLConnection) url.openConnection();

			// set http connection attribute

			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST"); // GET、POST、DELETE、INPUT
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);

			// set http header message
			connection.setRequestProperty("Content-Type", "application/json"); // set require format to json
			// connection.setRequestProperty("Content-Type", "text/xml"); //设定 请求格式 xml，
			connection.setRequestProperty("Accept", "application/json");// set response format to json
//             connection.setRequestProperty("X-Auth-Token","xx");  //特定http服务器需要的信息，根据服务器所需要求添加
			connection.connect();

			JsonParser parser = null;
			JsonObject data = new JsonObject();
			data.addProperty("title", "foo");
			data.addProperty("body", "bar");
			data.addProperty("userId", 1);

			OutputStream out = connection.getOutputStream();
			out.write(data.toString().getBytes());
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
			System.out.println(jsonOp.JsonFormater(sb.toString()));
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
