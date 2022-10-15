package com.dw.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class H2Helper extends DatabaseHelper {

	public H2Helper() throws Exception {
		super("org.h2.Driver", "jdbc:h2:~/test", "sa", "");
	}

	public H2Helper(String url, String username, String password) throws Exception {
		super("org.h2.Driver", url, username, password);
	}

	public Connection getConnection() throws Exception {
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	}
	
	public static void main(String[] args) throws Exception {
		H2Helper h2Helper = new H2Helper();
		
		h2Helper.executeUpdate("CREATE TABLE IF NOT EXISTS foo_table (" +
                    " key_col VARCHAR2(17)" +
                    ",val_col VARCHAR2(17)" +
                    ")");
		
		h2Helper.executeUpdate("INSERT INTO foo_table (key_col, val_col) " +
				"VALUES ('test', 'testvalue')");
		ResultSet result = h2Helper.executeQuery("select * from foo_table");
        while(result.next()) {
            System.out.println(result.getString("key_col"));
            System.out.println(result.getString("val_col"));
        }
        h2Helper.close();
	}

}
