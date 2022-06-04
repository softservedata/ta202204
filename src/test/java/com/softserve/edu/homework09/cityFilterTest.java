package com.softserve.edu.homework09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class cityFilterTest {

    private static final String BASE_URL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
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
        acceptCookies();
    }

    public void acceptCookies(){
        WebElement cookieFooter = driver.findElement(By.xpath("//footer[@class = 'cookie-module--cookie--pJvQ8']"));

        if (cookieFooter != null) {
            cookieFooter.findElement(By.xpath(".//button")).click();
        }
        presentationSleep();
    }

    public void filterCity(String cityName) {
        WebElement position = driver.findElement(By.cssSelector("div.embedded-demo"));
        Actions action = new Actions(driver);
        action.moveToElement(position).perform();

        driver.switchTo().frame(driver.findElement(By.cssSelector("div.tab-content iframe")));

        WebElement filterField = driver.findElement(By.xpath("(//tr[@class='MuiTableRow-root MuiTableRow-head css-e42jjo']" +
                "//input[@class='Editor-input MuiInput-input MuiInputBase-input css-mnn31'])[last()-1]"));


        filterField.click();
        filterField.clear();
        filterField.sendKeys(cityName);
    }

    public void checkSearchResult(String cityName) {
        String currentCity;
        List<WebElement> tableRows = driver.findElements(By.xpath("//tr[@class='MuiTableRow-root css-e42jjo']"));

        for(WebElement current : tableRows) {
             currentCity = current.findElement(By.xpath(".//td [last()-1]")).getText();
                if (currentCity.equals(cityName)) {
                    System.out.println("City from search result: " + currentCity + " = " + cityName);
                }
        }
        presentationSleep();
    }

    @Test
    public void checkFilter(){
        filterCity("L");
        checkSearchResult("London");
        checkSearchResult("Las Vegas");
    }
}