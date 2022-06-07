package com.softserve.homework11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class AddToCartFillFormTest {
    public final String BASE_URL = "http://taqc-opencart.epizy.com/";
    public final long IMPLICITLY_WAIT_SECONDS = 10L;
    public final long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;
    //
    public void pause (int seconds) {
        try {
            Thread.sleep(seconds*ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void scrollUpAfterAddToCart () {
        WebElement topWebsiteSection = driver.findElement(By.cssSelector("i.fa.fa-user"));
        Actions moveUp= new Actions(driver);
        moveUp.moveToElement(topWebsiteSection).perform();
    }
    private void scrollDownCartToOptions () {
        WebElement formAvailableOptions = driver.findElement(By.cssSelector("#product h3"));
        //Actions moveDownCart = new Actions(driver);
        //moveDownCart.moveToElement(availableOptions).perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", formAvailableOptions);
        pause(2);
    }
    private void scrollDownCartToDate () {
        WebElement formDate = driver.findElement(By.xpath("//div[@class='form-group required']/label[text()='Date']"));
        //Actions moveDownCart = new Actions(driver);
        //moveDownCart.moveToElement(availableOptions).perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", formDate);
        pause(2);
    }
    @BeforeSuite
    public void beforeSuite () {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }
    //@AfterClass
    public void afterClass () {
        if (driver != null) driver.quit();
    }
    @BeforeMethod
    public void beforeMethod () {
        driver.get(BASE_URL);
        pause(1);
    }
    @AfterMethod
    public void afterMethod () {
        System.out.println("Test is executed!");
    }

    @Test
    public void addToCartFillFormTest () throws AWTException {
        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("Apple Cinema 30\"");
        driver.findElement(By.cssSelector("#search button.btn.btn-default.btn-lg")).click();
        driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]")).click();
        //
        scrollDownCartToOptions();
        driver.findElement(By.xpath("//input[@value='7']")).click();
        driver.findElement(By.xpath("//input[@value='11']")).click();
        driver.findElement(By.xpath("//label[text()='Text']/following-sibling::input")).click();
        driver.findElement(By.xpath("//label[text()='Text']/following-sibling::input")).clear();
        driver.findElement(By.xpath("//label[text()='Text']/following-sibling::input")).sendKeys("Big One");
        driver.findElement(By.xpath("//label[text()='Select']/following-sibling::select")).click();
        driver.findElement(By.xpath("//label[text()='Select']/following-sibling::select/option[@value='3']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea']")).clear();
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea']")).sendKeys("Testing text 12345");
        driver.findElement(By.id("button-upload222")).click();
        //
        Robot robot = new Robot();
        robot.setAutoDelay(1000);
        StringSelection stringSelection = new StringSelection("C:\\Users\\opyvo\\OneDrive - SoftServe, Inc\\IdeaProjects\\ta202204\\src\\test\\resources\\AppleCinemaFile.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
         */
        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.alertIsPresent());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));

        driver.switchTo().alert().accept();
        //
        scrollDownCartToDate();
        driver.findElement(By.id("input-option219")).click();
        driver.findElement(By.id("input-option219")).clear();
        driver.findElement(By.id("input-option219")).sendKeys("2022-06-07");
        driver.findElement(By.id("input-option221")).click();
        driver.findElement(By.id("input-option221")).clear();
        driver.findElement(By.id("input-option221")).sendKeys("13:48");
        driver.findElement(By.id("input-option220")).click();
        driver.findElement(By.id("input-option220")).clear();
        driver.findElement(By.id("input-option220")).sendKeys("2022-06-07 13:49");
        driver.findElement(By.id("input-quantity")).click();
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys("3");
        driver.findElement(By.id("button-cart")).click();

        WebElement alertSuccess = driver.findElement(By.cssSelector(".container > .alert.alert-success"));
        Assert.assertTrue(alertSuccess.isDisplayed());
    }
}
