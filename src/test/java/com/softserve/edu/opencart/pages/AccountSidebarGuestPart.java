package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarGuestPart extends AccountSidebarPart {

    private WebElement loginRight;
    private WebElement registerRight;
    private WebElement forgottenPasswordRight;
    
    protected Search search;

    public AccountSidebarGuestPart(WebDriver driver) {
        super(driver);
        initElements();
        search = SearchStrategy.getSearch();
    }

    private void initElements() {
        // init elements
        loginRight = search.xpath("//div[@class='list-group']/a[contains(@href, 'account/login')]");
        loginRight = search.xpath("//div[@class='list-group']/a[contains(@href, 'account/login')]");
        registerRight = search.xpath("//div[@class='list-group']/a[contains(@href, 'account/register')]");
        forgottenPasswordRight = search.xpath("//div[@class='list-group']/a[contains(@href, 'account/forgotten')]");
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
