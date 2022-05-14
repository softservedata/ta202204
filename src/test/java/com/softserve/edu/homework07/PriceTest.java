package com.softserve.edu.homework07;

/*
    Підготувати тестовий метод з наступним сценарієм. Всі web елементи шукати по CSS.
    7.1) Зайти на сайт http://taqc-opencart.epizy.com/
    Вибрати валюту USD.
    Додати до корзини MacBook та iPhone 3. Перевірити, чи дійсно операції успішні.
    Перейти у корзину (меню Shopping Cart). Змінити кількість iPhone 3 на 2, а MacBook на 3.
    Перевірити очікувану ціну.
    Для коду використати пакет com.softserve.homework07
    Запушати код на github у свою вітку.
*/

import com.softserve.edu.utilities.ChromeDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriceTest {
    private final String baseUrl = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;
    private ChromeDriverUtilities driverUtilities;

    @BeforeTest
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get(this.baseUrl);
        this.driverUtilities = new ChromeDriverUtilities(this.driver);
    }

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    private void addToCart() {
        WebElement dropDownButton = this.driverUtilities.findByCssSelector("nav#top button[data-toggle='dropdown']");
        dropDownButton.click();

        WebElement currency = this.driverUtilities.findByCssSelector("button[name='USD']");
        currency.click();

        WebElement addMacBookToCart = this.driverUtilities.findByCssSelector("div#content button[onclick*='43']");
        addMacBookToCart.click();

        WebElement addPhoneToCart = this.driverUtilities.findByCssSelector("div#content button[onclick*='40']");
        addPhoneToCart.click();

        WebElement cartButton = this.driverUtilities.findByCssSelector("a[title='Shopping Cart']");
        cartButton.click();
    }

    private void increaseAmount() {
        WebElement phoneQuantity = this.driverUtilities.findByCssSelector("table tr:nth-child(1) td:nth-child(4) input[type='text']");
        phoneQuantity.click();
        phoneQuantity.clear();
        phoneQuantity.sendKeys("2");

        WebElement refreshButton = this.driverUtilities.findByCssSelector("table tr:nth-child(1) td:nth-child(4) button[type='submit']");
        refreshButton.click();

        WebElement macBookQuantity = this.driverUtilities.findByCssSelector("table tr:nth-child(2) td:nth-child(4) input[type='text']");
        macBookQuantity.click();
        macBookQuantity.clear();
        macBookQuantity.sendKeys("3");

        refreshButton = this.driverUtilities.findByCssSelector("table tr:nth-child(2) td:nth-child(4) button[type='submit']");
        refreshButton.click();
    }

    @Test
    public void verifyPrice() {
        String expectedFirst = "iPhone 3";
        String expectedSecond = "MacBook";
        String expectedThird = "$2,052.40";

        this.addToCart();

        WebElement phoneName = this.driverUtilities.findByCssSelector("table tr:nth-child(1) td:nth-child(2) a");
        String actualFirst = phoneName.getAttribute("innerText");

        WebElement macBookName = this.driverUtilities.findByCssSelector("table tr:nth-child(2) td:nth-child(2) a");
        String actualSecond = macBookName.getAttribute("innerText");

        this.increaseAmount();

        WebElement totalPrice = this.driverUtilities.findByCssSelector("div[class='row'] table tr:nth-child(4) td:nth-child(2)");
        String actualThird = totalPrice.getAttribute("innerText");

        Assert.assertEquals(actualFirst, expectedFirst);
        Assert.assertEquals(actualSecond, expectedSecond);
        Assert.assertEquals(actualThird, expectedThird);
    }
}
