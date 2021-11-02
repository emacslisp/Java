package com.dw.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Map.Entry;
import java.util.Set;

import com.dw.lib.FileUtils;
import com.dw.lib.JsonOp;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class HttpPostHelper {
	
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
	
	public String ConvertToWget(String configPath, String bodyFilePath) {
		StringBuilder sb = new StringBuilder();
		try {
			FileUtils utils = new FileUtils();
			String config = utils.fileToString(configPath);

			JsonParser parser = new JsonParser();
			JsonObject data = parser.parse(config).getAsJsonObject();
			String urlStr = data.get("url").getAsString();
			String method = data.get("method").getAsString();

			JsonObject headers = data.get("headers").getAsJsonObject();

			sb.append("wget --no-check-certificate --method POST \\\n");
			

			if (headers != null)
				for (Entry<String, JsonElement> entry : headers.entrySet()) {
					// System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue()
					// );
					sb.append("--header '" + entry.getKey() + ":" + entry.getValue().getAsString() + "' \\\n");
				}

			if (bodyFilePath != null && utils.isExisted(bodyFilePath)) {
				String bodyStr = utils.fileToString(bodyFilePath);
				sb.append("--body-data '" + bodyStr + "' \\\n");
			}
			
			sb.append("-O output " + urlStr);

			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
	
	public String ConvertToCURL(String configPath, String bodyFilePath) {
		StringBuilder sb = new StringBuilder();
		try {
			FileUtils utils = new FileUtils();
			String config = utils.fileToString(configPath);

			JsonParser parser = new JsonParser();
			JsonObject data = parser.parse(config).getAsJsonObject();
			String urlStr = data.get("url").getAsString();
			String method = data.get("method").getAsString();

			JsonObject headers = data.get("headers").getAsJsonObject();

			sb.append("curl --request " + method.toUpperCase() + " " + urlStr + " \\\n");

			if (headers != null)
				for (Entry<String, JsonElement> entry : headers.entrySet()) {
					// System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue()
					// );
					sb.append("--header '" + entry.getKey() + ":" + entry.getValue().getAsString() + "' \\\n");
				}

			if (bodyFilePath != null && utils.isExisted(bodyFilePath)) {
				String bodyStr = utils.fileToString(bodyFilePath);
				sb.append("-d '" + bodyStr + "'");
			}

			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
	
	public void Post(String configPath, String bodyFilePath, String outputFilePath) {
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
				if (bodyFilePath == null) throw new Exception("Body is missed");
				String bodyStr = utils.fileToString(bodyFilePath);
				String bodyType = data.get("bodyType").getAsString();
				String bodyOutput = "";
				if (bodyType.equals("json")) {
					JsonObject body = parser.parse(bodyStr).getAsJsonObject();
					bodyOutput = body.toString();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
