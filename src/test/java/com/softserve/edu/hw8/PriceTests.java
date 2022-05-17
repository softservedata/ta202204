package com.softserve.edu.hw8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PriceTests {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void checkPrice() {
		driver.get("http://taqc-opencart.epizy.com/");
		driver.findElement(By.xpath("//form[@id='form-currency']")).click();
		driver.findElement(By.xpath("//button[@name='USD']")).click();
		driver.findElement(By.xpath("//ul/li[contains(., 'Laptops')]")).click();
		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[contains(., 'Macbook')]")).click();
		driver.findElement(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][1]//button[i[@class='fa fa-shopping-cart']]")).click();
		driver.findElement(By.xpath("//ul/li[contains(., 'Phones')]")).click();
		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[contains(., 'IPhone')]")).click();
		driver.findElement(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][contains(., 'iPhone 3')]//button[i[@class='fa fa-shopping-cart']]")).click();
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		driver.findElement(By.xpath("//form//table[@class='table table-bordered'][1]//tr[contains(., 'iPhone 3')]//input")).clear();
		driver.findElement(By.xpath("//form//table[@class='table table-bordered'][1]//tr[contains(., 'iPhone 3')]//input")).sendKeys("2");
		driver.findElement(By.xpath("//tr[contains(., 'iPhone 3')]//button[@data-original-title='Update']")).click();
		driver.findElement(By.xpath("//form//table[@class='table table-bordered'][1]//tr[contains(., 'MacBook')]//input")).clear();
		driver.findElement(By.xpath("//form//table[@class='table table-bordered'][1]//tr[contains(., 'MacBook')]//input")).sendKeys("3");
		driver.findElement(By.xpath("//tr[contains(., 'MacBook')]//button[@data-original-title='Update']")).click();
		String price = driver.findElement(By.xpath("//tr[contains(., 'VAT')]/following-sibling::tr[contains(., 'Total:')]/td[2]")).getText();
		Assert.assertTrue(price.contains("$2,052.40"));
	}
	
}
