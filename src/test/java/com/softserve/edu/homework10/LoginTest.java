package com.softserve.edu.homework10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LoginTest {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;

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

    @DataProvider
    public Object[][] ValidLoginData(){
        return new Object[][]
                {
                        { "hahaha@gmail.com ", "qwerty" },
                };
    }

    @BeforeTest
    public void setBrowser(String browser) {
        if(browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
            driver.manage().window().maximize();
        } else if(browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
            driver.manage().window().maximize();
        }

    }

    @Test (dataProvider = "ValidLoginData")
    public void testLogin(String email, String password) {

        //setBrowser("Chrome");
        setBrowser("Firefox");

        driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();
        driver.findElement(By.cssSelector("#top-links a[href*='route=account/login']")).click();

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(email);

        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);

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
