package com.softserve.hw8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddMacBookandIphone32 {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    @Test
    public void testAddMacBookAndIphone32() throws InterruptedException{
        driver.navigate().to(BASE_URL);

        driver.findElement(By.xpath("//form[@id=\"form-currency\"]")).click();
        driver.findElement(By.xpath("//button[@name=\"USD\"]")).click();

        driver.findElement(By.xpath("//div[@class='product-thumb transition']//a[text()='MacBook']/../../..//i[@class='fa fa-shopping-cart']")).click();
        driver.findElement(By.xpath("//div[@class='product-thumb transition']//a[text()='iPhone 3']/../../..//i[@class='fa fa-shopping-cart']")).click();

        WebElement cartButton = driver.findElement(By.xpath("//div[@id='cart']/button"));
        Thread.sleep(1000);
        Assertions.assertEquals("2 item(s) - $725.20", cartButton.getText());
        System.out.println("What was inside my basket when after added MacBook and iPhone 3 - " + cartButton.getText());

        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

        WebElement phoneQt = driver.findElement(By.xpath("//div[@class=\"table-responsive\"]//tr//td[@class=\"text-left\"]//a[text()='iPhone 3']/../..//input[@type=\"text\"]"));
        phoneQt.click();
        phoneQt.clear();
        phoneQt.sendKeys("2");

        driver.findElement(By.xpath("//tr[contains(., 'iPhone 3')]//button[@data-original-title='Update']")).click();

        WebElement macBookQt = driver.findElement(By.xpath("//div[@class=\"table-responsive\"]//tr//td[@class=\"text-left\"]//a[text()='MacBook']/../..//input[@type=\"text\"]"));
        macBookQt.click();
        macBookQt.clear();
        macBookQt.sendKeys("3");

        driver.findElement(By.xpath("//tr[contains(., 'MacBook')]//button[@data-original-title='Update']")).click();

        WebElement total = driver.findElement(By.xpath("//table[@class='table table-bordered']//strong[starts-with(text(),'Total:')]/../following-sibling::td"));
        Assertions.assertTrue(total.getText().contains("$2,052.40"));
        System.out.println("How much do you want to charge me after I change amounts of items - " + total.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void end() {
        System.out.println("Test ended");
    }
}
