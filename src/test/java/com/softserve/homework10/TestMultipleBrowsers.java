package com.softserve.homework10;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.opencart.pageobject.LoginPage;
import com.softserve.utilities.DataProviders;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMultipleBrowsers {
	private WebDriver driver;
	private LoginPage verifyLogin;
	private String filename;
	private File sourceFile;
	private final String directory = "screenshots\\";
	private final String baseURL = "http://taqc-opencart.epizy.com/";
	private final Long implicitlyWaitSeconds = 5L;

	@Test(dataProvider = "browsers", dataProviderClass = DataProviders.class)
	public void testMethod(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		verifyLogin = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));

		driver.get(baseURL);

		// Test starts
		verifyLogin.clickMyAccountTab();
		verifyLogin.clickOnLoginLink();
		verifyLogin.setEmail("hahaha@gmail.com");
		verifyLogin.setPassword("qwerty");
		verifyLogin.clickOnLoginButton();
		Boolean verify = verifyLogin.verifyLogin();
		Assert.assertTrue(verify);
		System.out.println("Login successful");
		if (driver != null) {
            driver.quit();
        }
	}

	@AfterMethod
    public void afterMethod(ITestResult result) {
        // logout;
        // Save Screen;
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
}
