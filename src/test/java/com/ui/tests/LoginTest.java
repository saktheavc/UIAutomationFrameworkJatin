package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {
	
	HomePage homePage;

	@BeforeMethod(description = "Load the Homepage of the website")
	public void setUp() {
		homePage = new HomePage(CHROME);
	}
	
	@Test(description = "Verify valid user is able to login into the application", groups = {"sanity","e2e"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
			dataProvider ="LoginTestDataProvider")
	public void loginTest(User user) {
		
		assertEquals(homePage.goToLoginPage()
				.doLoginWith(user.getEmailAddress(), user.getPassword())
				.getUserName(), "Sakthivel B");

	}

}
