package com.softserve.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogIn {
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
    public void testLogIn() {
        driver.navigate().to(BASE_URL);
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).click();
        driver.findElement(By.id("input-email")).sendKeys("hahaha@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("form input.btn.btn-primary")).click();
        driver.findElement(By.cssSelector("a[title='My Account']")).click();

        WebElement logout = driver.findElement(By.cssSelector("div#top-links a[href*='route=account/logout']"));
        Assertions.assertTrue(logout.getText().contains("Logout"));
        System.out.println("If I'm Login, so I can " + logout.getText());
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