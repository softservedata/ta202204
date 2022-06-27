package com.softserve.hw9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CityL {
    private final String BASE_URL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";
    private final long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private Actions actions;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    private void closePopup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> footerButton = driver.findElements(By.xpath("//footer[contains(@class,'cookie')]//button"));
        if (footerButton.size() > 0) {
            footerButton.get(0).click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
    }

    @Test
    public void testCityL() {
        driver.navigate().to(BASE_URL);
        closePopup();

        WebElement position = driver.findElement(By.id("uncontrolled-mode"));
        actions.moveToElement(position).perform();

        driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@data-options,'grid-filtering/filter-row')]//iframe")));

        WebElement filterCity = driver.findElement(By.xpath("//div[contains(@data-options,'grid-filtering/filter-row')]//table//tr[2]//th[3]//input"));
        filterCity.click();
        filterCity.sendKeys("L");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='Paris']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));

        List<WebElement> tableFilteredL = driver.findElements(By.xpath("//tbody//tr//td"));
        List<String> cityL = new ArrayList<>();
        for (WebElement allElements : tableFilteredL) {
            cityL.add(allElements.getText());
        }

        Assertions.assertTrue(cityL.stream().anyMatch(allElements -> allElements.contains("Las Vegas")));
        Assertions.assertTrue(cityL.stream().anyMatch(allElements -> allElements.contains("London")));
    }

    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void end() {
        System.out.println("Test ended");
    }
}
