package com.dw.lib;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlHelper {

	Connection conn;
	Statement stmt;
	public MysqlHelper() throws Exception {
		conn = getConnection();
		stmt = conn.createStatement();
	}

	public MysqlHelper(String url, String username, String password) throws Exception {
		conn = getConnection(url, username, password);
		stmt = conn.createStatement();
	}

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=true", "root", "123456");
	}

	/**
	 * url: jdbc:mysql://localhost:3306/testdb?useSSL=true username: String password: String
	 */
	public Connection getConnection(String url, String username, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}

	// insert update delete and create
	public int executeUpdate(String sql) throws Exception {
		int result = stmt.executeUpdate(sql);
		//stmt.close();
		return result;
	}
	
	//Get all Table of a database
	public List<String> getAllTables() throws Exception {
		List<String> result = new ArrayList<String>();
		
		DatabaseMetaData metaData = conn.getMetaData();
		String[] types = { "TABLE" };
		// Retrieving the columns in the database
		ResultSet tables = metaData.getTables(null, null, "%", types);
		while (tables.next()) {
			result.add(tables.getString("TABLE_NAME"));
		}
		return result;
	}

	// run select
	// one of way to simulate hibernate is to mapping field into Class
	public ResultSet executeQuery(String sql) throws Exception {
		
		ResultSet rs = stmt.executeQuery(sql);
		//stmt.close();
		return rs;
	}
	
	public int columnCount(ResultSet result) throws Exception {
		ResultSetMetaData rsmd = result.getMetaData();
		int columnCount = rsmd.getColumnCount();
		return columnCount;
	}
	
	public List<String> columnName(ResultSet result) throws Exception {
		ArrayList arrayList = new ArrayList();
		ResultSetMetaData rsmd = result.getMetaData();
		int columnCount = rsmd.getColumnCount();
		
		for (int i = 1; i <= columnCount; i++ ) {
			  String name = rsmd.getColumnName(i);
			  arrayList.add(name);
			  // Do stuff with name
			}
		return arrayList;
	}
	
	public void close() throws SQLException {
		stmt.close();
		conn.close();
	}
	
	public void printTable(String sql) throws Exception {
		Statement stmt = conn.createStatement();
		boolean success = stmt.execute(sql);
		if (!success) {
			System.out.println("no result set but successfully!!! " + sql);
			return;
		}
		System.out.println("Result of " + sql);
		ResultSet result = stmt.getResultSet();
		List<String> columnName = this.columnName(result);
		while (result.next()) {
			for(String label: columnName) {
				System.out.println(label + ":" + result.getString(label));
			}
			System.out.println();
	    }
	}
	
	public String printTableToHtml(String sql) throws Exception {
		Statement stmt = conn.createStatement();
		boolean success = stmt.execute(sql);
		if (!success) {
			System.out.println("no result set but successfully!!! " + sql);
			return "";
		}
		
		ResultSet result = stmt.getResultSet();
		List<String> columnName = this.columnName(result);
		StringUtils ss = new StringUtils();
		ss.appendLine("<table>");
		ss.appendLine("<tr>");
		for(String label: columnName) {
			ss.appendLine("<th>" + label + "</th>");
		}
		ss.appendLine("</tr>");
		
		while (result.next()) {
			ss.appendLine("<tr>");
			for(String label: columnName) {
				System.out.println("<td>" + result.getString(label) + "</td>");
			}
			ss.appendLine("</tr>");
	    }
		ss.appendLine("</table>");
		System.out.println(ss.toString());
		return ss.toString();
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
