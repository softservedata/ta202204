package com.softserve.edu.homework06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LoginTest {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;

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

    @Test
    public void testLogin() {

        driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();
        driver.findElement(By.cssSelector("#top-links a[href*='route=account/login']")).click();

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("hahaha@gmail.com");

        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("qwerty");

        driver.findElement(By.cssSelector("form input.btn.btn-primary")).click();

        driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();
        try {
            WebElement logout = driver.findElement(By.cssSelector("#top-links a[href*='route=account/logout']"));
        }catch(NoSuchElementException logout) {
            logout.printStackTrace();
        }

        driver.quit();

    }
}
