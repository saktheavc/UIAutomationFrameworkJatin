package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Color;
import com.constants.Size;
import com.ui.pages.SearchPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer dress";
	private SearchPage searchPage;
	
	@BeforeMethod
	public void setup() {
		searchPage = homePage.goToLoginPage().doLoginWith("sakthitest@gmail.com", "password")
		.searchForAProduct(SEARCH_TERM);
	}
	
	@Test(description = "verify logged in user can able to buy a product")
	public void checkoutTest() {
		String result = searchPage.clickOnTheProductAtIndex(0).selectSizeOfAProduct(Size.M).chooseColor(Color.Blue)
		.addProductToCart().proceedToCheckout().goToConfirmAddressPage()
		.goToShipmentPage().clickTermsOfServiceCheckbox().goToPaymentPage()
		.makePaymentByWire();
		
		Assert.assertTrue(result.contains("Your order on My Shop is complete."));
	}
}
