package com.automation.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// Locators
	private By usarnameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void login(String username, String password) {

		// Actions
		driver.findElement(usarnameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
	}

}
