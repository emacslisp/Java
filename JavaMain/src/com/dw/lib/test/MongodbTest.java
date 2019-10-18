package com.dw.lib.test;

import java.util.List;
import com.mongodb.MongoClient;

public class MongodbTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongo = new MongoClient("localhost", 27017);
		List<String> dbs = mongo.getDatabaseNames();
		System.out.println(dbs);
		mongo.close();
	}

}
