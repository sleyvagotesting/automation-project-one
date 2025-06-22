package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.ResumenPage;

public class CheckoutTest extends BaseTest {

	@Test
	public void testFlujoCheckout() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");

		InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.agregarPrimerProductoAlCarrito();
		inventoryPage.abrirCarrito();

		CartPage cartPage = new CartPage(driver);
		Assert.assertTrue(cartPage.productoPresente());

		// Clic en botón Checkout
		driver.findElement(org.openqa.selenium.By.id("checkout")).click();

		// Formulario
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.completarFormulario("Jacky", "Tester", "12345");
		checkoutPage.hacerClickEnContinuar();

		// Validar resumen
		ResumenPage resumenPage = new ResumenPage(driver);
		Assert.assertTrue(resumenPage.estasEnPantallaDeResumen(), "No estás en la pantalla de resumen.");
	}
}
