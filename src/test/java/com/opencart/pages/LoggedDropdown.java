package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedDropdown {

    private WebDriver driver;
    //
    private WebElement myAccount;
    private WebElement orderHistory;
    private WebElement transactions;
    private WebElement downloads;
    private WebElement logout;

    protected LoggedDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        myAccount = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/account')]"));
        orderHistory = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/order')]"));
        transactions = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/transaction')]"));
        downloads = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/download')]"));
        logout = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/logout')]"));
    }

}