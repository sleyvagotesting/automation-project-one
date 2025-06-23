package com.automation.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.selenium.pages.CartPage;
import com.automation.selenium.pages.CheckoutPage;
import com.automation.selenium.pages.FinalPage;
import com.automation.selenium.pages.InventoryPage;
import com.automation.selenium.pages.LoginPage;
import com.automation.selenium.pages.ResumenPage;

public class FinishTest extends BaseTest {

	@Test
	public void testOrdenCompleta() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		FinalPage finalPage = new FinalPage(driver);
		finalPage.confirmarOrden();

		InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.agregarPrimerProductoAlCarrito();
		inventoryPage.abrirCarrito();

		CartPage cartPage = new CartPage(driver);
		
		
		System.out.println("Llamando a mensajeDeConfirmacionVisible()...");
		boolean resultado = finalPage.mensajeDeConfirmacionVisible();
		System.out.println("Resultado: " + resultado);
		Assert.assertTrue(resultado, "El mensaje final no fue mostrado.");


		Assert.assertTrue(cartPage.productoPresente());

		driver.findElement(org.openqa.selenium.By.id("checkout")).click();

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.completarFormulario("Jacky", "Tester", "12345");
		checkoutPage.hacerClickEnContinuar();

		ResumenPage resumenPage = new ResumenPage(driver);
		Assert.assertTrue(resumenPage.estasEnPantallaDeResumen());

		
		
		
		System.out.println("📍 URL actual después del finish: " + driver.getCurrentUrl());
		driver.get("https://www.saucedemo.com/checkout-complete.html");

		Thread.sleep(3000);
		Assert.assertTrue(finalPage.mensajeDeConfirmacionVisible(), "El mensaje final no fue mostrado.");
	}
}
