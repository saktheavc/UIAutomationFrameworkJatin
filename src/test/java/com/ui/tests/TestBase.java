package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

public class TestBase {
	
	HomePage homePage;

	@BeforeMethod(description = "Load the Homepage of the website")
	public void setUp() {
		homePage = new HomePage(CHROME);
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}

}
