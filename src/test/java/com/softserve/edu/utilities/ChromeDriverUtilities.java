package com.softserve.edu.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChromeDriverUtilities {
    public WebDriver driver;

    public ChromeDriverUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findByCssSelector(String condition) {
        return this.driver.findElement(By.cssSelector(condition));
    }

    public WebElement findById(String condition) {
        return this.driver.findElement(By.id(condition));
    }
}
