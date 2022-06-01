package com.softserve.homework09;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.pageobject.GridFilteringPage;
import com.softserve.utilities.CaptureScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFilterCity {
	private WebDriver driver;
	private GridFilteringPage verifyCities;
	private final String baseURL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";
	private static final Logger log = LogManager.getLogger(GridFilteringPage.class.getName());
	private final int implicitlyWaitSeconds = 0;

//	@BeforeSuite(alwaysRun = true)
//	public void beforeSuite() {
//		WebDriverManager.chromedriver().setup();
//	}

	@BeforeClass
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		//driver = new ChromeDriver();
		log.info("Homework 09 Test");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("New driver instantiated");
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("New driver instantiated");
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("New driver instantiated");
		}
		verifyCities = new GridFilteringPage(driver);

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
	public void testTotalPriceXPath() throws InterruptedException {
		verifyCities.acceptCookies();
		verifyCities.searchCity("L");
		Assert.assertTrue(verifyCities.verifyFilteredCities());
		log.info("All cities are in the list");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String testName = result.getName();
			System.out.println("TC with name " + testName + " failed");
			CaptureScreenshot.takeScreenshot(driver, testName);
			log.info("Screenshot is taken");
			driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete
			log.info("All Cookies are deleted");
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
