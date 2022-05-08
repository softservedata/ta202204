package com.softserve.edu.homework05;

/*
    Підготувати тестовий метод з наступним сценарієм.
    5.1) Зайти на сайт http://taqc-opencart.epizy.com/
    Додати до корзини MacBook.
    Перевірити, чи дійсно товар був доданий.
    Для коду використати пакет com.softserve.homework05
    Запушати код на github у свою вітку.
*/

import com.softserve.edu.utilities.ProcessUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MacBookTest {
    private final String baseUrl = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;

    private WebElement findByCssSelector(String condition) {
        return this.driver.findElement(By.cssSelector(condition));
    }

    private WebElement findById(String condition) {
        return this.driver.findElement(By.id(condition));
    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get(this.baseUrl);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void addToBasket() {
        String expected = "MacBook";

        WebElement searchInput = this.findByCssSelector("div#search input");
        searchInput.click();
        ProcessUtilities.presentationSleep(2);

        searchInput.sendKeys("Mac book" + Keys.ENTER);
        WebElement cardButton = this.findByCssSelector("img[title='MacBook']");
        cardButton.click();

        WebElement addToCartButton = this.findById("button-cart");
        addToCartButton.click();
        ProcessUtilities.presentationSleep(2);

        WebElement cartButton = this.findByCssSelector("a[title='Shopping Cart']");
        cartButton.click();

        WebElement productName = this.findByCssSelector("table tr:nth-child(1) td:nth-child(2) a");
        String actual = productName.getAttribute("innerText");

        Assert.assertEquals(actual, expected);
    }
}
