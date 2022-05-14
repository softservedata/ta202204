package com.softserve.homework06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;

    private void pause(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void addMacTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //
        driver.get("http://taqc-opencart.epizy.com/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']")).click();
        driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']")).sendKeys("hahaha@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("qwerty");
        //driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //
        WebElement logout = driver.findElement(By.xpath("//*[@id='column-right']/div[@class='list-group']"));
        Assert.assertTrue(logout.getText().contains("Logout"));
        driver.quit();
    }
}
