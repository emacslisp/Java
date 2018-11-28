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
		HttpGet request = new HttpGet("http://localhost:3060/v1/api/users?select='customer'&populate=%7Buser:true%7D");
		
		request.setHeader("Content-Type", "application/json");
		request.setHeader("Authorization", "api-key 8988339e-616b-412e-98c2-b93eb004d4e0");
		
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
