package com.softserve.homework09;

/*Підготувати тестовий метод з наступним сценарієм.
        1) Зайти на сайт https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/
        У першій таблиці (пункт  Uncontrolled Mode) у фільтрі Сity внести букву L. Перевірити присутність у стовпчику
        міст Las Vegas та London.*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class CheckCityInTheTable {
    private static final String BASE_URL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private static void presentationSleep() {
        presentationSleep(2);
    }

    private static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        closePopup();
    }

private void closePopup(){
    WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
    WebElement closePopup = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.
            xpath("//footer[contains(@class,'cookie')]//button")));
    closePopup.click();
}

    @Test
    public void SearchCityInTheList() {
        WebElement table = driver.findElement(By.cssSelector("div.embedded-demo"));
        Actions scrolling = new Actions(driver);
        scrolling.moveToElement(table).perform();
        presentationSleep(4);

        driver.switchTo().frame(driver.findElement(By
                .xpath("//div[contains(@data-options,'grid-filtering/filter-row')]//iframe")));

        WebElement cityFilter = driver.findElement(By
                .xpath("//div[contains(@data-options,'grid-filtering/filter-row')]//table//tr[2]//th[3]//input"));
        cityFilter.click();
        cityFilter.clear();
        cityFilter.sendKeys("L");
        presentationSleep(4);

        List<WebElement> searchResult = driver.findElements(By.xpath("//tbody//tr//td"));
        String london = null;
        String lasvegas = null;
        for (WebElement current : searchResult) {
            if (current.getText().contains("London")) {
                london = current.getText();
            }
            if (current.getText().contains("Las Vegas")) {
                lasvegas = current.getText();
            }
        }
        Assert.assertEquals(london, "London");
        Assert.assertEquals(lasvegas, "Las Vegas");

    }
}