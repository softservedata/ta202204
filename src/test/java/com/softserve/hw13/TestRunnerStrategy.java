package com.softserve.hw13;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.Map;

//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.opencart.pages.HomePage;
import com.opencart.tools.browser.Browsers;
import com.opencart.tools.browser.DriverWrapper;
import com.opencart.tools.search.SearchStrategy;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.opencart.pages.HomePage;
import com.opencart.tools.browser.Browsers;
import com.opencart.tools.browser.DriverWrapper;
import com.opencart.tools.search.SearchStrategy;

public abstract class TestRunnerStrategy {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private Browsers browser = Browsers.CHROME_TEMPORARY;
    //private WebDriver driver;
    //protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void presentationSleep() {
        presentationSleep(1);
    }

    protected void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*-
    private void takeScreenShot(String testname) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + currentTime + "_" + testname + "_screenshot.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void takePageSource(String testname) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_" + testname + "_source.html");
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    */

    /*
    @BeforeSuite
    public void beforeSuite() {
        // System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
    }
    */

    @BeforeClass
    public void beforeClass(ITestContext context) {
        //driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        //driver.manage().window().maximize();
        //
        if (context != null) {
            for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
                System.out.println("\t\t*** parameter: key=" + entry.getKey() + " value=" + entry.getValue());
                if (entry.getKey().contains("browser")) {
                    if (entry.getValue().contains("chrome")) {
                        browser = Browsers.CHROME_TEMPORARY;
                    } else if (entry.getValue().contains("firefox")) {
                        browser = Browsers.FIREFOX_TEMPORARY;
                    }
                }
            }
        }
        //DriverWrapper.setDriver(browser);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        //driver.quit();
        DriverWrapper.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        DriverWrapper.setDriver(browser);
        SearchStrategy.setImplicitStrategy();
        //driver.get(BASE_URL);
        // TODO
        //DriverWrapper.setDriver(Browsers.CHROME_TEMPORARY);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        //logger.info("Test " + result.getName() + " done");
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            //logger.error("Test " + result.getName() + " ERROR");
            // Take Screenshot, Save sourceCode, Save to log, Prepare report, Return to previous state, logout, etc.
            // driver.manage().deleteAllCookies();
            // clear cache; delete cookie; delete session;
            //takeScreenShot(testName);
            //takePageSource(testName);
            //saveTextAttach("Attach file: testng.xml = ", "testng.xml");
            DriverWrapper.deleteCookies();
            // driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete
            // session;
        }
        //driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //driver.findElement(By.cssSelector("#logo > a")).click();
        //driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]/..")).click();
        presentationSleep(); // For Presentation ONLY
    }

    protected HomePage loadApplication() {
        DriverWrapper.getUrl(BASE_URL);
        //return new HomePage(driver);
        return new HomePage(DriverWrapper.getDriver());
        //return new HomePage();
    }

}