package com.lab.test;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.lab.bll.UserBLL;

public class TestEntry {

	@Test
	public void loginTest() {
		String username = "java.gdb@gmail.com";
		String password = "123456789";
		UserBLL userBLL = new UserBLL(true);
		boolean result = userBLL.validUserNamePassword(username, password);
		Assert.assertEquals(result, true);
	}

}
