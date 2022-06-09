package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponentMy {
    private WebElement productLayout;
    private WebElement name;
    private WebElement partialDescription;
    private WebElement price;

    public ProductComponentMy(WebElement productLayout) {
        this.productLayout = productLayout;
        initElements();
    }

    private void initElements() {
        this.name = productLayout.findElement(By.xpath(".//h4/a"));
        this.partialDescription = productLayout.findElement(By.xpath(".//p[1]"));
        this.price = productLayout.findElement(By.xpath(".//p[@class='price']"));
    }

    public WebElement getName() {
        return this.name;
    }

    public String getNameText() {
        return this.getName().getText();
    }
}
