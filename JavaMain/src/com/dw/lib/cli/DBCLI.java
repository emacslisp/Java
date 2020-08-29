package com.dw.lib.cli;

import java.nio.file.Files;
import java.util.List;

import com.dw.lib.FileUtils;
import com.dw.lib.JSONService;
import com.dw.lib.MysqlHelper;
import com.google.gson.JsonObject;

public class DBCLI {
	
	public static void mysqlHandler(String host, 
			String dbName, String username,
			String password,String port, String[] args) throws Exception {
		
		if (port == null) {
			port = "3306";
		}

		//?verifyServerCertificate=false&useSSL=true to disable warning message
		MysqlHelper mysqlHelper = new MysqlHelper("jdbc:mysql://"+host+":"+port+"/"+dbName + "?verifyServerCertificate=false&useSSL=true", username, password);
		
		if(args.length == 1) {
			// show all tables
			System.out.println("Show All Tables");
			List<String> tableNames = mysqlHelper.getAllTables();
			for(String s: tableNames) {
				System.out.println(s);
			}
			return;
		}
		
		String sql = args[1];
		String[] sqls = sql.split(";");
		for(String s : sqls)
			mysqlHelper.printTable(s);
	}
	
	public static void postgresqlHandler(String host, 
			String dbName, String username,
			String password,String port, String[] args) throws Exception {
		
	}
	
	public static void mongodbHandler(String host, 
			String dbName, String username,
			String password,String port, String[] args) throws Exception {
		
	}
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("db <config-json> <sql-file>");
			System.out.println("{");
			System.out.println("   \"type\": \"mysql\",");
			System.out.println("   \"host\": \"localhost\",");
			System.out.println("   \"port\": 3306,");
			System.out.println("   \"username\": \"root\",");
			System.out.println("   \"password\": \"12345678\",");
			System.out.println("   \"dbName\": \"databaseName\"");
			System.out.println("}");
			System.out.println("type is 'mysql', 'postgresql', 'mongodb', 'oracle'");
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
			
			String dbType = config.get("type").getAsString();
			String host = config.get("host").getAsString();
			String username = config.get("username").getAsString();
			String password = config.get("password").getAsString();
			String port = config.get("port").getAsString();
			String dbName = config.get("dbName").getAsString();
			
			if(dbType.equals("mysql")) {
				mysqlHandler(host, dbName, username, password, port, args);
			} else if (dbType.equals("mongodb")) {
				mongodbHandler(host, dbName, username, password, port, args);
			}
			else if (dbType.equals("postgresql")) {
				postgresqlHandler(host, dbName, username, password, port, args);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
