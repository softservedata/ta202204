package com.softserve.edu.homework10;

/*
    10.1) Модифікувати тестовий метод завдання 6.
    Додати параметром тесту об'єкт, який буде запускати браузер (достатньо використати Firefox та Chrome).
    Скористатися @DataProvider (наприклад, див. клас com.softserve.testng.CharUtilsTest)
*/

import com.softserve.edu.browsersDrivers.ChromeDriverUtilitiesImp;
import com.softserve.edu.browsersDrivers.DriverUtilities;
import com.softserve.edu.browsersDrivers.FireFoxDriverUtilitiesImp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestMultiBrowsers {
    private final String baseUrl = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;
    private DriverUtilities driverUtilities;
    private Integer implicitlyWaitSeconds = 10;

    @DataProvider(name = "browsers")
    public Object[][] getBrowsers() {
        return new Object[][]{
            {"Chrome"},
            {"Firefox"}
        };
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    private void createDriver(String browserName) {
        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            this.driverUtilities = new ChromeDriverUtilitiesImp(this.driver);
        } else if (browserName.equals(("Firefox"))) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
            this.driverUtilities = new FireFoxDriverUtilitiesImp(this.driver);
        }

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(this.implicitlyWaitSeconds));
        this.driver.manage().window().maximize();
        this.driver.get(this.baseUrl);
    }

    @Test(dataProvider = "browsers")
    public void checkLogin(String browserName) {
        this.createDriver(browserName);
        String expected = "Logout";

        this.loginProcess();

        this.driverUtilities.stalenessExceptionCLick("a[title='My Account']");

        WebElement logoutButton = this.driverUtilities.findByCssSelector("div#top-links a[href*='account/logout']");
        String actual = logoutButton.getAttribute("text");
        logoutButton.click();

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "browsers")
    public void checkLogout(String browserName) {
        this.createDriver(browserName);
        String expected = "Login";

        this.loginProcess();

        this.driverUtilities.stalenessExceptionCLick("a[title='My Account']");

        WebElement logoutButton = this.driverUtilities.findByCssSelector("div#top-links a[href*='account/logout']");
        logoutButton.click();

        WebElement accountButton = this.driverUtilities.findByCssSelector("a[title='My Account']");
        accountButton.click();

        WebElement loginButton = this.driverUtilities.findByCssSelector("div#top-links a[href*='account/login']");
        String actual = loginButton.getAttribute("text");

        Assert.assertEquals(actual, expected);
    }

    private void loginProcess() {
        WebElement accountButton = this.driverUtilities.findByCssSelector("a[title='My Account']");
        accountButton.click();

        WebElement loginButton = this.driverUtilities.findByCssSelector("div#top-links a[href*='account/login']");
        loginButton.click();

        WebElement emailInput = this.driverUtilities.findByCssSelector("div#content form input[name='email']");
        emailInput.sendKeys("hahaha@gmail.com");

        WebElement passwordInput = this.driverUtilities.findByCssSelector("div#content form input[name='password']");
        passwordInput.sendKeys("qwerty" + Keys.ENTER);
    }
}
