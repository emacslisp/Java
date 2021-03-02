package com.dw.lib.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.dw.lib.BasicAuthentication;
import com.dw.lib.FileUtils;
import com.dw.lib.JavaXMLIndent;
import com.dw.lib.JsonOp;
import com.dw.lib.TimeSpan;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpPostCLI extends Thread {
	String config;
	String currentBody;
	String outputPath;
		
	public HttpPostCLI(String config, String currentBody, String outputPath) {
		this.config = config;
		this.currentBody = currentBody;
		this.outputPath = outputPath;
	}

	public void run() {
		this.Post(config, currentBody, outputPath);
	}


	String[][] speicalCharactorMapping = {
			{"{","%7B"},
			{"}","%7D"},
			{" ","%20"},
			{"<","%3C"},
			{">","%3E"},
			{"#","%23"},
			{"|","%7C"},
			{"\\","%5C"},
			{"^", "%5E"},
			{"~", "%7E"},
			{"[", "%5B"},
			{"]", "%5D"},
			{"`", "%60"}
		};
	
	public String replaceSpeicalCharactor(String url) {
		for(int index = 0;index < speicalCharactorMapping.length; index++) {
			url = url.replace(speicalCharactorMapping[index][0], speicalCharactorMapping[index][1]);
		}
		return url;
	}
	
	public void Post(String configPath, String body, String outputFilePath) {
		try {
			if(outputFilePath == null) {
				outputFilePath = "output.txt";
			}
			FileUtils utils = new FileUtils();
			String config = utils.fileToString(configPath);
						
			JsonParser parser = new JsonParser();
			JsonObject data = parser.parse(config).getAsJsonObject();
			TimeSpan timeSpan = new TimeSpan();
			HttpURLConnection connection = null;
			String urlStr = data.get("url").getAsString();
			String method = data.get("method").getAsString();
			
			JsonObject headers = data.get("headers").getAsJsonObject();

			URL url = new URL(replaceSpeicalCharactor(urlStr));
			connection = (HttpURLConnection) url.openConnection();

			// set http connection attribute
			
			connection.setRequestMethod(method.toUpperCase());
			connection.setDoOutput(true);
			
			connection.setConnectTimeout(600000);
			connection.setReadTimeout(600000);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			
			if(url.getUserInfo() != null) {
				String basicAuth = "Basic " + BasicAuthentication.base64Generator(url.getUserInfo());
				connection.setRequestProperty("Authorization", basicAuth);
			}
			
			if (!method.toUpperCase().equals("GET")) {
				connection.setDoInput(true);
				 // GET、POST、DELETE、INPUT
			
			}
			
			Set<Entry<String, JsonElement>> entrySet = headers.entrySet();
			
			for(Entry<String,JsonElement> entry : entrySet){
				connection.setRequestProperty(entry.getKey(), entry.getValue().getAsString()); // set require format to json
			}
			
			
			connection.connect();
			
			if (!method.toUpperCase().equals("GET")) {
				
				String bodyStr = body;
				String bodyType = data.get("bodyType").getAsString();
				String bodyOutput = "";
				if (bodyType.equals("json")) {
					JsonObject b = parser.parse(bodyStr).getAsJsonObject();
					bodyOutput = b.toString();
				} else {
					bodyOutput = bodyStr;
				}
				
				OutputStream out = connection.getOutputStream();
				out.write(bodyOutput.getBytes());
				out.flush();
				out.close();
			}
			
			InputStream inputStream;

            int status = connection.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK)
                inputStream = connection.getErrorStream();
            else
                inputStream = connection.getInputStream();
            
            if (inputStream == null) {
            	System.out.println("status: " + status);
            	return;
            }
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			
			long ms = timeSpan.span();
			
			StringBuffer statusBuffer = new StringBuffer("");
			statusBuffer.append("Status: " + status);
			statusBuffer.append(System.lineSeparator());
			statusBuffer.append("Time: " + ms + "ms");
			statusBuffer.append(System.lineSeparator());
			System.out.println(statusBuffer.toString());
			
			if(JsonOp.isJSONValid(sb.toString())) {
				JsonOp jsonOp = new JsonOp();
				String outStr = jsonOp.JsonFormater(sb.toString());
				System.out.println(outStr);
				statusBuffer.append(outStr);
				utils.stringToFile(statusBuffer.toString(), outputFilePath);
			} else if(JavaXMLIndent.isXML(sb.toString())) {
				JavaXMLIndent xmlIndent = new JavaXMLIndent();
				String outStr = xmlIndent.prettyFormatXMLString(sb.toString());
				System.out.println(outStr);
				statusBuffer.append(outStr);
				utils.stringToFile(statusBuffer.toString(), outputFilePath);
			}
			else {
				String outStr = sb.toString();
				System.out.println(outStr);
				statusBuffer.append(outStr);
				utils.stringToFile(statusBuffer.toString(), outputFilePath);
			}
			
			reader.close();
			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileUtils fileUtils = new FileUtils();
		String inputJson = "/Users/ewu/test/invoices.json";
		String config = fileUtils.fileToString(inputJson);
		String body = fileUtils.fileToString("/Users/ewu/test/body.xml");
		JsonParser parser = new JsonParser();
		JsonArray data = parser.parse(config).getAsJsonArray();
		
		Pattern p;
		p = Pattern.compile("P031827", Pattern.CASE_INSENSITIVE);
		
		
		for(int i=0;i<data.size();i++) {
			JsonObject t = (JsonObject) data.get(i);
			String transactionNumber = t.get("transactionNumber").getAsString();
			String currentBody = p.matcher(body).replaceAll(transactionNumber);
			HttpPostCLI post = new HttpPostCLI("/Users/ewu/test/1.config", currentBody, "/Users/ewu/test/1.output");
			Thread thread1 = new Thread(post);
			thread1.start();
		}
	}

}
