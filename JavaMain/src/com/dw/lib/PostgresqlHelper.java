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

public class PostgresqlHelper extends DatabaseHelper {

	public PostgresqlHelper() throws Exception {
		super("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/testdb", "root", "123456");
	}

	public PostgresqlHelper(String url, String username, String password) throws Exception {
		super("org.postgresql.Driver", url, username, password);
	}

	public Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user","root");
		props.setProperty("password","123456");
		props.setProperty("ssl","true");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", props);
	}
	
	public Connection getConnection(String url, String username, String password) throws Exception {
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user",username);
		props.setProperty("password",password);
		props.setProperty("ssl","true");
		return DriverManager.getConnection(url, props);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
