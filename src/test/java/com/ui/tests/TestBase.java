package com.ui.tests;

import static com.constants.Browser.*;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;

public class TestBase {
	
	protected HomePage homePage;
	private boolean isLambdaTest = true;

	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load the Homepage of the website")
	public void setUp(
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("false") boolean isHeadless, ITestResult result) {
		
		this.isLambdaTest=isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			lambdaDriver = LamdaTestUtility.initializeLamdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver); // for cloud execution
		}
		else {
			homePage = new HomePage(CHROME, isHeadless); // for local execution
		}
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LamdaTestUtility.quitSession(); // quit the cloud session
		}
		else {
			homePage.quitDriver(); // quit the local session
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
