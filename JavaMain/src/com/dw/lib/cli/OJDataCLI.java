package com.dw.lib.cli;

import java.io.IOException;

import com.dw.lib.FileUtils;
import com.dw.lib.JSONService;
import com.dw.lib.MysqlHelper;
import com.dw.lib.OJHelper;
import com.google.gson.JsonObject;

public class OJDataCLI {
	public static void help() {
		String[] helpInfo = { "OJData <db.config> <question-id> <input.in> <output.out> <code file>" };

		for (String s : helpInfo) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if(args.length != 5) {
			help();
			return;
		}
		
		FileUtils fileUtils = new FileUtils();
		OJHelper helper = new OJHelper();
		JSONService jsonService = new JSONService();
		
		JsonObject config = null;
		if (fileUtils.isExisted(args[0])) {
			config = jsonService.fileToJson(args[0]);
		}
		
		String dbType = config.get("type").getAsString();
		String host = config.get("host").getAsString();
		String dbUsername = config.get("dbUsername").getAsString();
		String dbPassword = config.get("dbPssword").getAsString();
		String port = config.get("port").getAsString();
		String dbName = config.get("dbName").getAsString();
		
		int questionId = Integer.parseInt(args[1]);
		String inputPath = args[2];
		String outputPath = args[3];
		String programPath = args[4];
		
		if(dbType.equals("mysql")) {
			try {
				MysqlHelper mysqlHelper = new MysqlHelper("jdbc:mysql://"+host+":"+port+"/"+dbName + "?verifyServerCertificate=false&useSSL=true", dbUsername, dbPassword);
				
				int result = helper.insertJudgeData(mysqlHelper, questionId, inputPath, outputPath, programPath);
				System.out.println("Insert Successfully with result: " + result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
