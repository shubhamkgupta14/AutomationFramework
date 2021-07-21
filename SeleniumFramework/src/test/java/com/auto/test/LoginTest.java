package com.auto.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auto.fw.Base;
import com.auto.pageObject.AccountPage;
import com.auto.pageObject.LandingPage;
import com.auto.pageObject.LoginPage;

public class LoginTest extends Base {

	WebDriver driver = null;

	@BeforeMethod
	public void openApplication() throws IOException {
		driver = initializeBrowser();
		driver.navigate().to(configFile.getProperty("baseurl"));
	}

	@Test(dataProvider = "getLoginData")
	public void login(String email, String pswd, String expected_result) {

		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage = new AccountPage(driver);

		landingPage.getDropdown_myAccount().click();
		landingPage.getBtn_login().click();

		loginPage.getTextfield_email().sendKeys(email);
		loginPage.getTextfield_password().sendKeys(pswd);
		loginPage.getBtn_login().click();

		String actual_result = "";

		try {
			accountPage.getBtn_logout().isDisplayed();
			actual_result = "Successfull";
		} catch (Exception e) {
			actual_result = "Failure";
		}

		Assert.assertEquals(actual_result, expected_result);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "arun.selenium@gmail.com", "Second@123", "Successfull" },
				{ "demo@gmail.com", "password", "Failure" } };
		return data;
	}

}
