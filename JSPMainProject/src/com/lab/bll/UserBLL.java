package com.lab.bll;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

import com.dw.lib.CryptoGenerator;

public class UserBLL {
	Connection conn = null;
	CryptoGenerator m;
	public UserBLL() {
		conn = initDataSource();
		m = new CryptoGenerator();
	}
	
	public UserBLL(boolean mockup) {
		conn = initMockupDataSource();
		m = new CryptoGenerator();
	}
	
	public String getSalt(String username) {
		if(conn != null) {
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				String sql = "select Salt from User where username = '" + username + "'";
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("=========== GET Salt successfully");
				String salt="";
				while (rs.next()) {
					salt = rs.getString("Salt");
				}
				stmt.close();
				return salt;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public boolean validUserNamePassword(String username, String password) {
			
		if(conn != null) {
			Statement stmt = null;
			try {
				String salt = this.getSalt(username);
				String inputPassword = m.generateValue(password + salt);
				stmt = conn.createStatement();
				String sql = "select * from User where username = '" + username + "' and password = '" + inputPassword + "'";
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
				
			} catch(Exception ex) {
				ex.printStackTrace();
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
	
	public Connection initMockupDataSource() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=true", "root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Connection initDataSource() {
		Context initContext;
		try {
			/*initContext = new InitialContext();
		
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/Test");
			Connection conn = ds.getConnection();*/
			
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=true", "root", "123456");

		} /*catch (NamingException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
