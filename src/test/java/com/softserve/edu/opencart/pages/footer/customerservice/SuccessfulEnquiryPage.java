package com.softserve.edu.opencart.pages.footer.customerservice;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class SuccessfulEnquiryPage {
	
	public static final String EXPECTED_MESSAGE = "Your enquiry has been successfully sent to the store owner!";
    
    protected Search search;
    //
    private WebElement successMessage;
    private WebElement continueButton;

    // public SuccessfulRegistrationPage(WebDriver driver) {
    public SuccessfulEnquiryPage() {
        // super(driver);
    	search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
//    	successMessage = driver.findElement(By.cssSelector("#content>h1"));
//    	continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
    	
    	successMessage = search.cssSelector("#content>p");
    	continueButton = search.cssSelector(".btn.btn-primary");
    }

    // Page Object

    // alert
    protected WebElement getSuccessMessage() {
        return successMessage;
    }

    public String getSuccessMessageText() {
        return getSuccessMessage().getText();
    }
    
    // continueButton
    private WebElement getContinueButton() {
    	return continueButton;
    }
    
    private void clickContinueButton() {
    	getContinueButton().click();
    }

    // Functional

    // Business Logic
    
	public HomePage gotoContinue() {
		clickContinueButton();
		return new HomePage();
	}

}
