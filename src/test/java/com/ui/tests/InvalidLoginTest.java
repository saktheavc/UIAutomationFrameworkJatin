package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends TestBase {
	
	private static final String INVALID_EMAIL_ADDRESS = "sakthi92@gmail.com";
	private static final String INVALID_PASSWORD = "passwrd";
	

	@Test
	public void verifyInvalidLogin() {
		
		Assert.assertEquals(homePage.goToLoginPage().
		doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
		.getLoginErrorMessage(), "Authentication failed.");
	}
	
}
