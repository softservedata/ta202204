package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountLogoutPage extends AccountSidebarGuestPart {

    private WebElement continueButton;
    
    protected Search search;

    public AccountLogoutPage(WebDriver driver) {
        super(driver);
        initElements();
        search = SearchStrategy.getSearch();
        //ApplicationStatus.get().setLogged(false);
    }

    private void initElements() {
        continueButton = search.cssSelector("a.btn.btn-primary[href*='common/home']");
        //continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary[href*='common/home']"));
    }

    // Page Object

    // continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional

    // Business Logic

    public HomePage gotoContinue() {
        clickContinueButton();
        return new HomePage(driver);
    }

}
