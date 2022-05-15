package com.softserve.homework07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class VerifyExpectedAmountTest {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private final String baseURL = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;

    private static void delaySec() {
        delaySec(1);
    }

    private static void delaySec(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.navigate().to(baseURL);
    }

    private WebElement getName (String name){
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

    private WebElement getNameOnCartPAge (String name){
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

        private double changeStringToDouble(String price) {
            price = price.replace("$","");
            price = price.replace(",","");
            return Double.valueOf(price);
        }

    @Test
    public void checkLogin() {
        int quantityIPhone=2;
        int quantityMac=3;
        driver.findElement(By.cssSelector("#form-currency")).click();
        driver.findElement(By.cssSelector("[name='USD']")).click();
        getName("MacBook").findElement(By.cssSelector("i.fa.fa-shopping-cart")).click();
        getName("iPhone 3").findElement(By.cssSelector("i.fa.fa-shopping-cart")).click();
        delaySec();
        driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")).click();
        WebElement itemsInCart = driver.findElement(By.cssSelector(".table.table-striped"));
        Assert.assertTrue(itemsInCart.getText().contains("MacBook")&& itemsInCart.getText().contains("iPhone 3"));
        driver.findElement(By.cssSelector(".text-right i.fa.fa-shopping-cart")).click();
        delaySec();
        getNameOnCartPAge("iPhone 3").findElement(By.cssSelector("input[type='text']")).click();
        getNameOnCartPAge("iPhone 3").findElement(By.cssSelector("input[type='text']")).clear();
        getNameOnCartPAge("iPhone 3").findElement(By.cssSelector("input[type='text']")).sendKeys(String.valueOf(quantityIPhone), Keys.ENTER);
        getNameOnCartPAge("MacBook").findElement(By.cssSelector("input[type='text']")).click();
        getNameOnCartPAge("MacBook").findElement(By.cssSelector("input[type='text']")).clear();
        getNameOnCartPAge("MacBook").findElement(By.cssSelector("input[type='text']")).sendKeys(String.valueOf(quantityMac), Keys.ENTER);
        delaySec();

        WebElement getPriceIPhone = getNameOnCartPAge("iPhone 3").findElement(By.cssSelector("td.text-right"));
        double iphonePrice=changeStringToDouble(getPriceIPhone.getText());
        WebElement getPriceMac = getNameOnCartPAge("MacBook").findElement(By.cssSelector("td.text-right"));
        double macPrice=changeStringToDouble(getPriceMac.getText());
        double totalAmount=(iphonePrice*quantityIPhone)+(macPrice*quantityMac);

        WebElement getTotalPrise = driver.findElement(By.cssSelector(".col-sm-4.col-sm-offset-8 .table.table-bordered tr:last-child td:last-child"));
        double totalPrice = changeStringToDouble(getTotalPrise.getText());

        Assert.assertEquals(totalAmount, totalPrice);
    }

    @AfterClass
    public void afterClass() {
       // driver.manage().deleteAllCookies();
        driver.quit();
    }
}
