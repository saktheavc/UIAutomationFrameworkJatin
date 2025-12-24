package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "printed summer dress";
	
	@BeforeMethod
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("sakthitest@gmail.com", "password");
	}
	
	@Test(description = "Validate product search functionality")
	public void verifyProductSearchTest() {
		
				boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM)
				.isSearchTermPresentInProductList(SEARCH_TERM);
				Assert.assertEquals(actualResult, true);	
	}
	
	
}
