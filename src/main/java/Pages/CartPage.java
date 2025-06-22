package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	private WebDriver driver;

	private By cartItem = By.className("cart_item");
	private By title = By.className("title");

	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean productoPresente() {

		return driver.findElements(cartItem).size() > 0;
	}

	public boolean paginaCarritoVisible() {

		return driver.findElement(title).getText().equalsIgnoreCase("Your Cart");

	}

}
