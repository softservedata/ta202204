package com.softserve.homework06;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.opencart.pages.LoginPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {
	private WebDriver driver;
	private LoginPage verifyLogin;
	private String filename;
	private File sourceFile;
	private final String directory = "screenshots\\";
	private final String baseURL = "http://taqc-opencart.epizy.com/";
	private final Long implicitlyWaitSeconds = 5L;
	private final Long oneSecondDelay = 1000L;

	private void presentationSleep() {
		presentationSleep(1);
	}

	private void presentationSleep(int seconds) {
		try {
			Thread.sleep(seconds * oneSecondDelay);
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
		verifyLogin = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));
	}
	
	@BeforeMethod
    public void beforeMethod() {
        driver.get(baseURL);
    }

	@Test
	public void testMethod() throws InterruptedException {
		verifyLogin.clickMyAccountTab();
		presentationSleep();
		verifyLogin.clickOnLoginLink();
		presentationSleep();
		verifyLogin.setEmail("hahaha@gmail.com");
		presentationSleep();
		verifyLogin.setPassword("qwerty");
		presentationSleep();
		verifyLogin.clickOnLoginButton();
		Boolean verify = verifyLogin.verifyLogin();
		Assert.assertTrue(verify);
		presentationSleep();
		System.out.println("Login successful");
	}
	
	@AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep();
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
        presentationSleep();
    }
	
	@AfterClass
	public void afterClass() {
		presentationSleep();
        if (driver != null) {
            driver.quit();
        }
	}
}
