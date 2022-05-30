package com.softserve.edu.homework06;

/*
    6.1) Зайти на сайт http://taqc-opencart.epizy.com/
    Залогуватися. E-Mail Address: hahaha@gmail.com та Password: qwerty
    Клікнути на кнопку Login.
    Перевірити, чи ми дійсно залогувалися.
    Для коду використати пакет com.softserve.homework06
    Запушати код на github у свою вітку.
*/

import com.softserve.edu.browsersDrivers.ChromeDriverUtilitiesImp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private final String baseUrl = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;
    private ChromeDriverUtilitiesImp driverUtilities;

    public LoginTest() {
        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @BeforeTest
    public void beforeTest() {
        this.driver.get(this.baseUrl);
        this.driverUtilities = new ChromeDriverUtilitiesImp(this.driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void checkLogin() {
        String expected = "Logout";

        this.loginProcess();

        WebElement accountButton = this.driverUtilities.findByCssSelector("a[title='My Account']");
        accountButton.click();

        WebElement logoutButton = this.driverUtilities.findByCssSelector("div#top-links a[href*='account/logout']");
        String actual = logoutButton.getAttribute("text");
        logoutButton.click();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkLogout() {
        String expected = "Login";

        this.loginProcess();

        WebElement accountButton = this.driverUtilities.findByCssSelector("a[title='My Account']");
        accountButton.click();

        WebElement logoutButton = this.driverUtilities.findByCssSelector("div#top-links a[href*='account/logout']");
        logoutButton.click();

        accountButton = this.driverUtilities.findByCssSelector("a[title='My Account']");
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
