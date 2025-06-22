package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

	private WebDriver driver;

	// locators
	private By productList = By.className("inventory_item");
	private By pageTitle = By.className("title");
	private By primerBotonAgregar = By.cssSelector(".inventory_item button"); // primer botón "Add to cart"
	private By iconoCarrito = By.className("shopping_cart_badge");
	private By irAlCarrito = By.className("shopping_cart_link");

	public InventoryPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public int contarProductos() {

		return driver.findElements(productList).size();
	}

	public boolean tituloEsVisible() {

		return driver.findElement(pageTitle).isDisplayed();
	}

	public void agregarPrimerProductoAlCarrito() {
		driver.findElement(primerBotonAgregar).click();
	}

	public boolean carritoTieneProductos() {
		return driver.findElement(iconoCarrito).isDisplayed();
	}

	public void abrirCarrito() {
		driver.findElement(irAlCarrito).click();
	}

}
