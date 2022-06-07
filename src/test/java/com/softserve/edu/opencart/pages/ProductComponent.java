package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductComponent {
    
    private WebDriver driver;

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
    
    public void initElements() {
        name = productLayout.findElement(By.xpath("//h4/a"));
        partialDescription = productLayout.findElement(By.xpath("//h4/following-sibling::p[1]"));
        price = productLayout.findElement(By.xpath("//p[@class=\"price\"]"));
    }

    public WebElement getName() {
        return name;
    }
    
    public void setName(WebElement name) {
        this.name = name;
    }
}
