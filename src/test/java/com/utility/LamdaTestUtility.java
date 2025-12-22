package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LamdaTestUtility {

	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal 
	= new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver initializeLamdaTestSession(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Browser & OS
		capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "latest");

        // LambdaTest specific options
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user","saktheavc");
        ltOptions.put("accessKey", "LT_Xl4YBOioWZsQon8BLeDz7OxdhO0H29uwSk7oMkzykoe7sEq");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("seCdp", true);
        ltOptions.put("seleniumVersion", "4.21.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);

        WebDriver driver=null;
		try {
			driver = new RemoteWebDriver(
			        new URL(HUB_URL),capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        
        driverLocal.set(driver);
        return driverLocal.get();
	}
	
	public static void quitSession() {
		if(driverLocal.get()!=null) {
			driverLocal.get().quit();
		}
	}



























}
