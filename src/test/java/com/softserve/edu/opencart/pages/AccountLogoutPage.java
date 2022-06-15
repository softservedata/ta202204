package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class AccountLogoutPage extends AccountSidebarGuestPart {

	protected Search search;
	
    private WebElement continueButton;

    // public AccountLogoutPage(WebDriver driver) {
    public AccountLogoutPage() {
        // super(driver);
    	super();
        search = SearchStrategy.getSearch();
        initElements();
        //ApplicationStatus.get().setLogged(false);
    }

    private void initElements() {
        //continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary[href*='common/home']"));
    	continueButton = search.cssSelector("a.btn.btn-primary[href*='common/home']");
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
        // return new HomePage(driver);
        return new HomePage();
    }

}
