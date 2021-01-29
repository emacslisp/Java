package com.dw.lib.cli;

import com.dw.lib.FileUtils;
import com.dw.lib.JSONService;
import com.dw.lib.MysqlHelper;
import com.google.gson.JsonObject;

public class OJCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length == 0) {
			System.out.println("oj <config-json>");
			System.out.println("{");
			System.out.println("   \"type\": \"mysql\",");
			System.out.println("   \"host\": \"localhost\",");
			System.out.println("   \"port\": 3306,");
			System.out.println("   \"dbUsername\": \"root\",");
			System.out.println("   \"dbPssword\": \"12345678\",");
			System.out.println("   \"dbName\": \"databaseName\"");
			System.out.println("   \"username\": \"user\",");
			System.out.println("   \"pssword\": \"12345678\",");
			System.out.println("}");
			System.out.println("type is 'mysql', 'postgresql', 'mongodb', 'oracle'");
			System.out.println("database that stored question, judge and submit history");
			return;
		}
		
		FileUtils fileUtils = new FileUtils();
		try {
			JSONService jsonService = new JSONService();
			JsonObject config;
			if (fileUtils.isExisted(args[0])) {
				config = jsonService.fileToJson(args[0]);
			}
			else {
				System.out.println("Database Config file is not existed or failed to parse");
				return;
			}
			
			String dbType = config.get("type").getAsString();
			String host = config.get("host").getAsString();
			String dbUsername = config.get("dbUsername").getAsString();
			String dbPassword = config.get("dbPssword").getAsString();
			String port = config.get("port").getAsString();
			String dbName = config.get("dbName").getAsString();
			String username = config.get("username").getAsString();
			String password = config.get("pssword").getAsString();
			
			if(dbType.equals("mysql")) {
				MysqlHelper mysqlHelper = new MysqlHelper("jdbc:mysql://"+host+":"+port+"/"+dbName + "?verifyServerCertificate=false&useSSL=true", dbUsername, dbPassword);
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
