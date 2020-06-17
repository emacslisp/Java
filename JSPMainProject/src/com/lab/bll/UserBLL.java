package com.lab.bll;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class UserBLL {
	Connection conn = null;
	public UserBLL() {
		conn = initDataSource();
	}
	
	public boolean validUserNamePassword(String username, String password) {
			
		if(conn != null) {
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				String sql = "select * from User where username = '" + username + "' and password = '" + password + "'";
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("=========== execute JNDI query successfully");
				int count = 0;
				while (rs.next()) {
				    ++count;
				}
				stmt.close();
				
				if (count > 0) {
					return true;
				}
				
				return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(stmt!= null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		return false;
	}
	
	public Connection initDataSource() {
		Context initContext;
		try {
			initContext = new InitialContext();
		
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/Test");
			Connection conn = ds.getConnection();
			
			return conn;
		} catch (NamingException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
