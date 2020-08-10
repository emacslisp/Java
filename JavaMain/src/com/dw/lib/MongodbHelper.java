package com.dw.lib;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.conversions.Bson;

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
		String host = "127.0.0.1";
		int port = 27017;
		MongoClient conn = new MongoClient(host, port);
		MongoDatabase db = conn.getDatabase("vocus-one");
		MongoCollection<Document> coll = db.getCollection("billingaccounts");
		// BasicDBObject obj = new BasicDBObject();
		// obj.put("billingSystemId", 54146);
		// String query = "db.getCollection('billingaccounts').find({'billingSystemId': '54146'})";
		Bson input = Document.parse("{'billingSystemId': '54146'}");
		
		MongoCursor<Document> result = coll.find(input).iterator();
		JsonOp jsonop = new JsonOp();
		while(result.hasNext()) {
			Document doc = result.next();
			System.out.println(jsonop.JsonFormater(doc.toJson()));
		}
		conn.close();
	}

}
