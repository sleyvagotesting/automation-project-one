package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CartTest extends BaseTest{

	@Test
    public void testAgregarProductoAlCarrito() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.agregarPrimerProductoAlCarrito();

        Assert.assertTrue(inventoryPage.carritoTieneProductos(), "El carrito no muestra ningún producto.");

        inventoryPage.abrirCarrito();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.paginaCarritoVisible(), "No se abrió la página del carrito.");
        Assert.assertTrue(cartPage.productoPresente(), "No se encontró el producto en el carrito.");
    }
}

