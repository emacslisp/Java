package com.dw.lib.test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dw.lib.MysqlHelper;
class User {
	int ID;
	String UserName;
	String Password;
	String Salt;
	Date CreatedDate;
	Date LastLoginDate;
	public User() {
		
	}
}
public class DatabaseHelperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		
		String dbName = "OJ";
		String dbUsername = "root";
		String dbPassword = "123456";
		String username = "ewu";
		
		MysqlHelper mysqlHelper;
		try {
			mysqlHelper = new MysqlHelper("jdbc:mysql://"+host+":"+port+"/"+dbName + "?verifyServerCertificate=false&useSSL=true", dbUsername, dbPassword);
			ResultSet result = mysqlHelper.executeQuery("select * from User where username = '" + username + "'");
			List<User> users = new ArrayList<User>();
			while(result.next()) {
				User user = new User();
				user.ID = result.getInt(1);
				user.UserName = result.getString(2);
				user.Password = result.getString(3);
				user.Salt = result.getString(4);
				user.CreatedDate = result.getDate(5);
				user.LastLoginDate = result.getDate(6);
				users.add(user);
			}
			
			for(User u : users) {
				System.out.println(u.UserName + " " + u.Password + " " + u.Salt);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
