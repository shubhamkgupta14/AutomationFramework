package com.auto.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='My Account']")
	@CacheLookup
	WebElement dropdown_myAccount;

	public WebElement getDropdown_myAccount() {
		return dropdown_myAccount;
	}

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	@CacheLookup
	WebElement btn_login;

	public WebElement getBtn_login() {
		return btn_login;
	}
	
	
	
	

}
