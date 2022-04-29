package com.softserve.edu03.selen;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

    @Test
    public void checkWebElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        //
        driver.get("http://taqc-opencart.epizy.com/");
        Thread.sleep(2000);
        driver.findElement(By.name("search")).sendKeys("mac");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //
        Thread.sleep(8000);
        driver.quit();
    }
}
