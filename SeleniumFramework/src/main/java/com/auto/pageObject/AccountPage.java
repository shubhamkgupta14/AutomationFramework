package com.auto.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;

	public AccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='list-group']/a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement btn_logout;

	public WebElement getBtn_logout() {
		return btn_logout;
	}

}
