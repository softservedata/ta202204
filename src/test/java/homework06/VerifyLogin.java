package homework06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyLogin {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;


    @Test
    public void checkLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        driver.get("http://taqc-opencart.epizy.com");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.name("email")).sendKeys("hahaha@gmail.com");
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        WebElement myAccount = driver.findElement(By.xpath("//div[@class=\"list-group\"]//a[text()='Logout']"));
        Assert.assertTrue(myAccount.getText().contains("Logout"));
        driver.findElement(By.xpath("//div[@class=\"list-group\"]//a[text()='Logout']")).click();
        driver.quit();
    }
}
