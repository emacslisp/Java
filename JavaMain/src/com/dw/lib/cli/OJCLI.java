package com.dw.lib.cli;

import java.util.Scanner;
import com.dw.lib.FileUtils;
import com.dw.lib.JSONService;
import com.dw.lib.MysqlHelper;
import com.dw.lib.OJHelper;
import com.dw.lib.OJHelper.JudgeResult;
import com.dw.lib.OJHelper.User;
import com.google.gson.JsonObject;

public class OJCLI {

	
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
		OJHelper ojHelper = new OJHelper();
		
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
			String basePath = config.get("basePath").getAsString();
			
			
			if(dbType.equals("mysql")) {
				MysqlHelper mysqlHelper = new MysqlHelper("jdbc:mysql://"+host+":"+port+"/"+dbName + "?verifyServerCertificate=false&useSSL=true", dbUsername, dbPassword);
				
				User user = ojHelper.doAuth(mysqlHelper, username, password);
				
				// auth successfully
				if(!user.UserName.equals(username)) {
					System.out.println("User is not authenticated!!!");
					return;
				}
				
				ojHelper.printOutQuestion(mysqlHelper, user);
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
							int id = Integer.parseInt(inputs[1]);
							
							ojHelper.openHtmlFile(mysqlHelper, basePath, id);
						}
						break;
						
					case "l":
						ojHelper.printOutQuestion(mysqlHelper, user);
						break;
						
					case "s":
						if(inputs.length == 3) {
							// test full set of data
							int id = Integer.parseInt(inputs[1]);
							String filePath = inputs[2];
							JudgeResult result = ojHelper.ojJudge(mysqlHelper, id, filePath, user.ID);
							ojHelper.insertResult(mysqlHelper, id, user.ID, result, filePath);
						}
						break;
						
					case "q":
						isContinue = false;
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
