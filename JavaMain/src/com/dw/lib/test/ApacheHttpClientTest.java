package com.dw.lib.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApacheHttpClientTest {

	public static void main(String[] args) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("https://jsonplaceholder.typicode.com/todos/1");
		
		HttpResponse response;
		try {
			response = client.execute(request);
		
			// Get the response
			BufferedReader br;
			
			br = new BufferedReader(new InputStreamReader(response
						.getEntity().getContent()));
			
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
	}

}
