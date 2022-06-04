package com.softserve.edu.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsContainer {
	
    public final String PRODUCT_NOT_FOUND = "There is no product that matches the search criteria.";
    private final String PRODUCT_COMPONENT_CSSSELECTOR = ".product-layout";
    //
    protected WebDriver driver;
    //protected Search search;
    //
    private List<ProductComponent> productComponents;

    public ProductsContainer(WebDriver driver) {
    //public ProductsContainer() {
        this.driver = driver;
        initElements();
    }
    
    private void initElements() {
    	productComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
            productComponents.add(new ProductComponent(current));
        }
    }
    
    // Page Object
    protected List<ProductComponent> getProductComponents() {
    	if(productComponents == null) {
    		throw new RuntimeException(PRODUCT_NOT_FOUND);
    	}
    	return productComponents;
    }
    
    // Functional

    private ProductComponent getProductComponentByName(String productName) {
    	ProductComponent result = null;
    	for(ProductComponent component : getProductComponents()) {
    		if(component.getNameText().toLowerCase().equals(productName.toLowerCase())) {
    			result = component;
    			break;
    		}
    		if(result == null) {
    			throw new RuntimeException("Product" + productName + " has not been found");
    		}
    	}
    	return result;
    }
    
    public boolean isProductComponentPresent(String productName) {
    	boolean result = false;
    	for(ProductComponent component : getProductComponents()) {
    		if(component.getNameText().toLowerCase().equals(productName.toLowerCase())) {
    			result = true;
    			break;
    		}
    	}
    	return result;
    }
    
    
    //
    public String getProductComponentName(String productName) {
    	return getProductComponentByName(productName).getNameText();
    }
    
    public String getProductComponentDescriptionByName(String productName) {
    	return getProductComponentByName(productName).getPartialDescriptionText();
    }
    
    public String getProductComponentPriceByName(String productName) {
    	return getProductComponentByName(productName).getPriceText();
    }
    
    public void clickProductComponentAddToCartButtonByName(String productName) {
    	getProductComponentByName(productName).clickAddToCartButton();
    }
    
    public void clickProductComponentAddToWishButtonByName(String productName) {
    	getProductComponentByName(productName).clickAddToWishButton();
    }
    
    public void clickProductComponentAddToCompareButtonByName(String productName) {
    	getProductComponentByName(productName).clickAddToCompareButton();
    }

}