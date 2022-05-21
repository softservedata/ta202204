package com.softserve.homework08;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ShoppingCartFlowByXpath {

    private final WebDriver driver;

    public ShoppingCartFlowByXpath(WebDriver driver) {
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
        List<WebElement> containers =driver.findElements(By.xpath("//div[@class=\"table-responsive\"]//tr"));
        for (WebElement current : containers){
            if (current.findElement(By.xpath("//td[@class=\"text-left\"]//a")).getText().equals(name)){
                result=current;
                break;
            }
        }
        return result;
    }

    public void changeCurrency() {
        driver.findElement(By.xpath("//form[@id=\"form-currency\"]")).click();
        driver.findElement(By.xpath("//button[@name=\"USD\"]")).click();
    }

    public void addMacBookToCart() {
      driver.findElement(By.xpath("//div[@class='product-thumb transition']//a[text()='MacBook']/../../..//i[@class='fa fa-shopping-cart']")).click();
    }

    public void addIPhoneToCart() {
        driver.findElement(By.xpath("//div[@class='product-thumb transition']//a[text()='iPhone 3']/../../..//i[@class='fa fa-shopping-cart']")).click();
    }

    public void openCartDropDown() {
        driver.findElement(By.xpath("//button[@class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();
    }

    public String getCardDropDownContent() {
        return driver.findElement(By.xpath(".//table[@class=\"table table-striped\"]")).getText();
    }

    public void openShoppingCartPage() {
        driver.findElement(By.xpath("//ul[@class=\"dropdown-menu pull-right\"]//i[@class=\"fa fa-shopping-cart\"]")).click();
    }

    public void changeMacBookQuantity(int quantity) {
        WebElement quantityInput = driver.findElement(By.xpath("//div[@class=\"table-responsive\"]//tr//td[@class=\"text-left\"]//a[text()='MacBook']/../..//input[@type=\"text\"]"));

        quantityInput.click();
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity), Keys.ENTER);
    }

    public void changeIPhoneQuantity(int quantity) {
        WebElement quantityInput = driver.findElement(By.xpath("//div[@class=\"table-responsive\"]//tr//td[@class=\"text-left\"]//a[text()='iPhone 3']/../..//input[@type=\"text\"]"));

        quantityInput.click();
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity), Keys.ENTER);
    }

    private double sanitizePrice(String price) {
        price = price.replace("$","");
        price = price.replace(",","");

        return Double.parseDouble(price);
    }

    public double getCartIphonePrice() {
        WebElement getPrice = driver.findElement(By.xpath("//div[@class=\"table-responsive\"]//tr//td[@class=\"text-left\"]//a[text()='iPhone 3']/../..//td[@class=\"text-right\"][1]"));

        return sanitizePrice(getPrice.getText());
    }

    public double getCartMacBookPrice() {
        WebElement getPrice = driver.findElement(By.xpath("//div[@class=\"table-responsive\"]//tr//td[@class=\"text-left\"]//a[text()='MacBook']/../..//td[@class=\"text-right\"][1]"));

        return sanitizePrice(getPrice.getText());
    }

    public double getTotalPrice() {
        WebElement totalPriceLabel = driver.findElement(By.xpath("//div[@class=\"col-sm-4 col-sm-offset-8\"]//tr[last()]//td[last()]"));

        return sanitizePrice(totalPriceLabel.getText());
    }

}
