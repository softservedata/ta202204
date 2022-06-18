package com.softserve.edu.opencart.pages;
/**
 * homework 12:
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CurrencyDropdown {
    private WebDriver driver;
    private List<WebElement> currencyOptions;

    public List<WebElement> getCurrencyOptions() {
        return currencyOptions;
    }

    public CurrencyDropdown(WebDriver driver, By currencyLocator) {
        this.driver = driver;
        initElements(currencyLocator);
    }

    public void initElements(By currencyLocator) {
        currencyOptions = driver.findElements(currencyLocator);
    }

    public List<String> getCurrencyOptionsText() {
        List<String> result = new ArrayList<>();
        for (WebElement current : getCurrencyOptions()) {
            result.add(current.getText());
        }
        return result;
    }

    public boolean isExistCurrencyOptionByName(String currencyName) {
        boolean isFound = false;
        for (String current : getCurrencyOptionsText()) {
            if (current.toLowerCase().contains(currencyName.toLowerCase())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public WebElement getCurrencyOptionByName(String currencyName) {
        WebElement result = null;
        for (WebElement current :
                getCurrencyOptions()) {
            if (current.getText().toLowerCase().contains(currencyName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;
    }
    public void clickCurrencyOptionByName (String currencyName) {
        getCurrencyOptionByName(currencyName).click();
    }
}

