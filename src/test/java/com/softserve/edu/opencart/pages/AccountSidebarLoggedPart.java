package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarLoggedPart extends AccountSidebarPart {

    private WebElement editAccountRight;
    private WebElement passwordRight;
    private WebElement logoutRight;

    public AccountSidebarLoggedPart(WebDriver driver) {
        super(driver);
        initElements();
        //ApplicationStatus.get().setLogged(true);
    }

    private void initElements() {
        // init elements
        editAccountRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/edit')]"));
        passwordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/password')]"));
        logoutRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/logout')]"));
    }

}
