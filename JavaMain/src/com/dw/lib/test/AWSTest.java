package com.dw.lib.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.*;;

public class AWSTest {
	  public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
	        URL obj;
	        String url = "https://qg1k8gez3c.execute-api.us-east-1.amazonaws.com/oauth2/v1/token";
	        String headerSection = "Authorization";
	        String headerValue = "Bearer 1bdc3c07cd1b08c2883437b5a0436951";
	        try {
	            
	            obj = new URL(url);
	            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	            
	            con.setSSLSocketFactory(new TSLSocketConnectionFactory());
	          	            
	            con.setConnectTimeout(5000);
	            con.setRequestProperty(headerSection, headerValue);
	            con.setRequestMethod("GET");
	            
	            StringBuilder sb = new StringBuilder();  
	            int HttpResult = con.getResponseCode(); 
	            if (HttpResult == HttpsURLConnection.HTTP_OK) {
	                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
	                String line = null;  
	                while ((line = br.readLine()) != null) {  
	                    sb.append(line + "\n");  
	                }
	                br.close();
	                System.out.println(sb.toString());
	            } else {
	                 System.out.println(con.getResponseMessage());  
	            }  
	        } catch (MalformedURLException  e) {
	            e.printStackTrace();
	        }
	        catch(IOException e) {
	            e.printStackTrace();
	        }
	    }
}
