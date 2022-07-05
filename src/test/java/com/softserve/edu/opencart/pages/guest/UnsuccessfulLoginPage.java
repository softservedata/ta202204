package com.softserve.edu.opencart.pages.guest;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class UnsuccessfulLoginPage extends LoginPage {

    public static final String EXPECTED_LOGIN_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
    public static final String EXPECTED_LOCK_MESSAGE = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    //
    
    protected Search search;
    
    private WebElement alertWarning;

    // public UnsuccessfulLoginPage(WebDriver driver) {
    public UnsuccessfulLoginPage() {
        // super(driver);
    	search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
//        alertWarning = driver.findElement(By.cssSelector(".alert.alert-danger"));
    	alertWarning = search.cssSelector(".alert.alert-danger");
    }

    // Page Object

    // alertWarning
    public WebElement getAlertWarning() {
        return alertWarning;
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }

    // Functional

    // Business Logic

}
