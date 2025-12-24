package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddressTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	@BeforeMethod
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("sakthitest@gmail.com", "password");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description = "Add a new address for a user first time")
	public void addNewFirstAddress() {
		String newAddressTitle = myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddressTitle, address.getAddressTextBox().toUpperCase());
	}

}
