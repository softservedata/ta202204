package com.softserve.edu.hw10;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {

	WebDriver driver;
	
	@DataProvider
	public Object[][] getBrowser() {
		return new Object[][] {
				new Object [] {"Chrome"},
				new Object [] {"Firefox"}
		};
	}
	
	@Test(dataProvider = "getBrowser")
	public void checkUserLoggedIn(Object browser) {
		
		if (browser.toString().equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.toString().equals("Chrome")) {
			driver = new ChromeDriver();
		}
		
		driver.get("http://taqc-opencart.epizy.com/");
		driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(., 'Login')]")).click();
		driver.findElement(By.id("input-email")).sendKeys("hahaha@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(., 'Logout')]")).isDisplayed());
	}
	
	
	
}
