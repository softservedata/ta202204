package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAccountPage extends AccountSidebarLoggedPart {

    private WebElement firstNameField;
    private WebElement continueButton;

    public EditAccountPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        firstNameField = driver.findElement(By.name("firstname"));
        continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
    }

}