package com.softserve.edu.hw7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class PriceTests {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	@Test
	public void checkExpectedPrice() {
		driver.get("http://taqc-opencart.epizy.com/");
		driver.findElement(By.cssSelector("#form-currency")).click();
		driver.findElement(By.cssSelector("[name=USD]")).click();
		driver.findElement(By.cssSelector(
				".dropdown-toggle[href='http://taqc-opencart.epizy.com/index.php?route=product/category&path=18']"
		)).click();
		driver.findElement(By.cssSelector("a[href='http://taqc-opencart.epizy.com/index.php?route=product/category&path=18_46']"))
				.click();
		driver.findElement(By.cssSelector("#content div.product-layout:nth-child(1) button[onclick*='cart.add']"))
				.click();
		driver.findElement(By.cssSelector(
				".dropdown-toggle[href='http://taqc-opencart.epizy.com/index.php?route=product/category&path=24']"
		)).click();
		driver.findElement(By.cssSelector(
				"a[href='http://taqc-opencart.epizy.com/index.php?route=product/category&path=24_61']"
		)).click();
		driver.findElement(By.cssSelector("#content div.product-layout:nth-child(1) button[onclick*='cart.add']"))
				.click();
		driver.findElement(By.cssSelector("a[title='Shopping Cart']")).click();
		Assert.assertTrue(
				driver.findElement(By.cssSelector(
						"#content form .table.table-bordered tbody tr:nth-child(1)")
				).getText().contains("iPhone"));
		Assert.assertTrue(driver.findElement(By.cssSelector(
						"#content form .table.table-bordered tbody tr:nth-child(2)")
				).getText().contains("MacBook"));
		driver.findElement(By.cssSelector("#content form .table.table-bordered tbody tr:nth-child(1) input")).clear();
		driver.findElement(By.cssSelector("#content form .table.table-bordered tbody tr:nth-child(1) input")).sendKeys("2");
		driver.findElement(By.cssSelector("#content form .table.table-bordered tbody tr:nth-child(1) input + span button[type='submit']")).click();
		driver.findElement(By.cssSelector("#content form .table.table-bordered tbody tr:nth-child(2) input")).clear();
		driver.findElement(By.cssSelector("#content form .table.table-bordered tbody tr:nth-child(2) input")).sendKeys("3");
		driver.findElement(By.cssSelector("#content form .table.table-bordered tbody tr:nth-child(2) input + span button[type='submit']")).click();
		String text = driver.findElement(
				By.cssSelector("div.col-sm-4.col-sm-offset-8 table.table.table-bordered tr:last-child td:last-child")
		).getText();
		Assert.assertTrue(text.contains("$2,052.40"));
	}
	
	@AfterMethod
	public void closeWindow() {
		driver.close();
	}
	
}
