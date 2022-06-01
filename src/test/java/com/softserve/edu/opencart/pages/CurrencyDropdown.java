package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyDropdown {

	private WebDriver driver;
    //
    private WebElement selectCurrency;

    public CurrencyDropdown(WebDriver driver, String currency) {
        this.driver = driver;
        initElements(currency);
    }

    private void initElements(String currency) {
    	selectCurrency = driver.findElement(By.name(currency));
    }

    // Page Object

    // selectCurrency
    public WebElement getSelectCurrency() {
        return selectCurrency;
    }

    public String getSelectCurrencyText() {
        return getSelectCurrency().getText();
    }

    public void clickSelectCurrency() {
    	getSelectCurrency().click();
    }

    // Functional

    // Business Logic

}
