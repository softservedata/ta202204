package com.softserve.edu;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartAppleCinemaTest {
    private final String ADD_TO_CART_BUTTON_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
    private final String ADD_TO_CART_BY_STARTS_WITH = "//a[starts-with(.,'%s')]/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
    //
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private static WebDriver driver;

    private static void presentationSleep() {
        presentationSleep(1);
    }

    private static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    //@BeforeClass
    public static void beforeClassHtmlUnitDriver() {
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        //
        driver = new HtmlUnitDriver(true);
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }
    
    // Download from http://phantomjs.org/download.html
    // Download from phantomjsdriver-1.4.4.jar
    //@BeforeClass
    public static void beforeClasssPhantomJs() {
        //WebDriverManager.phantomjs().setup();
        System.setProperty("phantomjs.binary.path", "C:\\Users\\yharasym\\.cache\\selenium\\phantomjs\\win64\\2.1.1\\phantomjs.exe");
        // driver = new ChromeDriver();
        //
        driver = new PhantomJSDriver();
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        driver.quit(); // Close browser and stop server
    }

    @Before
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    //@Test
    public void testSearch() {
        //
        // Choose Curency
        System.out.println("Choose Curency");
        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        presentationSleep(); // For Presentation ONLY
        driver.findElement(By.cssSelector("button[name='USD']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Steps
        System.out.println("Steps");
        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
        presentationSleep(); // For Presentation ONLY
        //
        // Search Button Click
        System.out.println("Search Button Click");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        System.out.println("Check");
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
        presentationSleep(); // For Presentation ONLY
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", price);
        presentationSleep(); // For Presentation ONLY
        Assert.assertTrue(price.getText().contains("$602.00"));
        System.out.println("***contains: " + price.getText());
        presentationSleep(); // For Presentation ONLY
        //
    }
    
    @Test
    public void addToCartAppleCinema() throws Exception {
        // Precondition
        //
        // Steps
        // Type Search Field
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Apple Cinema");
        Thread.sleep(1000); // For Presentation Only
        //
        // Click Search Button
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Add to cart MacBook
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BY_STARTS_WITH, "Apple Cinema"))).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Choose Medium
        driver.findElement(By.xpath("//div[@id='product']//div[@class='radio']/label[text()[contains(., 'Medium')]]")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Choose Checkbox 2
        driver.findElement(By.xpath("//div[@id='product']//div[@class='checkbox']/label[text()[contains(., 'Checkbox 2')]]")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Type Text
        driver.findElement(By.xpath("//input[@placeholder='Text']")).sendKeys("My Text");
        Thread.sleep(1000); // For Presentation Only
        //
        // Open Select
        driver.findElement(By.xpath("//select")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Choose Red
        driver.findElement(By.xpath("//option[starts-with(.,'Red')]")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Type Text
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea']")).sendKeys("Area Text");
        Thread.sleep(1000); // For Presentation Only
        //
        String filename = System.getenv().get("USERPROFILE") + "/Downloads/MyUpload.png";
        //System.out.println("filename = " + filename);
        //filename = System.getenv("USERPROFILE") + "/Downloads/MyUpload.txt";
        //System.out.println("filename2 = " + filename);
        //
        // Choose File
        // Search By XPath $x("//button[starts-with(@id,'button-upload')]/input")
        // d5259ffed2a1f884149ec29af8c7b669c59dee5d
        //driver.findElement(By.xpath("//button[starts-with(@id,'button-upload')]/following-sibling::input")).sendKeys(filename);
        WebElement uploadInput = driver.findElement(By.xpath("//button[starts-with(@id,'button-upload')]/following-sibling::input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", 
                uploadInput, "value", "d5259ffed2a1f884149ec29af8c7b669c59dee5d");
        Thread.sleep(1000); // For Presentation Only
        System.out.println("***value = " + uploadInput.getAttribute("value"));
        //
        // Type Date
        driver.findElement(By.xpath("//div[@class='input-group date']/input")).click();
        driver.findElement(By.xpath("//div[@class='input-group date']/input")).clear();
        driver.findElement(By.xpath("//div[@class='input-group date']/input")).sendKeys("2019-12-19");
        Thread.sleep(1000); // For Presentation Only
        //
        // Type Time
        driver.findElement(By.xpath("//div[@class='input-group time']/input")).click();
        driver.findElement(By.xpath("//div[@class='input-group time']/input")).clear();
        driver.findElement(By.xpath("//div[@class='input-group time']/input")).sendKeys("11:50");
        Thread.sleep(1000); // For Presentation Only
        //
        // Type Date-Time
        driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).click();
        driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).clear();
        driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).sendKeys("2019-12-19 11:50");
        Thread.sleep(1000); // For Presentation Only
        //
        // Type quantity
        driver.findElement(By.id("input-quantity")).click();
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys("5");
        Thread.sleep(1000); // For Presentation Only
        //
        // Click Add to Cart Button
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(10000); // For Presentation Only
        //
        //
        // Check
        WebElement alertMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertTrue(alertMessage.getText().contains("Success: You have added"));
        Thread.sleep(1000); // For Presentation Only
        //
        
        /*
        //
        // Goto Cart
        driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href, 'checkout/cart')]")).click();
        //
        // Check
        WebElement quantity = driver.findElement(By.xpath("//div[@id='content']//a[text()='MacBook']/../following-sibling::td//input"));
        Assert.assertEquals("2", quantity.getAttribute("value"));
        //
        // Return to Previous State
        driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
        Thread.sleep(1000); // For Presentation Only
        */
    }

}

