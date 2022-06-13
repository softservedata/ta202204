package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AccountSidebarLoggedPart {
    
    protected Search search;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        initElements();
        search = SearchStrategy.getSearch();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

}
