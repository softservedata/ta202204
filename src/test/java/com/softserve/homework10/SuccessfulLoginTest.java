package com.softserve.homework10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SuccessfulLoginTest {
    public final String BASE_URL = "http://taqc-opencart.epizy.com/";
    public final long IMPLICITLY_WAIT_SECONDS = 10L;
    public final long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    public void pause (int seconds) {
        try {
            Thread.sleep(seconds*ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @DataProvider
    public Object [][] validData () {
        return new Object[][] {
                {"hahaha@gmail.com", "qwerty"}
        };
    }
    @BeforeSuite
    public void beforeSuite () {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }
    @BeforeClass
    public void beforeClass () {
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterClass () {
        if (driver != null) driver.quit();
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        pause(1);
    }
    @AfterMethod
    public void afterMethod () {
        System.out.println("Test is executed");
    }
    @Test (dataProvider = "validData")
    public void successfullLoginTest (final  String emailAddress, final String password) {
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']")).click();
        driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
        //driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //
        WebElement logout = driver.findElement(By.xpath("//*[@id='column-right']/div[@class='list-group']"));
        Assert.assertTrue(logout.getText().contains("Logout"));
    }
}
