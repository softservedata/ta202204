package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver;
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccountTab;
	
	@FindBy(xpath="//a[contains(@href,'account/login')]")
	WebElement loginLink;
	
	@FindBy(id="input-email")
	WebElement emailField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//aside[@id='column-right']//a[contains(@href,'account/logout')]")
	WebElement logoutLink;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyAccountTab() {
		myAccountTab.click();
	}
	
	public void clickOnLoginLink() {
		loginLink.click();
	}
	
	public void setEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public boolean verifyLogin() {
		return logoutLink.isDisplayed();
	}

}
