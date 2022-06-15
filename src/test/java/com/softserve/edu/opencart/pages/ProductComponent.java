package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class ProductComponent {

    private WebElement productLayout;
    //
    protected Search search;
    //
    private WebElement name;
    private WebElement partialDescription;
    private WebElement price;
    private WebElement addToCartButton;
    private WebElement addToWishButton;
    private WebElement addToCompareButton;

    public ProductComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        search = SearchStrategy.getSearch();
        initElements();
    }
    
    private void initElements() {
//    	name = productLayout.findElement(By.cssSelector("h4 a"));
//    	partialDescription = productLayout.findElement(By.cssSelector("h4 + p"));
//    	price = productLayout.findElement(By.cssSelector(".price"));
//    	addToCartButton = productLayout.findElement(By.cssSelector(".button-group .fa.fa-shopping-cart"));
//    	addToWishButton = productLayout.findElement(By.cssSelector("button > .fa.fa-heart"));
//    	addToCompareButton = productLayout.findElement(By.cssSelector(".fa.fa-exchange"));
    	
    	name = search.cssSelector("h4 a", productLayout);
    	partialDescription = search.cssSelector("h4 + p", productLayout);
    	price = search.cssSelector(".price", productLayout);
    	addToCartButton = search.cssSelector(".button-group .fa.fa-shopping-cart", productLayout);
    	addToWishButton = search.cssSelector("button > .fa.fa-heart", productLayout);
    	addToCompareButton = search.cssSelector(".fa.fa-exchange", productLayout);
    }
    
    // Page Object
    // name
    protected WebElement getName() {
    	return name;
    }
    
    protected String getNameText() {
    	return getName().getText();
    }
    
    protected void clickName() {
    	getName().click();
    }
    
    // partialDescription
    private WebElement getPartialDescription() {
    	return partialDescription;
    }
    
    protected String getPartialDescriptionText() {
    	return getPartialDescription().getText();
    }
    
    // price
    private WebElement getPrice() {
    	return price;
    }
    
    protected String getPriceText() {
    	return getPrice().getText();
    }
    
    // addToCartButton
    private WebElement getAddToCartButton() {
    	return addToCartButton;
    }
    
    protected String getAddToCartButtonText() {
    	return getAddToCartButton().getText();
    }
    
    public void clickAddToCartButton() {
    	addToCartButton.click();
    }
    
    // addToWishButton
    private WebElement getAddToWishButton() {
    	return addToWishButton;
    }
    
    protected void clickAddToWishButton() {
    	getAddToWishButton().click();
    }
    
    // addToCompareButton
    private WebElement getAddToCompareButton() {
    	return addToCompareButton;
    }
    
    protected void clickAddToCompareButton() {
    	getAddToCompareButton().click();
    }

    // Functional

    // Business Logic

}
