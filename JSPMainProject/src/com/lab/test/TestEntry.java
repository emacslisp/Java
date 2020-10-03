package com.lab.test;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.lab.bll.UserBLL;

public class TestEntry {

	@Test
	public void loginTest() {
		String username = "wudi";
		String password = "123456";
		String salt = "salt";
		UserBLL userBLL = new UserBLL(true);
		boolean result = userBLL.validUserNamePassword(username, password);
		Assert.assertEquals(result, true);
	}

}
