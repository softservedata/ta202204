package com.softserve.homework07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class CheckingExpectedPrice {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private static void presentationSleep() {
        presentationSleep(2);
    }

    private static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
    }

    private WebElement getProductByName(String name) {
        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys(name);
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        WebElement result = null;
        List<WebElement> containers = driver.findElements(By.cssSelector("div.product-layout.product-grid"));
        for (WebElement current : containers) {
            if (current.findElement(By.cssSelector("h4 > a")).getText().equals(name)) {
                result = current;
                break;
            }
        }
        if (result == null) {
            throw new RuntimeException("WebElement by title/name: " + name + " not found");
        }
        return result;
    }

    public void addMacBookToCart() {
        WebElement addMacBookToCart = getProductByName("MacBook");
        addMacBookToCart.click();
        driver.findElement(By.cssSelector("#button-cart")).click();
    }

    public void addIPhone3ToCart() {
        WebElement addIPhone3ToCart = getProductByName("iPhone 3");
        addIPhone3ToCart.click();
        driver.findElement(By.cssSelector("#button-cart")).click();
    }

    private WebElement getProductByNameFromCart(String name) {
        driver.findElement(By.cssSelector("div#top-links a[href*='route=checkout/cart']")).click();
        WebElement item = null;
        List<WebElement> products = driver.findElements(By.cssSelector("div.table-responsive tbody tr"));

        for (WebElement current : products) {
            if (current.findElement(By.cssSelector("tr td.text-left > a")).getText().contains(name)) {
                item = current;
                break;
            }
        }
        if (products.size() == 0) {
            throw new RuntimeException();
        }
        return item;
    }

    public void changeItemQuality (String name, int quality) {
        WebElement item = null;
        item = getProductByNameFromCart(name);
        if (item != null){
            //item.findElement(By.cssSelector("td.text-left > div input")).click();
            item.findElement(By.cssSelector("td.text-left > div input")).clear();
            item.findElement(By.cssSelector("td.text-left > div input")).sendKeys(Integer.toString(quality) + Keys.TAB + Keys.ENTER);
        }
    }

    @Test
    public void ExpectedPriceInCart() {
        driver.findElement(By.cssSelector("#form-currency")).click();
        driver.findElement(By.cssSelector("button[name='USD']")).click();

        presentationSleep(2);
        addMacBookToCart();
        presentationSleep(2);
        addIPhone3ToCart();
        presentationSleep(2);
        getProductByNameFromCart("MacBook");
        getProductByNameFromCart("iPhone 3");
        presentationSleep(2);
        changeItemQuality("iPhone 3", 2 );
        presentationSleep(2);
        changeItemQuality("MacBook", 3);
        presentationSleep(4);

        WebElement macbookprice = driver.findElement(By.cssSelector("div.table-responsive tbody tr:nth-child(2) > td:nth-child(6)"));
        WebElement iphone3price = driver.findElement(By.cssSelector("div.table-responsive tbody tr:nth-child(1) > td:nth-child(6)"));

        System.out.println("Total of iPhone 3: " + iphone3price.getText());
        System.out.println("Total of Macbook: " + macbookprice.getText());

        Assert.assertTrue(macbookprice.getText().contains("$1,806.00"));
        Assert.assertTrue(iphone3price.getText().contains("$246.40"));
    }
}
