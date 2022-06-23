package com.softserve.homework10;

/*Homework 10 (from 20.05.2022)
        Модифікувати тестовий метод завдання 6.
        Додати параметром тесту об'єкт, який буде запускати браузер (достатньо використати Firefox та Chrome).
        Скористатися @DataProvider (наприклад, див. клас com.softserve.testng.CharUtilsTest)
Умова завдання 6.
        1) Зайти на сайт http://taqc-opencart.epizy.com/
        Залогуватися. E-Mail Address: hahaha@gmail.com та Password: qwerty
        Клікнути на кнопку Login.
        Перевірити, чи ми дійсно залогувалися.
        Для коду використати пакет com.softserve.homework10
        Запушати код на github у свою вітку.*/


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class additionalBrowser {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private static void presentationSleep() {
        presentationSleep(1);
    }

    private static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

    }


    @BeforeClass
    public void beforeClass() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
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

    @DataProvider
    public Object[][] TestData(){
        return new Object[][]
                {
                        { "hahaha@gmail.com ", "qwerty" },
                };
    }

    @Test (dataProvider = "TestData")
    public void authorization(String email, String password) {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector("#top-links a[href*='route=account/login']")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(email, Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password, Keys.ARROW_LEFT);
        driver.findElement(By.cssSelector("form > input.btn.btn-primary")).click();
        WebElement logout = driver.findElement(By.cssSelector("#column-right a[href*='route=account/logout']"));
        Assert.assertTrue(logout.getText().contains("Logout"));
    }
}