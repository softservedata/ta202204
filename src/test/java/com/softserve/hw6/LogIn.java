package com.softserve.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogIn {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    //private WebDriver;

    private static void presentationSleep() {
        presentationSleep(1);
    }

    private static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*- @BeforeAll
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
    }
    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }
    @AfterEach
    public void afterClass() {
        if (driver != null) {
            driver.quit(); // close()
        }
    }
    */
    @Test
    public void testLogIn() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
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
        driver.quit();
    }
}
