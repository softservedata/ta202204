package com.softserve.edu.homework05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddMacToCart {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

    @Test
    public void testAddMacToCart(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);

        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.name("USD")).click();

        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("mac");

        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        driver.findElement(By.xpath("//a[text()='MacBook']")).click();

        driver.findElement(By.id("button-cart")).click();

        driver.findElement(By.cssSelector("div#top-links a[href*='route=checkout/cart']")).click();

        WebElement productName = driver.findElement(By.xpath("//a[text()='MacBook']"));

        driver.quit();

    }
}
