package com.dw.lib;

import java.io.File;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dw.lib.CommandLineUtil.Report;

public class OJHelper {

	public class User {
		public int ID;
		public String UserName;
		public String Password;
		public String Salt;
		public Date CreatedDate;
		public Date LastLoginDate;

		public User() {

		}
	}

	public class Question {
		public int ID;
		public String Title;
		public String HtmlFilePath;

		public Question() {

		}
	}
	
	public class OJData {
		public int ID;
		public int QuestionId;
		public String JudgeDataInput;
		public String JudgeDataOutput;
		
		public OJData() {
			
		}
	}
	
	public class JudgeResult {
		public Status status;
		public String log;
		
		public JudgeResult() {
			status = Status.EMPTY;
			log = "";
		}
	}
	
	public enum Status {
		AC,
		WA,
		TLE,
		RE,
		CE,
		EMPTY
	}

	List<Question> questions = new ArrayList<Question>();
	List<User> users = new ArrayList<User>();
	FileUtils fileUtils = new FileUtils();
	CommandLineUtil cli = new CommandLineUtil();

	public User doAuth(MysqlHelper mysqlHelper, String userName, String password) throws Exception {
		ResultSet result = mysqlHelper.executeQuery("select * from User where username = '" + userName + "'");

		CryptoGenerator cg = new CryptoGenerator();

		while (result.next()) {
			User user = new User();
			user.ID = result.getInt(1);
			user.UserName = result.getString(2);
			user.Password = result.getString(3);
			user.Salt = result.getString(4);
			user.CreatedDate = result.getDate(5);
			user.LastLoginDate = result.getDate(6);
			users.add(user);
		}

		if (users.size() == 1) {
			String passwordEncryped = cg.generateValue(password + ":" + users.get(0).Salt);
			if (passwordEncryped.equals(users.get(0).Password))
				return users.get(0);
		}

		return null;
	}

	public void printOutQuestion(MysqlHelper mysqlHelper, User user) throws Exception {
		ResultSet result = mysqlHelper.executeQuery("select * from Questions");

		while (result.next()) {
			Question question = new Question();
			question.ID = result.getInt(1);
			question.Title = result.getString(2);
			question.HtmlFilePath = result.getString(3);
			questions.add(question);
		}

		for (Question q : questions) {
			System.out.println(q.ID + "\t" + q.Title);
		}
	}
	
	public void openHtmlFile(MysqlHelper mysqlHelper, String basePath, int id) throws Exception {
		ResultSet result = mysqlHelper.executeQuery("select * from Questions where ID="+id);

		while (result.next()) {
			Question question = new Question();
			question.ID = result.getInt(1);
			question.Title = result.getString(2);
			question.HtmlFilePath = result.getString(3);
			questions.add(question);
		}

		for (Question q : questions) {
			String filePath = basePath + "/" + q.HtmlFilePath;
			if(fileUtils.isExisted(filePath)) {
				CommandLineUtil.runCommand("open " + filePath);
			} else {
				System.out.println(filePath + " doesn't existed");
			}
		}
	}
	
	public void insertJudgeData(MysqlHelper mysqlHelper, int questionId, String inputPath, String outputPath, String programPath) throws Exception {
		String input = fileUtils.fileToString(inputPath);
		String output = fileUtils.fileToString(outputPath);
		String programCode = fileUtils.fileToString(programPath);
		
		List<Pair<String, String>> paraList = new ArrayList<Pair<String, String>>();
		paraList.add(new Pair<String, String>("int", questionId+""));
		paraList.add(new Pair<String, String>("string", input));
		paraList.add(new Pair<String, String>("string", output));
		paraList.add(new Pair<String, String>("string", programCode));
		
		
		int result = mysqlHelper.prepareStatement("insert into OJData(QuestionId, JudgeDataInput, JudgeDataOutput, programCode) values(?, ?, ?, ?)", paraList );
		
	}
	
	public void insertResult(MysqlHelper mysqlHelper, int id, int userId, JudgeResult judgeResult) {
		
	}
	
