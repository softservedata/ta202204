package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarLoggedPart extends AccountSidebarPart {

    private WebElement editAccountRight;
    private WebElement passwordRight;
    private WebElement logoutRight;
    
    protected Search search;

    public AccountSidebarLoggedPart(WebDriver driver) {
        super(driver);
        initElements();
        search = SearchStrategy.getSearch();
        //ApplicationStatus.get().setLogged(true);
    }

    private void initElements() {
        // init elements
        editAccountRight = search.xpath("//div[@class='list-group']/a[contains(@href, 'account/edit')]");
        passwordRight = search.xpath("//div[@class='list-group']/a[contains(@href, 'account/password')]");
        logoutRight = search.xpath("//div[@class='list-group']/a[contains(@href, 'account/logout')]");
    }

    // Page Object

    // editAccountRight
    public WebElement getEditAccountRight() {
        return editAccountRight;
    }

    public String getEditAccountRightText() {
        return getEditAccountRight().getText();
    }

    public void clickEditAccountRight() {
        getEditAccountRight().click();
    }

    // passwordRight
    public WebElement getPasswordRight() {
        return passwordRight;
    }

    public String getPasswordRightText() {
        return getPasswordRight().getText();
    }

    public void clickPasswordRight() {
        getPasswordRight().click();
    }

    // logoutRight
    public WebElement getLogoutRight() {
        return logoutRight;
    }

    public String getLogoutRightText() {
        return getLogoutRight().getText();
    }

    public void clickLogoutRight() {
        getLogoutRight().click();
    }

    // Functional

    // Business Logic

    public EditAccountPage gotoEditAccountRight() {
        clickEditAccountRight();
        return new EditAccountPage(driver);
    }

    public AccountLogoutPage gotoLogoutRight() {
        clickLogoutRight();
        return new AccountLogoutPage(driver);
    }

    public MyAccountPage gotoMyAccountRight() {
        clickMyAccountRight();
        return new MyAccountPage(driver);
    }

}
