package com.softserve.edu.opencart.pages.footer.customerservice;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class UnsuccessfulEnquiryPage extends ContactUsPage {
	
	public static final String EXPECTED_YOURNAME_ERROR_MESSAGE = "Name must be between 3 and 32 characters!";
	public static final String EXPECTED_EMAIL_ERROR_MESSAGE = "E-Mail Address does not appear to be valid!";
	public static final String EXPECTED_ENQUIRY_ERROR_MESSAGE = "Enquiry must be between 10 and 3000 characters!";

	protected Search search;

	private WebElement errorYourName;
	private WebElement errorEmail;
	private WebElement errorEnquiry;

	// public LoginPage(WebDriver driver) {
	public UnsuccessfulEnquiryPage() {
		// super(driver);
		search = SearchStrategy.getSearch();
		initElements();
	}

	private void initElements() {
		errorYourName = search.cssSelector("#input-name+.text-danger");
		errorEmail = search.cssSelector("#input-email+.text-danger");
		errorEnquiry = search.cssSelector("#input-enquiry+.text-danger");
	}

	// Page Object

	// errorYourName
    protected WebElement getErrorYourName() {
        return errorYourName;
    }

    public String getErrorYourNameText() {
        return getErrorYourName().getText();
    }
    
    // errorEmail
    protected WebElement getErrorEmail() {
        return errorEmail;
    }

    public String getErrorEmailText() {
        return getErrorEmail().getText();
    }
    
    // errorEnquiry
    protected WebElement getErrorEnquiry() {
        return errorEnquiry;
    }

    public String getErrorEnquiryText() {
        return getErrorEnquiry().getText();
    }

	// Functional

	// Business Logic

}
