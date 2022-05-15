package com.softserve.homework07;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartFlow {
    private final WebDriver driver;

    public ShoppingCartFlow(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getElementByProductNameOnCatalogPage(String name){
        WebElement result = null;
        List<WebElement> containers =driver.findElements(By.cssSelector("div.product-layout"));
        for (WebElement current : containers){
            if (current.findElement(By.cssSelector("h4>a")).getText().equals(name)){
                result=current;
                break;
            }
        }
        return result;
    }

    private WebElement getElementByProductNameOnCartPage(String name){
        WebElement result = null;
        List<WebElement> containers =driver.findElements(By.cssSelector(".table-responsive tbody>tr"));
        for (WebElement current : containers){
            if (current.findElement(By.cssSelector("td.text-left>a")).getText().equals(name)){
                result=current;
                break;
            }
        }
        return result;
    }

    public void changeCurrency() {
        driver.findElement(By.cssSelector("#form-currency")).click();
        driver.findElement(By.cssSelector("[name='USD']")).click();
    }

    public void addProductToCart(String name) {
        getElementByProductNameOnCatalogPage(name).findElement(By.cssSelector("i.fa.fa-shopping-cart")).click();
    }

    public void openCartDropDown() {
        driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")).click();
    }

    public String getCardDropDownContent() {
        return driver.findElement(By.cssSelector(".table.table-striped")).getText();
    }

    public void openShoppingCartPage() {
        driver.findElement(By.cssSelector(".text-right i.fa.fa-shopping-cart")).click();
    }

    public void changeCartProductQuantity(String name, int quantity) {
        WebElement quantityInput = getElementByProductNameOnCartPage(name).findElement(By.cssSelector("input[type='text']"));

        quantityInput.click();
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity), Keys.ENTER);
    }

    private double sanitizePrice(String price) {
        price = price.replace("$","");
        price = price.replace(",","");

        return Double.parseDouble(price);
    }

    public double getCartProductPrice(String name) {
        WebElement getPriceIPhone = getElementByProductNameOnCartPage(name).findElement(By.cssSelector("td.text-right"));

        return sanitizePrice(getPriceIPhone.getText());
    }

    public double getTotalPrice() {
        WebElement totalPriceLabel = driver.findElement(By.cssSelector(".col-sm-4.col-sm-offset-8 .table.table-bordered tr:last-child td:last-child"));

        return sanitizePrice(totalPriceLabel.getText());
    }
}
