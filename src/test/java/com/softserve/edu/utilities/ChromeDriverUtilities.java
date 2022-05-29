package com.softserve.edu.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChromeDriverUtilities {
    public WebDriver driver;

    public ChromeDriverUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findByCssSelector(String conditionCss) {
        return this.driver.findElement(By.cssSelector(conditionCss));
    }

    public WebElement findByXpath(String conditionXpath) {
        return this.driver.findElement(By.xpath(conditionXpath));
    }

    public List<WebElement> findAllByXpath(String conditionXpath) {
        return this.driver.findElements(By.xpath(conditionXpath));
    }

    public WebElement findById(String condition) {
        return this.driver.findElement(By.id(condition));
    }

    public void switchToIframe(WebElement iframe) {
        this.driver.switchTo().frame(iframe);
    }
}
