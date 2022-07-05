package com.softserve.edu.opencart.pages.footer.customerservice;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.TopPart;
import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class PrivacyPolicyPage extends TopPart {
	    
	    protected Search search;
	    //
	    private WebElement pageTitle;

	    // public SuccessfulRegistrationPage(WebDriver driver) {
	    public PrivacyPolicyPage() {
	    	search = SearchStrategy.getSearch();
	        initElements();
	    }

	    private void initElements() {
	    	pageTitle = search.id("content");
	    }

	    // Page Object

	    // alert
	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public String getPageTitleText() {
	        return getPageTitle().getText();
	    }

	    // Functional

	    // Business Logic

}
