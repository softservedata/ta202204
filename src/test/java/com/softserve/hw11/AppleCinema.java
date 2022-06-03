package com.softserve.hw11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AppleCinema {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private Actions actions;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testAddAppleCinema30() {
        driver.navigate().to(BASE_URL);

        WebElement addToCardAppleCinema = driver.findElement(By.cssSelector("div#content button[onclick*='42']"));
        actions.moveToElement(addToCardAppleCinema).perform();
        addToCardAppleCinema.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("product")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));

        driver.findElement(By.cssSelector("#input-option218 input[value='5']")).click();
        driver.findElement(By.cssSelector("#input-option223 input[value='8']")).click();
        WebElement textInBox = driver.findElement(By.id("input-option208"));
        textInBox.click();
        textInBox.clear();
        textInBox.sendKeys("Please be careful!");
        driver.findElement(By.xpath("//label[contains(., 'Select')]/following-sibling::select/option[3]")).click();

        WebElement textArea = driver.findElement(By.id("input-option209"));
        textArea.click();
        textArea.sendKeys("Please be very careful!");

        driver.findElement(By.id("button-upload222")).click();
        try {
            Runtime.getRuntime().exec("C:\\Users\\oihna\\OneDrive - SoftServe, Inc\\Documents\\UploadFile.exe");
            //Runtime.getRuntime().exec("./resources/UploadFile.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.alertIsPresent());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));

        driver.switchTo().alert().accept();

        WebElement typeDate = driver.findElement(By.id("input-option219"));
        typeDate.click();
        typeDate.clear();
        typeDate.sendKeys("2022-06-02");

        WebElement typeTime = driver.findElement(By.id("input-option221"));
        typeTime.click();
        typeTime.clear();
        typeTime.sendKeys("21:06");

        WebElement typeDateTime = driver.findElement(By.id("input-option220"));
        typeDateTime.click();
        typeDateTime.clear();
        typeDateTime.sendKeys("2022-06-02 21:06");

        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.click();
        qty.clear();
        qty.sendKeys("2");

        driver.findElement(By.id("button-cart")).click();

        WebElement alertSuccess = driver.findElement(By.cssSelector(".container > .alert.alert-success"));
        Assertions.assertTrue(alertSuccess.isDisplayed());
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
