package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponent {
	
    private WebElement productLayout;
    //
    private WebElement name;
    private WebElement partialDescription;
    private WebElement price;
    private WebElement addToCartButton;
    private WebElement addToWishButton;
    private WebElement addToCompareButton;

    public ProductComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        initElements();
    }
    
    private void initElements() {
    	name = productLayout.findElement(By.cssSelector("h4 a"));
    	partialDescription = productLayout.findElement(By.cssSelector("h4 + p"));
    	price = productLayout.findElement(By.cssSelector(".price"));
    	addToCartButton = productLayout.findElement(By.cssSelector(".button-group .fa.fa-shopping-cart"));
    	addToWishButton = productLayout.findElement(By.cssSelector("button > .fa.fa-heart"));
    	addToCompareButton = productLayout.findElement(By.cssSelector(".fa.fa-exchange"));
    }
    
    // Page Object
    // name
    private WebElement getName() {
    	return name;
    }
    
    protected String getNameText() {
    	return getName().getText();
    }
    
    private void clickName() {
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
    
    private String getAddToCartButtonText() {
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

}