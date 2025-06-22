package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResumenPage {

	private WebDriver driver;

	private By titleResumen = By.className("title");

	public ResumenPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean estasEnPantallaDeResumen() {
		return driver.findElement(titleResumen).getText().equalsIgnoreCase("Checkout: Overview");
	}
}
