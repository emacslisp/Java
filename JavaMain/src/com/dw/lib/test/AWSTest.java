package com.dw.lib.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.*;

public class AWSTest {
	  public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
	        URL obj;
	        String url = "https://qg1k8gez3c.execute-api.us-east-1.amazonaws.com/oauth2/v1/token";
	        String headerSection = "Authorization";
	        String headerValue = "Bearer 1bdc3c07cd1b08c2883437b5a0436951";
	        try {
	            
	            obj = new URL(url);
	            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	            
	           /* TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager()
	            {

	                public java.security.cert.X509Certificate[] getAcceptedIssuers()
	                {
	                    return null;
	                }

	                public void checkClientTrusted(
	                    java.security.cert.X509Certificate[] certs, String authType)
	                {
	                }

	                public void checkServerTrusted(
	                    java.security.cert.X509Certificate[] certs, String authType)
	                {
	                }
	            } };

	            // Get a new SSL context
	            SSLContext sc = SSLContext.getInstance("TSLv1.2");
	            sc.init(null, trustAllCerts, new java.security.SecureRandom());
	            // Set our connection to use this SSL context, with the "Trust all" manager in place.
	            con.setSSLSocketFactory(sc.getSocketFactory());
	            // Also force it to trust all hosts
	            HostnameVerifier allHostsValid = new HostnameVerifier() {
	                public boolean verify(String hostname, SSLSession session) {
	                    return true;
	                }
	            };
	            // and set the hostname verifier.
	            con.setHostnameVerifier(allHostsValid);
	            */
	            
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
