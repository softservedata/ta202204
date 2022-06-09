package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsContainerMy {
    public final String productNotFound = "There is no product that matches the search criteria: ";
    private final String productComponentCssSelector = ".product-layout";

    protected WebDriver driver;
    private List<ProductComponentMy> productComponents;

    public ProductsContainerMy(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        this.productComponents = new ArrayList<>();
        List<WebElement> productsLayout = driver.findElements(By.cssSelector(productComponentCssSelector));
        for (WebElement current : productsLayout) {
            this.productComponents.add(new ProductComponentMy(current));
        }
    }

    public List<ProductComponentMy> getProductComponents() {
        return this.productComponents;
    }

    public ProductComponentMy getProductComponentsByName(String productName) throws RuntimeException {
        for (ProductComponentMy current : this.getProductComponents()) {
            String currentName = current.getNameText().toLowerCase();
            String foundName = productName.toLowerCase();

            if (currentName.equals(foundName)) {
                return current;
            }
        }

        throw new RuntimeException(this.productNotFound + productName);
    }
}
