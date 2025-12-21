package com.ui.pages;

import static com.constants.Env.QA;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

public final class HomePage extends BrowserUtility {
	
	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		//goToWebsite(readProperty(QA, "URL"));
		maximizeWindow();
	}
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}
	
	

}
