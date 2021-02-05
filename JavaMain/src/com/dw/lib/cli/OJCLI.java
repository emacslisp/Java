package com.dw.lib.cli;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dw.lib.CryptoGenerator;
import com.dw.lib.FileUtils;
import com.dw.lib.JSONService;
import com.dw.lib.MysqlHelper;
import com.google.gson.JsonObject;

class User {
	int ID;
	String UserName;
	String Password;
	String Salt;
	Date CreatedDate;
	Date LastLoginDate;
	public User() {
		
	}
}

class Question {
	int ID;
	String Title;
	String HtmlFilePath;
	public Question() {
		
	}
}

public class OJCLI {

	public static User doAuth(MysqlHelper mysqlHelper, String userName, String password) throws Exception {
		ResultSet result = mysqlHelper.executeQuery("select * from User where username = '" + userName + "'");
		List<User> users = new ArrayList<User>();
		CryptoGenerator cg = new CryptoGenerator();
		
		while(result.next()) {
			User user = new User();
			user.ID = result.getInt(1);
			user.UserName = result.getString(2);
			user.Password = result.getString(3);
			user.Salt = result.getString(4);
			user.CreatedDate = result.getDate(5);
			user.LastLoginDate = result.getDate(6);
			users.add(user);
		}
		
		if(users.size() == 1) {
			String passwordEncryped = cg.generateValue(password + ":" + users.get(0).Salt);
			if(passwordEncryped.equals(users.get(0).Password)) return users.get(0);
		}
		
		return null;
	}
	
	public static void printOutQuestion(MysqlHelper mysqlHelper, User user) {
		
	}
	
	public static void printOutHelp() {
		System.out.println("v <question-id> - view question in html format");
		System.out.println("t <question-id> <local-file-path> - submit for test only");
		System.out.println("s <question-id> <local-file-path> - submit for oj full data set");
		System.out.println("l - list all questions");
		System.out.println("q - quit OJ System");
	}
	
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
				
				User user = doAuth(mysqlHelper, username, password);
				
				// auth successfully
				if(!user.UserName.equals(username)) {
					System.out.println("User is not authenticated!!!");
					return;
				}
				
				printOutQuestion(mysqlHelper, user);
				printOutHelp();
				String inputLine = "";
				boolean isContinue = true;
				Scanner scanner = new Scanner(System.in);
				while (isContinue) {
					inputLine = scanner.nextLine();

					String[] inputs = inputLine.split(" ");
					String command = inputs[0];

					switch (command) {
					case "v":
						if(inputs.length == 2) {
							// open html file with path here
						}
						break;
					case "t":
						if(inputs.length == 3) {
							// open html file with path here
							
							// testJudge(inputs[1], inputs[2]);
						}
					case "s":
						if(inputs.length == 3) {
							// open html file with path here
							
							// ojJudge(inputs[1], inputs[2]);
						}
						break;
					case "q":
						isContinue = false;
						break;
					case "l":
						printOutQuestion(mysqlHelper, user);
						break;
					default:
						break;
					}
				}
				
				scanner.close();
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
