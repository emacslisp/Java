package com.dw.lib.test;

import com.dw.lib.CryptoGenerator;
import com.dw.lib.RandomService;

public class UserAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CryptoGenerator m = new CryptoGenerator();
		
		String userName = "wudi";
		String salt = RandomService.randomString(6);
		String password = "123456";
		
		try {
			String passwordMD5 = m.generateValue(password + salt);
			System.out.println(passwordMD5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// a9654d867007ffe568a8a6b59539ef37
	}

}
