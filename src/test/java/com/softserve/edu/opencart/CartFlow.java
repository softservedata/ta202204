package com.softserve.edu.opencart;

import com.softserve.edu.utilities.ChromeDriverUtilities;
import com.softserve.edu.utilities.ConvertorUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartFlow {
    public ChromeDriverUtilities driverUtilities;

    public CartFlow(ChromeDriverUtilities driver) {
        this.driverUtilities = driver;
    }

    public void addItemToCart(String productId) {
        WebElement item = this.driverUtilities.findByXpath(
            "//button[contains(@onclick,'" + productId + "')]"
        );
        item.click();
    }

    public void addItemsToCart(String[] itemIDs) {
        for (String itemID : itemIDs) {
            this.addItemToCart(itemID);
        }
    }

    public void openCart() {
        WebElement cartButton = this.driverUtilities.findByXpath("//a[@title='Shopping Cart']");
        cartButton.click();
    }

    public void changeQuantity(String productName, String quantity) {
        List<WebElement> productRows = this.driverUtilities.findAllByXpath(
            "//*[@id=\"content\"]/form/div/table/tbody/tr"
        );
        for (WebElement current : productRows) {
            WebElement productNameElement = current.findElement(By.xpath(".//td[@class='text-left']/a"));
            if (productNameElement.getText().equals(productName)) {
                WebElement productQuantity = current.findElement(By.xpath(".//td[@class='text-left']/div/input[@type='text']"));
                productQuantity.click();
                productQuantity.clear();
                productQuantity.sendKeys(quantity);

                WebElement refreshButton = current.findElement(By.xpath(".//td[@class='text-left']/div/span/button[@type='submit']"));
                refreshButton.click();
                break;
            }
        }
    }

    public String getCartItemText(String productName) {
        List<WebElement> productRows = this.driverUtilities.findAllByXpath(
            "//*[@id=\"content\"]/form/div/table/tbody/tr"
        );
        for (WebElement current : productRows) {
            WebElement productNameElement = current.findElement(By.xpath(".//td[@class='text-left']/a"));
            String foundName = productNameElement.getText();
            if (foundName.equals(productName)) {
                return foundName;
            }
        }

        return "";
    }

    public double getCartTotalPrice() {
        double totalPrice = 0.0;
        List<WebElement> productRows = this.driverUtilities.findAllByXpath(
            "//*[@id=\"content\"]/form/div/table/tbody/tr"
        );
        for (WebElement current : productRows) {
            WebElement productPriceElement = current.findElement(By.xpath(".//td[5]"));
            WebElement productQuantityElement = current.findElement(By.xpath(".//td[@class='text-left']/div/input[@type='text']"));
            double productPrice = ConvertorUtilities.convertStringToPrice(productPriceElement.getText());
            double productQuantity = Double.parseDouble(productQuantityElement.getAttribute("value"));

            totalPrice = totalPrice + (productPrice * productQuantity);
        }

        return totalPrice;
    }

}
