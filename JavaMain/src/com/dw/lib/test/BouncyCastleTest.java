package com.dw.lib.test;

import java.io.InputStreamReader;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.net.ssl.HttpsURLConnection;

import java.net.*;

import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.DefaultTlsClient;
import org.bouncycastle.crypto.tls.TlsAuthentication;
import org.bouncycastle.crypto.tls.TlsClientProtocol;
import org.bouncycastle.crypto.tls.TlsCredentials;

public class BouncyCastleTest {

	public static void main(String[] args) throws IOException {
		URL myurl = new URL("");;
				   HttpsURLConnection  con = (HttpsURLConnection )myurl.openConnection();
				   con.setSSLSocketFactory(new TSLSocketConnectionFactory()); 
	}

}
