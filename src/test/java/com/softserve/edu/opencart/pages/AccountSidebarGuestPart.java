package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AccountSidebarGuestPart extends AccountSidebarPart {

    @FindBy(xpath = "//div[@class='list-group']/a[contains(@href, 'account/login')]")
    private WebElement loginRight;
    @FindBy(xpath = "//div[@class='list-group']/a[contains(@href, 'account/register')]")
    private WebElement registerRight;
    @FindBy(xpath = "//div[@class='list-group']/a[contains(@href, 'account/forgotten')]")
    private WebElement forgottenPasswordRight;

    public AccountSidebarGuestPart(WebDriver driver) {
        super(driver);
        initElements();
        PageFactory.initElements(driver, this);
    }

    private void initElements() {
        // init elements
        /*
        loginRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/login')]"));
        registerRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/register')]"));
        forgottenPasswordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/forgotten')]"));
        */
    }

    // Page Object

    // loginRight
    public WebElement getLoginRight() {
        return loginRight;
    }

    public String getLoginRightText() {
        return getLoginRight().getText();
    }

    public void clickLoginRight() {
        getLoginRight().click();
    }

    // registerRight
    public WebElement getRegisterRight() {
        return registerRight;
    }

    public String getRegisterRightText() {
        return getRegisterRight().getText();
    }

    public void clickRegisterRight() {
        getRegisterRight().click();
    }

    // forgottenPasswordRight
    public WebElement getForgottenPasswordRight() {
        return forgottenPasswordRight;
    }

    public String getForgottenPasswordRightText() {
        return getForgottenPasswordRight().getText();
    }

    public void clickForgottenPasswordRight() {
        getForgottenPasswordRight().click();
    }

    // Functional

    // Business Logic

    public LoginPage gotoLoginRight() {
        clickLoginRight();
        return new LoginPage(driver);
    }

}
