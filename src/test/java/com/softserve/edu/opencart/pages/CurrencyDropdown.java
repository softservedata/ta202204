package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrencyDropdown {
    private final WebDriver driver;

    @FindBy(xpath = "//form[@id='form-currency']//li[1]/button[@name='EUR']")
    WebElement euro;

    @FindBy(xpath = "//form[@id='form-currency']//li[2]/button[@name='GBP']")
    WebElement poundSterling;

    @FindBy(xpath = "//form[@id='form-currency']//li[3]/button[@name='USD']")
    WebElement usDollar;

    public CurrencyDropdown(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEuro() {
        return this.euro;
    }

    public void clickEuro() {
        this.getEuro().click();
    }

    public String getEuroText() {
        return this.getEuro().getText();
    }

    public WebElement getPoundSterling() {
        return this.poundSterling;
    }

    public void clickPoundSterling() {
        this.getPoundSterling().click();
    }

    public String getPoundSterlingText() {
        return this.getPoundSterling().getText();
    }

    public WebElement getUsDollar() {
        return this.usDollar;
    }

    public void clickUsDollar() {
        this.getUsDollar().click();
    }

    public String getUsDollarText() {
        return this.getUsDollar().getText();
    }
}