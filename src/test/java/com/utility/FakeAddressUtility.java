package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {
	
	private static AddressPOJO addressPojo;
	
	public static void main(String[] args) {
		getFakeAddress();
	}
	
	public static AddressPOJO getFakeAddress() {
		
		Faker faker = new Faker(Locale.US);
		addressPojo = new AddressPOJO(faker.company().name(),
				faker.address().buildingNumber(),
				faker.address().streetAddress(),
				faker.address().city(),
				"12345",
				faker.phoneNumber().cellPhone(),
				faker.phoneNumber().cellPhone(),
				faker.address().firstName(),
				faker.address().lastName(),
				faker.address().state());
		
		return addressPojo;
	}

}
