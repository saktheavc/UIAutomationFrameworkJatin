package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title = 'View my customer account']/span");
	private static final By SEARCH_BOX = By.id("search_query_top");
	private static final By ADD_MY_FIRST_ADDRESS_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserName() {
		String username =  getVisibleText(USER_NAME_LOCATOR);
		return username;
	}
	
	public SearchPage searchForAProduct(String productName) {
		enterText(SEARCH_BOX, productName);
		enterSpecialKey(SEARCH_BOX, Keys.ENTER);
		SearchPage searchPage = new SearchPage(getDriver());
		return searchPage;
	}
	
	public AddressPage goToAddAddressPage() {
		clickOn(ADD_MY_FIRST_ADDRESS_LOCATOR);
		return new AddressPage(getDriver());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
