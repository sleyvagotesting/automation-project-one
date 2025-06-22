package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinalPage {

	private WebDriver driver;

	// Locators
	private By finishButton = By.cssSelector(".btn.btn_action.btn_medium.cart_button");
	private By mensajeFinal = By.xpath("//h2[@class='complete-header']"); // Más claro y directo

	// Constructor
	public FinalPage(WebDriver driver) {
		this.driver = driver;
	}

	// Acción: Confirmar orden
	public void confirmarOrden() {
		driver.findElement(finishButton).click();
	}

	// Verificación: ¿Mensaje final visible?
	public boolean mensajeDeConfirmacionVisible() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        List<WebElement> elementosH2 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("h2")));

	        System.out.println("🔍 Cantidad de h2 encontrados: " + elementosH2.size());
	        for (WebElement h2 : elementosH2) {
	            System.out.println("🔍 Texto h2: [" + h2.getText() + "]");
	            System.out.println("🔍 Clase h2: [" + h2.getAttribute("class") + "]");
	        }

	        for (WebElement h2 : elementosH2) {
	            if (h2.getText().equalsIgnoreCase("Thank you for your order!")) {
	                System.out.println("🟢 Mensaje final encontrado!");
	                return true;
	            }
	        }

	        System.out.println("🔴 No se encontró el mensaje exacto.");
	        return false;
	    } catch (Exception e) {
	        System.out.println("🔴 Excepción: " + e.getMessage());
	        return false;
	    }
}}
