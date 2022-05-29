package com.softserve.homework09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FilterByCityTest {
    public final String BASE_URL="https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";
    public final long IMPLICITLY_WAIT_SECONDS = 10L;
    public final long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void pause (int seconds) {
        try {
            Thread.sleep(seconds*ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.chromiumdriver().setup();
    }
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterClass() {
        pause(1);
        if (driver != null) driver.quit();
    }
    @BeforeMethod
    public void beforeMethod () {
        driver.get(BASE_URL);
        pause(1);
        closeCookieFooter();
    }
    @AfterMethod
    public void afterMethod () {
        System.out.println("Test is executed");
        //pause(1);
    }
    private void closeCookieFooter () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        Duration oneSecond = Duration.ofSeconds(1);
        Duration fiveSeconds = Duration.ofSeconds(5);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(fiveSeconds)
                .pollingEvery(oneSecond)
                .ignoring(NoSuchElementException.class)
                .ignoring(NullPointerException.class)
                .ignoring(TimeoutException.class);
        WebElement footerButton = wait.until(driver -> driver.findElement(By.cssSelector("footer[class*='cookie'] button")));
        /*  //instead of lambda see below
        WebElement footerButton = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("footer[class*='cookie'] button"));
            }
        });
         */
        footerButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
    }
    @Test
    public void filterByCityTest () {
        WebElement tablePosition = driver.findElement(By.cssSelector("#controlled-mode"));
        Actions action = new Actions(driver);
        action.moveToElement(tablePosition).perform();
        pause(1);
        //
        driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@data-options,'grid-filtering/filter-row')]//iframe")));
        driver.findElement(By.xpath("//div[contains(@data-options,'grid-filtering/filter-row')]//table//tr[2]//th[3]//input")).sendKeys("L");
        List<WebElement> cities = driver.findElements(By.xpath("//tbody//tr//td"));
        String actualLondon = null;
        String actualLasVegas = null;
        for (WebElement el: cities) {
            if (el.getText().contains("London")) {
                actualLondon = el.getText();
            }
            if (el.getText().contains("Las Vegas")) {
                actualLasVegas = el.getText();
            }
        }
        String expectedLondon = "London";
        String expectedLasVegas = "Las Vegas";
        Assert.assertEquals(actualLondon, expectedLondon);
        Assert.assertEquals(actualLasVegas, expectedLasVegas);
        //Assert.assertNotNull(actualLondon);
        //Assert.assertNotNull(actualLasVegas);
    }
}
