package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.InventoryPage;
import Pages.LoginPage;

public class InventoryTest extends BaseTest {

	@Test
	public void testVerProductosEnInventario() {

		// login first
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("standard_user", "secret_sauce");

		// inventory page
		InventoryPage inventorypage = new InventoryPage(driver);

		// product validation
		int cantidad = inventorypage.contarProductos();
		System.out.println("Número de productos encontrados " + cantidad);
		Assert.assertTrue(cantidad > 0, "No se encontraron productos");

		// Title
		Assert.assertTrue(inventorypage.tituloEsVisible(), "No se muestra el título de la página");

	}
}
