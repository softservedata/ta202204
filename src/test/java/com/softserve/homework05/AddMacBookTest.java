package com.softserve.homework05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddMacBookTest {

    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;

    private static void delaySec() {
        delaySec(1);
    }

    private static void delaySec(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkAddMAcBook() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        driver.get("http://taqc-opencart.epizy.com");
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).sendKeys("mac");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        driver.findElement(By.xpath("//button[@onclick=\"cart.add('43', '1');\"]")).click();
        delaySec();
        driver.findElement(By.xpath("//button[@class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();
        WebElement macBook = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]"));
        Assert.assertTrue(macBook.getText().contains("MacBook"));
        System.out.println("***contains: " + macBook.getText());
        driver.quit();
    }
}
