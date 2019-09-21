package com.dw.lib.cli;

import java.nio.file.Files;

import com.dw.lib.FileUtils;
import com.dw.lib.JSONService;
import com.dw.lib.MysqlHelper;
import com.google.gson.JsonObject;

public class DBCLI {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("db <config-json> <sql-file>");
			System.out.println("{");
			System.out.println("   \"type\": \"mysql\",");
			System.out.println("   \"host\": \"localhost\",");
			System.out.println("   \"port\": 1234,");
			System.out.println("   \"username\": \"root\",");
			System.out.println("   \"password\": \"12345678\",");
			System.out.println("   \"dbName\": \"databaseName\"");
			System.out.println("}");
			System.out.println("sql file is statement split with ';'");
			System.out.println("for example:");
			System.out.println("select * from db;");
			System.out.println("update tableName set value = 1 where id = 1;");
			return;
		}
		
		/*
		 * 1. use this cli for mysql/mongodb/sql server/oracle
		 * 2. stage 1 only contains select/update/delete single statement for sql file
		 * 3. later on try to find out stored procesure and so on
		 */
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
			String host = config.get("host").getAsString();
			String username = config.get("username").getAsString();
			String password = config.get("password").getAsString();
			String port = config.get("port").getAsString();
			String dbName = config.get("dbName").getAsString();
			//jdbc:mysql://localhost:3306/testdb?useSSL=true
			MysqlHelper mysqlHelper = new MysqlHelper("jdbc:mysql://"+host+":"+port+"/"+dbName+"?userSSL=true", username, password);
			String sql = args[1];
			mysqlHelper.printTable(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
