package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class SuccessfulRegistrationPage extends AccountSidebarLoggedPart {
	
    public static final String EXPECTED_REGISTRATION_MESSAGE = "Your Account Has Been Created!";
    
    protected Search search;
    //
    private WebElement successMessage;
    private WebElement continueButton;

    // public SuccessfulRegistrationPage(WebDriver driver) {
    public SuccessfulRegistrationPage() {
        // super(driver);
    	super();
    	search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
//    	successMessage = driver.findElement(By.cssSelector("#content>h1"));
//    	continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
    	
    	successMessage = search.cssSelector("#content>h1");
    	continueButton = search.cssSelector(".btn.btn-primary");
    }

    // Page Object

    // alert
    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public String getSuccessMessageText() {
        return getSuccessMessage().getText();
    }
    
    private WebElement getContinueButton() {
    	return continueButton;
    }
    
    private void clickContinueButton() {
    	getContinueButton().click();
    }

    // Functional

    // Business Logic
    
	public MyAccountPage gotoContinue() {
		clickContinueButton();
		// fillLogin(email, password);
		// return new MyAccountPage(driver);
		return new MyAccountPage();
	}
    


}
