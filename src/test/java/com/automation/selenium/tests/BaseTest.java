package com.automation.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver; // Create a WebDriver variable type called "driver"

	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("----------------Closing browser...-------------");
		if (driver != null) {
			driver.quit();
		}
	}

}
