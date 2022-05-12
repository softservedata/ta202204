package com.softserve.edu.hw5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BagTests {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void checkAddingToBag() {
		driver.get("http://taqc-opencart.epizy.com/");
		driver.findElement(By.xpath("//a[contains(., 'Desktops')]")).click();
		driver.findElement(By.xpath("//li/a[contains(., 'Mac')]")).click();
		driver.findElement(By.xpath("//div[@class='product-thumb']//i[@class='fa fa-shopping-cart']")).click();
		driver.findElement(By.xpath("//div[@id='top-links']//a[@title='Shopping Cart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table table-bordered']//tr[contains(., 'iMac')]"))
				.isDisplayed()
		);
	}
	
}
