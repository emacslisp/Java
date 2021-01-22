package com.dw.lib;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlHelper extends DatabaseHelper {

	public MysqlHelper() throws Exception {
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb?useSSL=true", "root", "123456");
	}

	public MysqlHelper(String url, String username, String password) throws Exception {
		super("com.mysql.jdbc.Driver", url, username, password);
	}

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=true", "root", "123456");
	}
	
	@Override
	public List<String> getAllDatabase() throws Exception {
		List<String> result = new ArrayList<>();

		ResultSet rs = stmt.executeQuery("Show Databases");
		while (rs.next()) {
			result.add(rs.getString(1));
		}

		return result;
	}

	/**
	 * url: jdbc:mysql://localhost:3306/testdb?useSSL=true username: String password: String
	 */
	public Connection getConnection(String url, String username, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MysqlHelper mysqlHelper = new MysqlHelper("jdbc:mysql://localhost:3306/springtutorial?useSSL=true", "root", "123456");
		try {
			mysqlHelper.printTable("select * from offers");
			mysqlHelper.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
