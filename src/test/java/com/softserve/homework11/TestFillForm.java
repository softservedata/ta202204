package com.softserve.homework11;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.opencart.pageobject.FormFillOut;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFillForm {
	private WebDriver driver;
	private FormFillOut fillform;
	private String filename;
	private File sourceFile;
	private final String directory = "screenshots\\";
	private final String EXPECTED = "3 item(s) - $556.80";
	private final String baseURL = "http://taqc-opencart.epizy.com/";
	private static final Logger log = LogManager.getLogger(FormFillOut.class.getName());
	private final Long implicitlyWaitSeconds = 5L;
	//private String SUCCESS_MESSAGE = "Success: You have added Apple Cinema 30\" to your shopping cart!\n×";
	String filePath = "./src/test/resources/scripts/fileupload.exe";

	@BeforeSuite
	public void beforeSuite() {
		log.info("Homework 08 Test");
        WebDriverManager.chromedriver().setup();
    }

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		log.info("New driver instantiated");
		fillform = new FormFillOut(driver);

		driver.manage().window().maximize();
		log.info("Window maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));
		log.info("Implicit wait is set to 0");
	}

	@BeforeMethod
    public void beforeMethod() {
        driver.get(baseURL);
        log.info("Web application is launched");
    }

	@Test
	public void testTotalPrice() throws InterruptedException {
		fillform.clickAddCinemaToCart();
		fillform.selectSizeRadioButton();
		fillform.selectCheckbox();
		fillform.enterText("Test");
		fillform.selectColor("3");
		fillform.enterAdditionalText("Text");
		fillform.uploadFile(filePath);
		fillform.enterDate("2022-11-20");
		fillform.enterTime("15:15");
		fillform.enterDateTime("2022-11-20 15:15");
		fillform.setQuantity(3);
		//Assert.assertEquals(fillform.verifySuccessMessage(), SUCCESS_MESSAGE);
		Assert.assertEquals(fillform.verifyTotalPrice(), EXPECTED);
		log.info("Apple Cinema 30\" is successfully added to the cart");
	}

	@AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getName();
            System.out.println("TC with name " + testName + " failed");
            filename = result.getName() + ".png";
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to;
            // previous state, logout, etc.
            sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
            	FileUtils.copyFile(sourceFile, new File(directory + filename));
            }
            catch(Exception e) {
            	System.out.println("Failed to place screenshot on failure");
            }
            finally {
            	driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete
            }
        }
    }

	@AfterClass
	public void afterClass() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed");
        }
	}
}
