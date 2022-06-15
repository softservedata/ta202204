package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public abstract class AccountSidebarLoggedPart extends AccountSidebarPart {

	protected Search search;
	
    private WebElement editAccountRight;
    private WebElement passwordRight;
    private WebElement logoutRight;

    // public AccountSidebarLoggedPart(WebDriver driver) {
    public AccountSidebarLoggedPart() {
        // super(driver);
    	super();
    	search = SearchStrategy.getSearch();
        initElements();
        //ApplicationStatus.get().setLogged(true);
    }

    private void initElements() {
        // init elements
//        editAccountRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/edit')]"));
//        passwordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/password')]"));
//        logoutRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/logout')]"));
    	
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
        // return new EditAccountPage(driver);
        return new EditAccountPage();
    }

    public AccountLogoutPage gotoLogoutRight() {
        clickLogoutRight();
        // return new AccountLogoutPage(driver);
        return new AccountLogoutPage();
    }

    public MyAccountPage gotoMyAccountRight() {
        clickMyAccountRight();
        // return new MyAccountPage(driver);
        return new MyAccountPage();
    }

}
