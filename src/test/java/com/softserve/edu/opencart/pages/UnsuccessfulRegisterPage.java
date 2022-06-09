package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulRegisterPage extends RegisterPage{
	
	public /*static*/ final String EXPECTED_REGISTER_MESSAGE = "Warning: You must agree to the Privacy Policy!";
    //
    private WebElement alertWarning;

    public UnsuccessfulRegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertWarning = driver.findElement(By.cssSelector(".alert.alert-danger"));
    }

    // Page Object

    // alertWarning
    public WebElement getAlertWarning() {
        return alertWarning;
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }

    // Functional

    // Business Logic

}
