package com.softserve.homework07;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
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

import com.opencart.TotalPrice;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPrice {
	private WebDriver driver;
	private TotalPrice verifyProducts;
	private String filename;
	private File sourceFile;
	private double expected, actual;
	private final String directory = "screenshots\\hw7\\";
	private final String baseURL = "http://taqc-opencart.epizy.com/";
	private final Long implicitlyWaitSeconds = 5L;
	
	@BeforeSuite
	public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		verifyProducts = new TotalPrice(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));
		expected = 123.20d * 2 + 602.00d * 3;
	}
	
	@BeforeMethod
    public void beforeMethod() {
        driver.get(baseURL);
    }

	@Test
	public void testMethod() throws InterruptedException {
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
		System.out.println("Total price is correct");
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
        }
	}
}
