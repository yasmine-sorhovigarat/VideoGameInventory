package com.sorhovigarat.videogame.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sorhovigarat.videogame.service.UserService;

public class UserServletTest {

	@Test
	public void adminTest() {
		UserService userService = new UserService();
		assertTrue(userService.checkUser("administrator", "1234").equals("Hello administrator. You are signed in with an admin account."));
	}

}
