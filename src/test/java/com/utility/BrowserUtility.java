package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	// driver is thread safe now for parallel execution
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver);
	}
	
	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void goToWebsite(String url) {
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void closeBrowser() {
		driver.get().close();
	}
	
	public void quitDriver() {
		driver.get().quit();
	}
	
	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		String timestamp = dateFormat.format(date);
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//screenshots//"+name+" - "+timestamp+ ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
