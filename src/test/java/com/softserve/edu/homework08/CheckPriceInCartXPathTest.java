package com.softserve.edu.homework08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class CheckPriceInCartXPathTest {

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
        driver.findElement(By.xpath("//*[@id='form-currency']/div/button")).click();
        driver.findElement(By.name("USD")).click();
    }

    //Search product on the site
    private WebElement getItemByName(String name){
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        WebElement result = null;
        List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'product-layout')]"));
        for (WebElement current : products) {
            if (current.findElement(By.xpath(".//a[text()]")).getText().equals(name)); {
                result = current;
                break;
            }
        }
        return result;
    }

    public void addItemToCart(String name){
        WebElement addMacToCart = getItemByName(name);
        addMacToCart.findElement(By.xpath(".//button[@type='button']")).click();
        presentationSleep();
    }

    public WebElement checkProductsInCart(String name) {
        WebElement product = null;

        //Open shopping cart
        driver.findElement(By.xpath("//div[@id = 'cart']")).click();
        driver.findElement(By.xpath("//ul[@class ='dropdown-menu pull-right']//a[contains(@href, 'checkout/cart')]")).click();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'table-responsive']//tbody//tr"));

        if (products.size() == 0) {
            throw new RuntimeException();
        }

        for (WebElement current : products) {
            if (current.findElement(By.xpath(".//a[text()]")).getText().equals(name)) {
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
            product.findElement(By.xpath(".//input[@class = 'form-control']")).click();
            product.findElement(By.xpath(".//input[@class = 'form-control']")).clear();
            product.findElement(By.xpath(".//input[@class = 'form-control']")).sendKeys(number);
            product.findElement(By.xpath(".//button[@type = 'submit']")).click();
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
            priceInString = item.findElement(By.xpath("(.//td[@class = 'text-right'])[last()-1]")).getText();
            priceInString = priceInString.replace("$", "");
            priceInString = priceInString.replace(",", "");
            priceForUnit = Double.parseDouble(priceInString);

            System.out.println("Price for unit " + priceForUnit);

            expected = priceForUnit * quantity;

            //*** Verify total price
            totalPriceInString = item.findElement(By.xpath("(.//td[@class = 'text-right'])[last()]")).getText();
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
        this.addItemToCart("MacBook");
        this.addItemToCart("iPhone 3");
        this.changeAmount("2", "iPhone 3");
        this.changeAmount("3", "MacBook");
        this.checkTotalPrice("iPhone 3", 2);
        this.checkTotalPrice("MacBook", 3);
    }


}
