package com.softserve.edu.homework08;

/*
    Всі web елементи шукати за допомогою XPath.
    Підготувати тестовий метод з наступним сценарієм.
    8.1) Зайти на сайт http://taqc-opencart.epizy.com/
    Вибрати валюту USD.
    Додати до корзини MacBook та iPhone 3. Перевірити, чи дійсно операції успішні.
    Перейти у корзину. Змінити кількість iPhone 3 на 2, а MacBook на 3.
    Перевірити очікувану ціну.
    Для коду використати пакет com.softserve.homework08
    Запушати код на github у свою вітку.
 */

import com.softserve.edu.browsersDrivers.ChromeDriverUtilitiesImp;
import com.softserve.edu.sites.opencart.CartFlow;
import com.softserve.edu.sites.opencart.SettingsFlow;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TotalPriceTest {
    private final String baseUrl = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;
    private ChromeDriverUtilitiesImp driverUtilities;
    private SettingsFlow settingsFlow;
    private CartFlow cartFlow;

    @BeforeTest
    public void BeforeTest() {
        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get(this.baseUrl);
        this.driverUtilities = new ChromeDriverUtilitiesImp(this.driver);
        this.settingsFlow = new SettingsFlow(this.driverUtilities);
        this.cartFlow = new CartFlow(this.driverUtilities);
    }

    @AfterTest(alwaysRun = true)
    public void AfterTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void verifyTotalPrice() {
        String expectedIPhone = "iPhone 3";
        String expectedMacBook = "MacBook";
        double expectedTotalPrice = 2052.40;

        this.settingsFlow.setCurrency("USD");
        this.cartFlow.addItemsToCart(new String[]{"40", "43"});
        this.cartFlow.openCart();

        String actualIPhone = this.cartFlow.getCartItemText("iPhone 3");
        Assert.assertEquals(actualIPhone, expectedIPhone);

        String actualMacBook = this.cartFlow.getCartItemText("MacBook");
        Assert.assertEquals(actualMacBook, expectedMacBook);

        this.cartFlow.changeQuantity("iPhone 3", "2");
        this.cartFlow.changeQuantity("MacBook", "3");

        double actualTotalPrice = this.cartFlow.getCartTotalPrice();
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }
}
