package com.softserve.homework05;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingMacbookToCart {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;

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

    @Test
    public void AddingMacbook() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("macbook");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        driver.findElement(By.xpath("//a[text()='MacBook']")).click();
        driver.findElement(By.id("button-cart")).click();
        driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")).click();
        WebElement element = driver.findElement(By
                .xpath("//*[@id='cart']/ul/li[1]/table/tbody/tr/td[2]/a"));
        String macincart = element.getText();
        Assert.assertTrue(macincart.contains("MacBook"));
        presentationSleep();
        driver.quit();
    }
}