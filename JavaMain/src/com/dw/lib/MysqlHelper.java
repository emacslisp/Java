package com.dw.lib;

import java.sql.*;

public class MysqlHelper {

	Connection conn;

	public MysqlHelper() throws Exception {
		conn = getConnection();
	}

	public MysqlHelper(String url, String username, String password) throws Exception {
		conn = getConnection(url, username, password);
	}

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "123456");
	}

	/**
	 * url: jdbc:mysql://localhost:3306/testdb username: String password: String
	 */
	public Connection getConnection(String url, String username, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}

	// insert update delete and create
	public int executeUpdate(String sql) throws Exception {
		Statement stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		return result;
	}

	// run select
	public ResultSet executeQuery(String sql) throws Exception {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MysqlHelper mysqlHelper = new MysqlHelper("jdbc:mysql://localhost:3306/springtutorial", "root", "123456");
		try {
			ResultSet result = mysqlHelper.executeQuery("select * from offers");
			while (result.next()) {
		        System.out.println(result.getString(1));
		        System.out.println(result.getString(2));
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
