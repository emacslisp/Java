package com.dw.lib;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OJHelper {

	public class User {
		int ID;
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

	List<Question> questions = new ArrayList<Question>();
	List<User> users = new ArrayList<User>();

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
