package com.softserve.hw10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LogInSecond {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeAll
    public static void startTest() {
        System.out.println("Start test");
    }

    public void setup(String browser) {
        System.out.println("Setting up the browsers");
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
    }

    @ParameterizedTest
    @MethodSource("browser")
    public void testLogInSecond(String browser) {
        setup(browser);
        driver.navigate().to(BASE_URL);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();

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

    static Stream<Arguments> browser() {
        return Stream.of(
                arguments("Chrome"),
                arguments("Firefox"),
                arguments("Edge")
        );
    }

    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void end() {
        System.out.println("Test ended");
    }
}