	/**
	 * 
	 * @param mysqlHelper
	 * @param id
	 * @param filePath
	 * @param userId
	 * @throws Exception
	 */
	public JudgeResult ojJudge(MysqlHelper mysqlHelper, int id, String filePath, int userId) throws Exception {
		String BasePath = "/tmp";
		String workingFolder = BasePath + "/" + userId + "/"+id;
		File target = new File(workingFolder);
		String[] filePaths = filePath.split("/");
		String judgeFileName = filePaths[filePaths.length - 1];
		String judgeFileNameWithoutExtention = judgeFileName.split("\\.")[0];
		String inputFileName = "q"+id+"u"+userId+".in";
		String outputFileName = "q"+id+"u"+userId+".out";
		JudgeResult judgeResult = new JudgeResult();
		
		if(!target.exists()) {
			target.mkdirs();
		}
		
		ResultSet result = mysqlHelper.executeQuery("select * from OJData where QuestionId = "+id);
		List<OJData> ojData = new ArrayList<OJData>();
		
		while (result.next()) {
			OJData data = new OJData();
			data.ID = result.getInt(1);
			data.QuestionId = result.getInt(2);
			data.JudgeDataInput = result.getString(3);
			data.JudgeDataOutput = result.getString(4);
			ojData.add(data);
		}
		
		if(ojData.size() == 1) {
			fileUtils.stringToFile(ojData.get(0).JudgeDataInput, workingFolder + "/" + inputFileName);
			String input = "";
			int timeout = 10;
			String judgeTarget = workingFolder + "/" + judgeFileName;
			fileUtils.copyFileUsingStream(new File(filePath), new File(judgeTarget));
			
			File dir = new File(workingFolder);
			if (filePath.endsWith(".java")) {
				Report report = cli.runCommand("javac " + judgeFileName, timeout, dir);
				
				if(report.exitValue == 1) {
					judgeResult.log = "compile error: " + report.output;
					judgeResult.status = Status.CE;
					return judgeResult;
				}
				
				String cmd = "/bin/sh " +
						"-c \" cd " + workingFolder + " && " +
						"java " + judgeFileNameWithoutExtention + 
						" < " + inputFileName + 
						" > " + outputFileName
						+ "\"";
				
				report = cli.runCommand(cmd, timeout, dir);
				
				if(report.exitValue == 1) {
					judgeResult.log = "run time error: " + report.output;
					judgeResult.status = Status.RE;
					return judgeResult;
				}
			} else if (filePath.endsWith(".py")) {
				String cmd = "/bin/sh " +
						"-c \" cd " + workingFolder + " && " +
						"python3 " + judgeFileNameWithoutExtention + 
						"<" + inputFileName + 
						" > " + outputFileName
						+ "\"";
				
				Report report = cli.runCommand(cmd, timeout, dir);
				if(report.exitValue == 1) {
					judgeResult.log = "compile error: " + report.output;
					judgeResult.status = Status.CE;
					return judgeResult;
				}
			} else if (filePath.endsWith(".cpp")) {
				Report report = cli.runCommand("g++ -std=c++11 " + judgeFileName + " -o " +  judgeFileNameWithoutExtention +".run", timeout, dir);
				if(report.exitValue == 1) {
					judgeResult.log = "compile error: " + report.output;
					judgeResult.status = Status.CE;
					return judgeResult;
				}
				
				String cmd = "/bin/sh " +
						"-c \" cd " + workingFolder + " && " +
						"./" + judgeFileNameWithoutExtention+ ".run" + 
						" < " + inputFileName + 
						" > "  + outputFileName 
						+ "\"";
				
				report = cli.runCommand(cmd, timeout, dir);
				if(report.exitValue == 1) {
					judgeResult.log = "run time error: " + report.output;
					judgeResult.status = Status.RE;
					return judgeResult;
				}
			} else if (filePath.endsWith(".c")) {
				Report report = cli.runCommand("gcc " + judgeFileName + " -o " +  judgeFileNameWithoutExtention +".run", timeout, dir);
				
				if(report.exitValue == 1) {
					judgeResult.log = "compile error: " + report.output;
					judgeResult.status = Status.CE;
					return judgeResult;
				}
				
				String cmd = "/bin/sh " +
						"-c \" cd " + workingFolder + " && " +
						"./" + judgeFileNameWithoutExtention+ ".run" + 
						" < " + inputFileName + 
						" > "  + outputFileName 
						+ "\"";
				
				report = cli.runCommand(cmd, timeout, dir);
				if(report.exitValue == 1) {
					judgeResult.log = "run time error: " + report.output;
					judgeResult.status = Status.RE;
					return judgeResult;
				}
				
			} else if (filePath.endsWith(".m")) {
				Report report = cli.runCommand("clang -framework Foundation " + judgeFileName + "-o " +  judgeFileNameWithoutExtention +".run", timeout, dir);
				if(report.exitValue == 1) {
					judgeResult.log = "compile error: " + report.output;
					judgeResult.status = Status.CE;
					return judgeResult;
				}
				
				String cmd = "/bin/sh " +
						"-c \" cd " + workingFolder + " && " +
						"./" + judgeFileNameWithoutExtention+ ".run" + 
						" < " + inputFileName + 
						" > "  + outputFileName 
						+ "\"";
				
				report = cli.runCommand(cmd, timeout, dir);
				if(report.exitValue == 1) {
					judgeResult.log = "run time error: " + report.output;
					judgeResult.status = Status.RE;
					return judgeResult;
				}
			} else if (filePath.endsWith(".php")) {
				String cmd = "/bin/sh " +
						"-c \" cd " + workingFolder + " && " +
						"php " + judgeFileNameWithoutExtention + 
						"<" + inputFileName + 
						" > " + outputFileName
						+ "\"";
				
				Report report = cli.runCommand(cmd, timeout, dir);
				if(report.exitValue == 1) {
					judgeResult.log = "run time error: " + report.output;
					judgeResult.status = Status.RE;
					return judgeResult;
				}
			}
			
			// compare .out file and database file
			String outputStream = fileUtils.fileToString(workingFolder + "/" + outputFileName);
			String[] outputList = outputStream.split("\n");
			
			String[] expectedOutputList = ojData.get(0).JudgeDataOutput.split("\n");
			
			if(outputList.length == expectedOutputList.length) {
				for(int i=0;i<outputList.length;i++) {
					if (!outputList[i].equals(expectedOutputList[i])) {
						judgeResult.log = "\"WA, expect output: \" + expectedOutputList[i] + \" actual output: \" + outputList[i]";
						judgeResult.status = Status.WA;
						return judgeResult;
					}
				}
				judgeResult.log = "Accepted";
				judgeResult.status = Status.AC;
				return judgeResult;
			} else {
				judgeResult.log = "\"WA, some of input didn't have output\\n\"";
				judgeResult.status = Status.WA;
				return judgeResult;
			}
		}
		return judgeResult;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
