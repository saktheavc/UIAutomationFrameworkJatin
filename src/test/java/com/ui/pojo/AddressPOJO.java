package com.ui.pojo;

public class AddressPOJO {
	
	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postCode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String additionalInfo;
	private String addressTextBox;
	private String state;
	
	public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String postCode,
			String homePhoneNumber, String mobileNumber, String additionalInfo, String addressTextBox, String state) {
		super();
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postCode = postCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.additionalInfo = additionalInfo;
		this.addressTextBox = addressTextBox;
		this.state = state;
	}
	
	public String getCompany() {
		return company;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public String getAddressTextBox() {
		return addressTextBox;
	}
	public String getState() {
		return state;
	}
	

}
