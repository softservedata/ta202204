package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    
    public void initElements() {
        setProductComponents();
    }

    public void setProductComponents() {
        productComponents = new ArrayList<>();
        for (WebElement product : driver.findElements(By.xpath("//div[@class=\"product-thumb transition\"]"))) {
            productComponents.add(new ProductComponent(product));
        }
    }
    
    public boolean checkProductIsDisplayed(String productName) {
    boolean result = true;
        for (int i = 0; i < productComponents.size(); i++) {
            String tmp = productComponents.get(i).getName().getText();
            if (productComponents.get(i).getName().getText().contains(productName)) {
                result = true;
                break;
            } else result = false;
        }
        return result;
    }
    
}
