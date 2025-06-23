package com.automation.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private WebDriver driver;

	// Locators form
	private By firstNameInput = By.id("first-name");
	private By lastNameInput = By.id("last-name");
	private By zipCodeInput = By.id("postal-code");
	private By continueButton = By.id("continue");

	// Constructor
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void completarFormulario(String nombre, String apellido, String zip) {
		driver.findElement(firstNameInput).sendKeys(nombre);
		driver.findElement(lastNameInput).sendKeys(apellido);
		driver.findElement(zipCodeInput).sendKeys(zip);
	}

	public void hacerClickEnContinuar() {
		driver.findElement(continueButton).click();
	}
}
