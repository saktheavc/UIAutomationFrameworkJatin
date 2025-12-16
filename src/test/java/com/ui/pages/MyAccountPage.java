package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility{

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title = 'View my customer account']/span");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserName() {
		String username =  getVisibleText(USER_NAME_LOCATOR);
		return username;
	}

}
