package com.auto.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	@CacheLookup
	WebElement textfield_email;
	
	@FindBy(id = "input-password")
	@CacheLookup
	WebElement textfield_password;
	
	@FindBy(css = "input[value='Login']")
	@CacheLookup
	WebElement btn_login;

	public WebElement getTextfield_email() {
		return textfield_email;
	}

	public WebElement getTextfield_password() {
		return textfield_password;
	}

	public WebElement getBtn_login() {
		return btn_login;
	}
	
	
	
	
	

}
