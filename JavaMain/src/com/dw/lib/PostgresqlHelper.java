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
		super("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/ewu", "postgres", "123456");
	}

	public PostgresqlHelper(String url, String username, String password) throws Exception {
		super("org.postgresql.Driver", url, username, password);
	}
	
	public PostgresqlHelper(String url, Properties properties) throws Exception {
		super("org.postgresql.Driver", url, properties);
	}

	public Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","123456");
		props.setProperty("ssl","true");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ewu", props);
	}
	
	public Connection getConnection(String url, String username, String password) throws Exception {
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user",username);
		props.setProperty("password",password);
		props.setProperty("ssl","true");
		return DriverManager.getConnection(url, props);
	}
	
	@Override
	public List<String> getAllDatabase() throws Exception {
		List<String> result = new ArrayList<>();

		ResultSet rs = stmt.executeQuery("SELECT datname FROM pg_database WHERE datistemplate = false;");
		while (rs.next()) {
			result.add(rs.getString(1));
		}

		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostgresqlHelper helper;
		try {
			helper = new PostgresqlHelper();
			List<String> result = helper.getAllDatabase();
			for(String x : result) {
				System.out.println(x);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
