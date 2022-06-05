package com.softserve.edu.sites.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationComponent {
    @FindBy(xpath = "//div[@class='container']/div[@class='alert alert-success']")
    private WebElement successAlert;

    public NotificationComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getSuccessAlert() {
        return this.successAlert;
    }

    public String getSuccessAlertText() {
        return this.getSuccessAlert().getText();
    }
}
