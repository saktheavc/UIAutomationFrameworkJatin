package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestHardcoded {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); // loosely coupled
		driver.manage().window().maximize(); // Method chaining
		driver.get("http://www.automationpractice.pl/index.php");
		
		By signInLocator = By.xpath("//a[contains(text(),'Sign in')]");
		WebElement signInElement = driver.findElement(signInLocator);
		signInElement.click();
		
		By emailTextBoxLocator = By.id("email");
		WebElement emailTextBoxElement = driver.findElement(emailTextBoxLocator);
		emailTextBoxElement.sendKeys("sakthitest@gmail.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		WebElement passwordTextBoxElement = driver.findElement(passwordTextBoxLocator);
		passwordTextBoxElement.sendKeys("password");
		
		By submitLoginButtonLocator = By.id("SubmitLogin");
		WebElement submitLoginButtonElement = driver.findElement(submitLoginButtonLocator);
		submitLoginButtonElement.click();

	}

}
