package com.softserve.edu.homework07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class CheckPriceInCartTest {

    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
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

    public void changeCurrency(){
        driver.findElement(By.cssSelector("#form-currency")).click();
        driver.findElement(By.name("USD")).click();
    }

    //Search product on the site
    private WebElement getItemByName(String name){
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(name);
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        WebElement result = null;
        List<WebElement> products = driver.findElements(By.cssSelector("div.product-layout.product-grid"));
        for (WebElement current : products) {
            if (current.findElement(By.cssSelector("h4 > a")).getText().equals(name)) {
                result = current;
                break;
            }
        }
        return result;
    }

    public void addMacToCart(){
        WebElement addMacToCart = getItemByName("MacBook");
        addMacToCart.click();
        driver.findElement(By.cssSelector("#button-cart")).click();
        presentationSleep();
    }

    public void addIPhoneToCart(){
        WebElement addIPhoneToCart = getItemByName("iPhone 3");
        addIPhoneToCart.click();
        driver.findElement(By.cssSelector("#button-cart")).click();
        presentationSleep();
    }

    //Return WebElement with requested Product name
    public WebElement checkProductsInCart(String name) {
        WebElement product = null;

        //Open shopping cart
        driver.findElement(By.cssSelector("div#top-links a[href*='route=checkout/cart']")).click();

        List<WebElement> products = driver.findElements(By.cssSelector("div.table-responsive tbody tr"));

        if (products.size() == 0) {
            throw new RuntimeException();
        }

        for (WebElement current : products) {
            if (current.findElement(By.cssSelector("tr td.text-left > a")).getText().equals(name)) {
                product = current;
                break;
            }
        }
        return product;
    }

    public void changeAmount(String number, String name) {
        WebElement product = null;

        product = checkProductsInCart(name);

        if (product != null){
            product.findElement(By.cssSelector("td.text-left > div input")).click();
            product.findElement(By.cssSelector("td.text-left > div input")).clear();
            product.findElement(By.cssSelector("td.text-left > div input")).sendKeys(number);
            product.findElement(By.cssSelector("td.text-left button[type=submit]")).click();
        }
    }

    public void checkTotalPrice(String name, int quantity) {
        String priceInString = "";
        double priceForUnit = 0;

        WebElement item = null;
        item = checkProductsInCart(name);

        double expected = 0;
        double totalPrice = 0;
        String totalPriceInString;

        if(item != null) {

            //*** Get price for Unit and parse it to Int
            priceInString = item.findElement(By.cssSelector("td:nth-last-child(2)")).getText();
            priceInString = priceInString.replace("$", "");
            priceInString = priceInString.replace(",", "");
            priceForUnit = Double.parseDouble(priceInString);

            System.out.println("Price for unit " + priceForUnit);

            expected = priceForUnit * quantity;

            //*** Verify total price
            totalPriceInString = item.findElement(By.cssSelector("td:last-of-type")).getText();
            totalPriceInString = totalPriceInString.replace("$", "");
            totalPriceInString = totalPriceInString.replace(",", "");
            totalPrice = Double.parseDouble(totalPriceInString);

            System.out.println("Total price " + totalPrice);

                if (totalPrice == expected) {
                    System.out.println("Price is correct");
                } else System.out.println("Price is wrong");
        }
    }

    @Test
    public void testMethod(){
        this.changeCurrency();
        this.addMacToCart();
        this.addIPhoneToCart();
        this.changeAmount("2", "iPhone 3");
        this.changeAmount("3", "MacBook");
        this.checkTotalPrice("iPhone 3", 2);
        this.checkTotalPrice("MacBook", 3);
    }

}
