package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class MyAccountPage extends AccountSidebarLoggedPart {

	protected Search search;
	
    // public MyAccountPage(WebDriver driver) {
	public MyAccountPage() {
        // super(driver);
		super();
		search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

}