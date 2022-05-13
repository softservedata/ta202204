package com.softserve.homework06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyLoginTest {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private final String baseURL = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.navigate().to(baseURL);
    }

    @Test
    public void checkLogin() {

        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.name("email")).sendKeys("hahaha@gmail.com");
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        WebElement myAccount = driver.findElement(By.xpath("//div[@class=\"list-group\"]"));
        Assert.assertTrue(myAccount.getText().contains("Logout"));
    }

    @AfterClass
    public void afterClass() {
        driver.findElement(By.xpath("//div[@class=\"list-group\"]//a[text()='Logout']")).click();
        driver.quit();
    }
}
