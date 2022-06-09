package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulRegistrationPage extends AccountSidebarLoggedPart {
	
    public static final String EXPECTED_REGISTRATION_MESSAGE = "Your Account Has Been Created!";
    //
    private WebElement successMessage;
    private WebElement continueButton;

    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
    	successMessage = driver.findElement(By.cssSelector("#content>h1"));
    	continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
    }

    // Page Object

    // alert
    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public String getSuccessMessageText() {
        return getSuccessMessage().getText();
    }
    
    private WebElement getContinueButton() {
    	return continueButton;
    }
    
    private void clickContinueButton() {
    	getContinueButton().click();
    }

    // Functional

    // Business Logic
    
	public MyAccountPage gotoContinue() {
		clickContinueButton();
		// fillLogin(email, password);
		return new MyAccountPage(driver);
	}
    


}
