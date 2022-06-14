package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyDropdown {

    private WebDriver driver;
    //
    private WebElement euro;
    private WebElement poundSterling;
    private WebElement usDollar;
    private WebElement priceInGBP;

    public CurrencyDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        euro = driver.findElement(By.name("EUR"));
        poundSterling = driver.findElement(By.name("GBP"));
        usDollar = driver.findElement(By.name("USD"));
        priceInGBP = driver.findElement(By.xpath("//div[@class='product-thumb transition']//a[text()='MacBook']/../..//p[@class='price']"));
    }
    public void clickEuro() {
        setEuro().click();
    }

    public void clickPoundSterling() {
        setPoundSterling().click();
    }

    public void clickUSDollar() {
        setUSDollar().click();
    }

    public WebElement setEuro() {
        return euro;
    }

    public WebElement setPoundSterling() {
        return poundSterling;
    }

    public WebElement setUSDollar() {
        return usDollar;
    }

}