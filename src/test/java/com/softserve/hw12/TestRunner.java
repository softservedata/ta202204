package com.softserve.hw12;

import com.opencart.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class TestRunner {
    private final String EXPECTED = "£368.73";
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    protected HomePage loadApplication() {
        return new HomePage(driver);
    }

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
