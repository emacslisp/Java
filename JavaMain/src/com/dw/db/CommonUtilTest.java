package com.dw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CommonUtilTest {
	
	public static void main(String[] args) throws SQLException {
		 final String url = "jdbc:mysql://localhost:3307/fleats";
	        final String driver = "com.mysql.jdbc.Driver";
	        final String usr = "root";
	        final String pwd = "123456";
	        
	        QueryRunner run = new QueryRunner();

	        DbUtils.loadDriver(driver);
	        Connection conn = DriverManager.getConnection(url, usr, pwd);
	        
	        ResultSetHandler<List<LookupCode>> resultHandler = new BeanListHandler<LookupCode>(LookupCode.class);
	        
	        try {
	        	List<LookupCode> emp = run.query(conn, "SELECT * FROM lookup_code WHERE code_type = ? and lookup_text = ?",
	                    resultHandler, "R", "Junk - Mobile failed junk filter test");
	            System.out.println(emp.size());
	        } finally {
	            DbUtils.close(conn);
	        }
	        
	}
	
}
