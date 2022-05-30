package com.softserve.edu.homework09;

/*
    9.1) Зайти на сайт https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/
    У першій таблиці (пункт  Uncontrolled Mode) у фільтрі Сity внести букву L.
    Перевірити присутність у стовпчику міст Las Vegas та London.
    Для коду використати пакет com.softserve.homework09
    Запушати код на github у свою вітку.
*/

import com.softserve.edu.browsersDrivers.ChromeDriverUtilitiesImp;
import com.softserve.edu.sites.devexpress.UncontrolledModeTableFlow;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableFilterTests {
    private final String baseUrl = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";
    private WebDriver driver;
    private ChromeDriverUtilitiesImp driverUtilities;
    private Long implicitlyWaitSeconds = 10L;
    private UncontrolledModeTableFlow uncontrolledModeTableFlow;

    @BeforeTest
    public void BeforeTest() {
        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(this.implicitlyWaitSeconds));
        this.driver.manage().window().maximize();
        this.driver.get(this.baseUrl);
        this.driverUtilities = new ChromeDriverUtilitiesImp(this.driver);

        this.uncontrolledModeTableFlow = new UncontrolledModeTableFlow(this.driverUtilities);
    }

    @AfterTest(alwaysRun = true)
    public void AfterTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void verifyFilterByCity() {
        String expectedFirst = "Las Vegas";
        String expectedSecond = "London";

        this.uncontrolledModeTableFlow.closePopUp("//footer[contains(@class,'cookie')]//button");
        this.uncontrolledModeTableFlow.switchToIframe("//div[contains(@data-options,'/filter-row')]//iframe");
        this.uncontrolledModeTableFlow.setValueToInput("//thead//tr[2]/th[3]//input", "L");

        List<WebElement> allRows = this.uncontrolledModeTableFlow.returnAllRows("//tbody/tr");

        List<String> foundValues = this.uncontrolledModeTableFlow.getTextByColumnForRows(allRows, ".//td[3]");

        Assert.assertTrue(foundValues.contains(expectedFirst));
        Assert.assertTrue(foundValues.contains(expectedSecond));
    }
}
