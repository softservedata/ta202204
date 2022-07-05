package com.softserve.edu.opencart.pages.guest;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class UnsuccessfulRegisterPage extends RegisterPage{
	
	public /*static*/ final String EXPECTED_REGISTER_MESSAGE = "Warning: You must agree to the Privacy Policy!";
    //
	
	protected Search search;
	
    private WebElement alertWarning;

    // public UnsuccessfulRegisterPage(WebDriver driver) {
    public UnsuccessfulRegisterPage() {
        // super(driver);
    	search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // alertWarning = driver.findElement(By.cssSelector(".alert.alert-danger"));
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
