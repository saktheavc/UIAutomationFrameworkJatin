package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Color;
import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {

	private static final By PRODUCT_SIZE_DROPDOWN_LOCATOR = By.id("group_1");
	private static By PRODUCT_COLOR_LOCATOR;
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailsPage selectSizeOfAProduct(Size size) {
		selectFromDropDown(PRODUCT_SIZE_DROPDOWN_LOCATOR, size.toString());
		return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage chooseColor(Color color) {
		PRODUCT_COLOR_LOCATOR = By.xpath("//ul[@id='color_to_pick_list']/li/a[contains(@title,'"+ color.toString() +"')]");
		clickOn(PRODUCT_COLOR_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage addProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}
	
	public ShoppingCartPage proceedToCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartPage(getDriver());
	}
	
	
	
	
	
	
	

}
