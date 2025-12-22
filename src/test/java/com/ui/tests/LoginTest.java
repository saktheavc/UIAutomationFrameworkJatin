package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase {
	
//	@Test(description = "Verify valid user is able to login into the application", groups = {"sanity","e2e"},
//			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
//			dataProvider ="LoginTestDataProvider")
//	public void loginTest(User user) {
//		
//		assertEquals(homePage.goToLoginPage()
//				.doLoginWith(user.getEmailAddress(), user.getPassword())
//				.getUserName(), "Sakthivel B");
//	}
//	
//	
//	@Test(description = "Verify valid user is able to login into the application", groups = {"sanity","e2e"},
//			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
//			dataProvider ="LoginCSVTestDataProvider")
//	public void loginCSVDataTest(User user) {
//		
//		assertEquals(homePage.goToLoginPage()
//				.doLoginWith(user.getEmailAddress(), user.getPassword())
//				.getUserName(), "Sakthivel B");
//	}
//	
//	@Test(description = "Verify valid user is able to login into the application", groups = {"sanity","e2e"},
//			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
//			dataProvider ="LoginExcelTestDataProvider", 
//			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginExcelDataTest(User user) { // run: 4, Failures: 1, Retries: 3
//		assertEquals(homePage.goToLoginPage()
//				.doLoginWith(user.getEmailAddress(), user.getPassword())
//				.getUserName(), "Sakthivel B");	
//	}
	
	@Test(description = "Launch login page")
	public void launchLoginPage() {
		homePage.goToLoginPage();
	}

}
