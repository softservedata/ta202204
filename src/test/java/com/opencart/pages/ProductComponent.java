package com.opencart.pages;

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
        //initElements();
    }
}