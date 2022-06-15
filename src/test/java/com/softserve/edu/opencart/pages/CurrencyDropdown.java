package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class CurrencyDropdown {

	//private WebDriver driver;
	protected Search search;
    //
    private WebElement selectCurrency;

    //public CurrencyDropdown(WebDriver driver, String currency) {
    public CurrencyDropdown(String currency) {
        //this.driver = driver;
    	search = SearchStrategy.getSearch();
        initElements(currency);
    }

    private void initElements(String currency) {
    	selectCurrency = search.name(currency);
    }

    // Page Object

    // selectCurrency
    public WebElement getSelectCurrency() {
        return selectCurrency;
    }

    public String getSelectCurrencyText() {
        return getSelectCurrency().getText();
    }

    public void clickSelectCurrency() {
    	getSelectCurrency().click();
    }

    // Functional

    // Business Logic

}
