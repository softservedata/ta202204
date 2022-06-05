package com.softserve.edu.sites.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeatureComponent {
    @FindBy(xpath = "//*[@id='content']/div[2]")
    WebElement featuresList;

    public FeatureComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private WebElement getFeaturesList() {
        return this.featuresList;
    }

    public void clickCartButton(String productId) {
        this.getFeaturesList().findElement(By.xpath(".//button[contains(@onclick,'" + productId + "')]")).click();
    }
}
