package com.softserve.homework08;

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

import com.opencart.pages.TotalPriceXPath;
import com.softserve.utilities.CaptureScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPriceXPath {
	private WebDriver driver;
	private TotalPriceXPath verifyProducts;
	private double expected, actual;
	private final String baseURL = "http://taqc-opencart.epizy.com/";
	//private final Long implicitlyWaitSeconds = 5L;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		driver = new ChromeDriver();
		verifyProducts = new TotalPriceXPath(driver);

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));
		expected = 123.20d * 2 + 602.00d * 3;
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver.get(baseURL);
	}

	@Test(groups= {"xpath"})
	public void testTotalPriceXPath() throws InterruptedException {
		verifyProducts.clickOnCurrencyTab();
		verifyProducts.selectCurrency();
		verifyProducts.searchProduct("MacBook");
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
		System.out.println("XPath: Total price is correct");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String testName = result.getName();
			System.out.println("TC with name " + testName + " failed");
			CaptureScreenshot.takeScreenshot(driver, testName);
			driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}
}
