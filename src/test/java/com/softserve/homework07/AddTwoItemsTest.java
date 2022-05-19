package com.softserve.homework07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddTwoItemsTest {
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
        driver.findElement(By.cssSelector("div[class='btn-group'] > button[data-toggle='dropdown']")).click();
        driver.findElement(By.cssSelector("button[name='USD']")).click();
        driver.findElement(By.cssSelector("input[name='search']")).click();
        driver.findElement(By.cssSelector("input[name='search']")).clear();
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("macbook");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        WebElement mac = driver.findElement(By.cssSelector("div[class='product-thumb']"));
        if (mac.getText().contains("Intel Core 2 Duo processor Powered")) {
            mac.findElement(By.cssSelector("div[class='product-thumb'] > div[class='image']")).click();
        }
        // asserting MacBook is added
        driver.findElement(By.cssSelector("#button-cart")).click();
        pause(1);
        WebElement cartMac = driver.findElement(By.cssSelector("#cart-total"));
        Assert.assertTrue(cartMac.getText().contains("1 item(s)"));
        // adding iPhone to cart
        driver.findElement(By.cssSelector("input[name='search']")).click();
        driver.findElement(By.cssSelector("input[name='search']")).clear();
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("iphone 3");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        WebElement iphone = driver.findElement(By.cssSelector("div[class='product-thumb']"));
        pause(1);
        if (iphone.getText().contains("iPhone is a revolutionary")) {
            iphone.findElement(By.cssSelector("div[class='product-thumb'] > div[class='image']")).click();
        }
        // asserting 2 items are added
        driver.findElement(By.cssSelector("#button-cart")).click();
        pause(1);
        WebElement cartIphone = driver.findElement(By.cssSelector("#cart-total"));
        Assert.assertTrue(cartIphone.getText().contains("2 item(s)"));
        // Changing cart quantities to iPhone
        driver.findElement(By.cssSelector("a[href*='checkout/cart']>i[class='fa fa-shopping-cart']")).click();
        List<WebElement> items = driver.findElements(By.cssSelector("tr"));
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
        String a = iphoneInCart.findElement(By.cssSelector("td.text-right:last-of-type")).getText();  // find last td ??
        System.out.println("price for 1 iphone: " + a.substring(1));
        double iPhonePrice = Double.parseDouble(a.substring(1));
        // Changing quantity
        iphoneInCart.findElement(By.cssSelector("input.form-control")).click();
        iphoneInCart.findElement(By.cssSelector("input.form-control")).clear();
        iphoneInCart.findElement(By.cssSelector("input.form-control")).sendKeys("2");
        iphoneInCart.findElement(By.cssSelector("i.fa.fa-refresh")).click();
        // Changing cart quantities to MacBook
        List<WebElement> items2 = driver.findElements(By.cssSelector("tr"));
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
        String b = macInCart.findElement(By.cssSelector("td.text-right:last-of-type")).getText(); // last td??
        System.out.println("price for 1 macbook: "+ b.substring(1));
        double macPrice = Double.parseDouble(b.substring(1));
        // Changing quantity
        macInCart.findElement(By.cssSelector("input.form-control")).click();
        macInCart.findElement(By.cssSelector("input.form-control")).clear();
        macInCart.findElement(By.cssSelector("input.form-control")).sendKeys("3");
        macInCart.findElement(By.cssSelector("i.fa.fa-refresh")).click();

        // getting amounts after quantities updated
        List<WebElement> items3 = driver.findElements(By.cssSelector("tr"));
        if (items3.size() == 0) {
            throw new RuntimeException("elements not in the cart");
        }
        WebElement iphoneInCart3 = null;
        WebElement macInCart3 = null;
        for (WebElement el: items3) {
            if (el.getText().contains("iPhone 3")) {
                iphoneInCart3 = el;
            }
            if (el.getText().contains("MacBook")) {
                macInCart3 = el;
            }
        }
        // getting totals
        String c = iphoneInCart3.findElement(By.cssSelector("td.text-right:last-of-type")).getText();
        System.out.println("total for iPhones: " + c.substring(1));
        double iphoneTotal = Double.parseDouble(c.substring(1));
        String d = macInCart3.findElement(By.cssSelector("td.text-right:last-of-type")).getText();
        System.out.println("total for MacBooks: " + d.substring(1));
        // dropping ',' symbol
        String dNew = d.substring(1).replace(",", "");
        System.out.println("new total for macs : " + dNew);
        double macTotal = Double.parseDouble(dNew);
        // getting quantities
        double quantityIphone = Double.parseDouble(iphoneInCart3.findElement(By.cssSelector("input.form-control")).getAttribute("value"));
        System.out.println("quantity iphones: "+ quantityIphone);
        double quantityMac = Double.parseDouble(macInCart3.findElement(By.cssSelector("input.form-control")).getAttribute("value"));
        System.out.println("quantity macbooks: " + quantityMac);
        //
        Assert.assertTrue(iPhonePrice*quantityIphone==iphoneTotal);
        Assert.assertTrue(macPrice*quantityMac==macTotal);

        driver.quit();
    }
}
