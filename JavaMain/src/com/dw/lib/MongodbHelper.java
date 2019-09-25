package com.dw.lib;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongodbHelper {
	
	MongoClient conn;

	public MongodbHelper() throws Exception {
		conn = null;
	}

	public MongodbHelper(String host, int port, String username, String password) throws Exception {
		conn = getConnection(host, port, username, password);
	}

	public MongoClient getConnection(String host, int port, String username, String password) throws Exception {
		conn = new MongoClient(host, port);
	
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
