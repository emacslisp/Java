package com.dw.lib;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OracleHelper extends DatabaseHelper {
	public OracleHelper() throws Exception {
		super("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521:xe", "root", "123456");
	}

	public OracleHelper(String url, String username, String password) throws Exception {
		super("oracle.jdbc.driver.OracleDriver", url, username, password);
	}

	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Properties props = new Properties();
		props.setProperty("user","root");
		props.setProperty("password","123456");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", props);
	}
	
	public Connection getConnection(String url, String username, String password) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Properties props = new Properties();
		props.setProperty("user",username);
		props.setProperty("password",password);
		return DriverManager.getConnection(url, props);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
