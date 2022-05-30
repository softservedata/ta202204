package com.softserve.edu.browsersDrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ChromeDriverUtilitiesImp implements DriverUtilities {
    public WebDriver driver;
    public WebDriverWait wait;

    public ChromeDriverUtilitiesImp(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void stalenessExceptionCLick(String conditionCss) {
        WebElement element = this.findByCssSelector(conditionCss);
        element.click();
    }
}
