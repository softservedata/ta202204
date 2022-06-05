package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebDriver;

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
        //initElements();
    }
}
