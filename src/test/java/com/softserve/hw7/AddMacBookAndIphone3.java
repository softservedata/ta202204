package com.softserve.hw7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddMacBookAndIphone3 {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    //private Actions actions;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        //actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testAddMacBookAndIphone3() throws InterruptedException{
        driver.navigate().to(BASE_URL);

        driver.findElement(By.cssSelector("#form-currency")).click();
        driver.findElement(By.cssSelector("button[name='USD']")).click();

        driver.findElement(By.cssSelector("div#content button[onclick*='43']")).click();
        driver.findElement(By.cssSelector("div#content button[onclick*='40']")).click();

        WebElement cartButton = driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle"));
        Thread.sleep(1000);
        Assertions.assertEquals("2 item(s) - $725.20", cartButton.getText());
        System.out.println("What was inside my basket when I added MacBook and iPhone 3 - " + cartButton.getText());

        driver.findElement(By.cssSelector("#top-links a[href*='checkout/cart']")).click();

        WebElement phoneQt = driver.findElement(By.cssSelector("table tr:nth-child(1) td:nth-child(4) input[type='text']"));
        phoneQt.click();
        phoneQt.clear();
        phoneQt.sendKeys("2");

        driver.findElement(By.cssSelector("table tr:nth-child(1) td:nth-child(4) button[type='submit']")).click();

        WebElement macBookQt = driver.findElement(By.cssSelector("table tr:nth-child(2) td:nth-child(4) input[type='text']"));
        macBookQt.click();
        macBookQt.clear();
        macBookQt.sendKeys("3");

        driver.findElement(By.cssSelector("table tr:nth-child(2) td:nth-child(4) button[type='submit']")).click();

        WebElement total = driver.findElement(By.cssSelector("div.col-sm-4.col-sm-offset-8>table.table.table-bordered tr:last-child>td:last-child"));
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
