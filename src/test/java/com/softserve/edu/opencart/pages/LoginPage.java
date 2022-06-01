package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AccountSidebarGuestPart {

    private WebElement email;
    private WebElement password;
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        email = driver.findElement(By.name("email"));
        password = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
    }

}