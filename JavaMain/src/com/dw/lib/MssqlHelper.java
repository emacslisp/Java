package com.dw.lib;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MssqlHelper {

	Connection conn;
	Statement stmt;
	String JDBCDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public MssqlHelper() throws Exception {
		conn = getConnection();
		stmt = conn.createStatement();
	}

	public MssqlHelper(String url, String username, String password) throws Exception {
		conn = getConnection(url, username, password);
		stmt = conn.createStatement();
	}

	public Connection getConnection() throws Exception {
		Class.forName(JDBCDriver);
		return DriverManager.getConnection("jdbc:sqlserver://localhost\\\\sqlexpress;user=sa;password=123456", "sa", "123456");
	}

	/**
	 * url: String connectionUrl =
                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
                        + "database=AdventureWorks;"
                        + "user=yourusername@yourserver;"
                        + "password=yourpassword;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
	 */
	public Connection getConnection(String url, String username, String password) throws Exception {
		Class.forName(JDBCDriver);
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
