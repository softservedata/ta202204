package com.softserve.edu08;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrolleTest {
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private WebDriver driver;
    int count = 0;

    private void takeScreenShot(String testname) throws IOException {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./" + currentTime + "_" + testname + "_screenshot.png"));
    }

    private void takePageSource(String testname) throws Exception {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_" + testname + "_source.html");
        Files.write(path, strToBytes, StandardOpenOption.CREATE);
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }

    //    @BeforeClass
    //    public void beforeClass() {
    //        driver = new ChromeDriver();
    //        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
    //        driver.manage().window().maximize();
    //    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            takeScreenShot(testName);
            takePageSource(testName);
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        // driver.close();
        driver.quit();
    }

    @Test
    public void checkScroll() throws Exception {
        driver = new ChromeDriver();
        Thread.sleep(1000); // For Presentation Only
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //
        driver.get("https://selenium.dev/downloads/");
        Thread.sleep(2000); // For Presentation Only
        //
        WebElement linkProject = driver.findElement(By.cssSelector("a[href='https://www.perfecto.io/']"));
        //
        /* // Scrolling by Action class
         * Actions action = new Actions(driver);
         * action.moveToElement(linkProject).perform();
         * Thread.sleep(2000); // For Presentation Only */
        // /*-
        // Scrolling by JavaScript injection
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkProject);
        Thread.sleep(2000); // For Presentation Only
        // */
        //
        takeScreenShot("checkScroll");
        takePageSource("checkScroll");
        //
        WebElement browserstack = driver.findElement(By.cssSelector("a[href*='www.browserstack.com']"));
        System.out.println("browserstack.isDisplayed() = " + browserstack.isDisplayed());
        System.out.println("browserstack.isEnabled() = " + browserstack.isEnabled());
        System.out.println("browserstack.isSelected() = " + browserstack.isSelected());
        //
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        /*-
        //        WebElement browserstack2 = (new WebDriverWait(driver, 10))
        //            .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='www.browserstack.com']")));
        WebElement browserstack2 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='www.browserstack.com']")));
         browserstack2.click();
        */
        //
        //int count = 0;
        /*-------
        (new WebDriverWait(driver, 10)).until(new 
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        count++;
                        System.out.println("count = " + count);
                        if (count > 4) {
                            WebElement button2 = driver.findElement(By.cssSelector("button.btn.btn-dark.btn-lg.btn-block"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button2);
                            //WebElement element2 = driver.findElement(By.cssSelector("a[href*='www.browserstack.com']"));
                            //Actions action = new Actions(driver);
                            //action.moveToElement(element2).perform();
                        }
                        try {
                            browserstack.click();
                        } catch (ElementClickInterceptedException e) {
                            return false;
                        }
                        return true;
            }    }    );
         */
        /*-
        WebElement browserstack2 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='www.browserstack.com']")));
        try {
            browserstack2.click(); // Error
        } catch (ElementClickInterceptedException e) {
        }
        */
        //
        //        browserstack.click(); // Error if Scrolling by JavaScript
        Thread.sleep(4000); // For Presentation Only
    }
}