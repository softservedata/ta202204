package com.softserve.homework05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddMacToBasket {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private void pause (int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //
    @Test
    public void addMacTest () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //
        driver.get("http://taqc-opencart.epizy.com/");
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("macbook");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        driver.findElement(By.xpath("//a[text()='MacBook']")).click();
        driver.findElement(By.cssSelector("#button-cart")).click();
        pause(1);
        WebElement mac = driver.findElement(By.xpath("//*[@id='cart']"));

        System.out.println(mac.getText());
        Assert.assertTrue(mac.getText().contains("1 item(s)"));
        driver.quit();
    }
}
