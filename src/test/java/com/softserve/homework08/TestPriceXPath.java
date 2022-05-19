package com.softserve.homework08;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.pages.TotalPriceXPath;
import com.softserve.utilities.CaptureScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPriceXPath {
	private WebDriver driver;
	private TotalPriceXPath verifyProducts;
	private double expected, actual;
	private final String baseURL = "http://taqc-opencart.epizy.com/";
	private static final Logger log = LogManager.getLogger(TotalPriceXPath.class.getName());
	private final int implicitlyWaitSeconds = 0;
	
//	@BeforeSuite(alwaysRun = true)
//	public void beforeSuite() {
//		WebDriverManager.chromedriver().setup();
//	}

	@BeforeClass(alwaysRun = true)
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		//driver = new ChromeDriver();
		log.info("Homework 08 Test");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("New driver instantiated");
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("New driver instantiated");
		}
		verifyProducts = new TotalPriceXPath(driver);

		driver.manage().window().maximize();
		log.info("Window maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));
		log.info("Implicit wait is set to 0");
		expected = 123.20d * 2 + 602.00d * 3;
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver.get(baseURL);
		log.info("Web application is launched");
	}

	@Test(groups= {"xpath"})
	public void testTotalPriceXPath() throws InterruptedException {
		verifyProducts.clickOnCurrencyTab();
		verifyProducts.selectCurrency();
		verifyProducts.searchProduct("MacBook");
		Thread.sleep(3000);
		verifyProducts.addMacBookToCart();
		verifyProducts.searchProduct("iPhone");
		verifyProducts.addIPhoneToCart();
		verifyProducts.clickOnCartButton();
		Assert.assertTrue(verifyProducts.verifyAddedItems());
		verifyProducts.clickOnShoppingCartButton();
		verifyProducts.setIPhoneQty(2);
		verifyProducts.setMacBookQty(3);
		actual = Double.parseDouble(verifyProducts.verifyTotalPrice().replace("$", "").replace(",", "")); //
		Assert.assertEquals(actual, expected);
		log.info("XPath: Total price is correct");
		//System.out.println("XPath: Total price is correct");
	}

	@AfterMethod(alwaysRun = true)
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

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			driver.quit();
			log.info("Browser closed");
		}
	}
}
