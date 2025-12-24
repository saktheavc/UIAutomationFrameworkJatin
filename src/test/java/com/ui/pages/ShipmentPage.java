package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShipmentPage extends BrowserUtility {

	private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processCarrier");
			
	public ShipmentPage(WebDriver driver) {
		super(driver);
	}
	
	public ShipmentPage clickTermsOfServiceCheckbox() {
		clickOnCheckBox(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
		return new ShipmentPage(getDriver());
	}
	
	public PaymentPage goToPaymentPage() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
