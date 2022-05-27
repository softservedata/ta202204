package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestDropdown {

    private WebDriver driver;
    //
    private WebElement register;
    private WebElement login;

    public GuestDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        register = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]"));
        login = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/login')]"));
    }

}