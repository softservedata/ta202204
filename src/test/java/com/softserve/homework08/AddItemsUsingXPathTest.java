package com.softserve.homework08;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class AddItemsUsingXPathTest {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;

    private void pause(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addTwoTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // adding macbook to cart
        driver.get("http://taqc-opencart.epizy.com/");
        driver.findElement(By.xpath("//form[@id='form-currency']")).click();
        driver.findElement(By.xpath("//button[@name='USD']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("macbook");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        driver.findElement(By.xpath("//div[@class='product-thumb']//div[@class='caption']/h4[a[text()='MacBook']]/../following-sibling::div[@class='button-group']//i[@class='fa fa-shopping-cart']")).click();
        // asserting MacBook is added
        pause(2);
        WebElement cartMac = driver.findElement(By.xpath("//span[@id='cart-total']"));
        Assert.assertTrue(cartMac.getText().contains("1 item(s)"));
        // adding iPhone to cart
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone 3");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        driver.findElement(By.xpath("//div[@class='product-thumb']//div[@class='caption']/h4[a[text()='iPhone 3']]/../following-sibling::div[@class='button-group']//i[@class='fa fa-shopping-cart']")).click();
        // asserting 2 items are added
        pause(1);
        WebElement cartIphone = driver.findElement(By.xpath("//span[@id='cart-total']"));
        Assert.assertTrue(cartIphone.getText().contains("2 item(s)"));
        // Changing cart quantities to iPhone
        driver.findElement(By.xpath("//div[@id='cart']/button")).click();
        driver.findElement(By.xpath("//p[@class='text-right']//i[@class='fa fa-shopping-cart']")).click();
        List<WebElement> items = driver.findElements(By.xpath("//form//tbody/tr"));
        if (items.size() == 0) {
            throw new RuntimeException("elements not in the cart");
        }
        WebElement iphoneInCart = null;
        for (WebElement el: items) {
            if (el.getText().contains("iPhone 3")) {
                iphoneInCart = el;
                break;
            }
        }
        // saving iPhone price to a var
        List<WebElement> tdIPhoneInCart = iphoneInCart.findElements(By.xpath("./td[@class='text-right']"));
        String priceIphone = tdIPhoneInCart.get(tdIPhoneInCart.size()-1).getText();
        double iPhonePrice = Double.parseDouble(priceIphone.substring(1));
        System.out.println("price for 1 iphone: " + iPhonePrice);
                // Changing quantity
        iphoneInCart.findElement(By.xpath(".//input[@class='form-control']")).click();
        iphoneInCart.findElement(By.xpath(".//input[@class='form-control']")).clear();
        iphoneInCart.findElement(By.xpath(".//input[@class='form-control']")).sendKeys("2");
        iphoneInCart.findElement(By.xpath(".//i[@class='fa fa-refresh']")).click();
        // updating macbook
        List<WebElement> items2 = driver.findElements(By.xpath("//form//tbody/tr"));
        if (items2.size() == 0) {
            throw new RuntimeException("elements not in the cart");
        }
        WebElement macInCart = null;
        for (WebElement el: items2) {
            if (el.getText().contains("MacBook")) {
                macInCart = el;
                break;
            }
        }
        // saving mac price to a var
        List<WebElement> tdMacBookInCart = macInCart.findElements(By.xpath("./td[@class='text-right']"));
        String priceMacBook = tdMacBookInCart.get(tdMacBookInCart.size()-1).getText();
        double macPrice = Double.parseDouble(priceMacBook.substring(1));
        System.out.println("price for 1 macbook: "+ macPrice);
        // Changing MacBook quantity
        macInCart.findElement(By.xpath(".//input[@class='form-control']")).click();
        macInCart.findElement(By.xpath(".//input[@class='form-control']")).clear();
        macInCart.findElement(By.xpath(".//input[@class='form-control']")).sendKeys("3");
        macInCart.findElement(By.xpath(".//i[@class='fa fa-refresh']")).click();

        // getting amounts after quantities updated
        List<WebElement> itemsUpdated = driver.findElements(By.xpath("//form//tbody/tr"));
        if (itemsUpdated.size() == 0) {
            throw new RuntimeException("elements not in the cart");
        }
        WebElement iphoneInCartUpdated = null;
        WebElement macInCartUpdated = null;
        for (WebElement el: itemsUpdated) {
            if (el.getText().contains("iPhone 3")) {
                iphoneInCartUpdated = el;
            }
            if (el.getText().contains("MacBook")) {
                macInCartUpdated = el;
            }
        }
        // getting totals
        List<WebElement> totalsIPhone = iphoneInCartUpdated.findElements(By.xpath("./td"));
        String iPhoneTotal = totalsIPhone.get(totalsIPhone.size()-1).getText();
        double iphoneTotal = Double.parseDouble(iPhoneTotal.substring(1));
        System.out.println("total for iPhones: " + iphoneTotal);
        //
        List<WebElement> totalsMac = macInCartUpdated.findElements(By.xpath("./td"));
        String macTotals = totalsMac.get(totalsMac.size()-1).getText();
        System.out.println("total for MacBooks: " + macTotals);
        // dropping ',' symbol
        String macTotalsNoCommas = macTotals.substring(1).replace(",", "");
        double macTotal = Double.parseDouble(macTotalsNoCommas);
        System.out.println("new total for macs : " + macTotal);

        // getting quantities
        double quantityIphone = Double.parseDouble(iphoneInCartUpdated.findElement(By.xpath(".//input[@class='form-control']")).getAttribute("value"));
        System.out.println("quantity iphones: "+ quantityIphone);
        double quantityMac = Double.parseDouble(macInCartUpdated.findElement(By.xpath(".//input[@class='form-control']")).getAttribute("value"));
        System.out.println("quantity macbooks: " + quantityMac);

        //
        Assert.assertTrue(iPhonePrice*quantityIphone==iphoneTotal);
        Assert.assertTrue(macPrice*quantityMac==macTotal);

        driver.quit();
    }
}
