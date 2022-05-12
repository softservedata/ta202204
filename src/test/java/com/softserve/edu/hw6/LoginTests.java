package com.softserve.edu.hw6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void checkUserLoggedIn() {
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
