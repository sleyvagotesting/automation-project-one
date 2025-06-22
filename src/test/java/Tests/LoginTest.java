package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testLoginValidUser() {

		LoginPage loginPage = new LoginPage(driver); // Creating the object
		loginPage.login("standard_user", "secret_sauce");// calling login method

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory"));// Login is working correctly

	}

}
