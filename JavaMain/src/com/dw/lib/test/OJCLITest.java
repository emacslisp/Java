package com.dw.lib.test;

import com.dw.lib.MysqlHelper;
import com.dw.lib.OJHelper;
import com.dw.lib.OJHelper.User;

public class OJCLITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String host = "localhost";
			int port = 3306;
			String dbName = "oj";
			String dbUsername = "root";
			String dbPassword = "123456";
			String username = "ewu";
			String password = "12345";
			
			MysqlHelper mysqlHelper = new MysqlHelper("jdbc:mysql://"+host+":"+port+"/"+dbName + "?verifyServerCertificate=false&useSSL=true", dbUsername, dbPassword);
			
			OJHelper helper = new OJHelper();
			User user = helper.doAuth(mysqlHelper, username, password);
			if(user==null) {
				System.out.println("Auth failed");
				return;
			}
			System.out.println(user.UserName);
			
			
			helper.printOutQuestion(mysqlHelper, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
