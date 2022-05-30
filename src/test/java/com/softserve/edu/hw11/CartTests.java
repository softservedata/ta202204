package com.softserve.edu.hw11;

import com.sun.glass.events.KeyEvent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class CartTests {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void cartTest() throws AWTException {
		driver.get("http://taqc-opencart.epizy.com/");
		driver.findElement(By.xpath("//div[@class='product-thumb transition'][contains(., 'Apple Cinema')]//button[@onclick[contains(., 'cart.add')]]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']")).isDisplayed());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//label[contains(., 'Radio')]/following-sibling::div/div[1]//input")).click();
		driver.findElement(By.xpath("//label[contains(., 'Checkbox')]/following-sibling::div/div[1]//input")).click();
		driver.findElement(By.xpath("//label[contains(., 'Text')]/following-sibling::input")).sendKeys("some text");
		driver.findElement(By.xpath("//label[contains(., 'Select')]/following-sibling::select/option[2]")).click();
		driver.findElement(By.xpath("//label[contains(., 'Text')]/following-sibling::textarea")).sendKeys("some text");
		driver.findElement(By.xpath("//button[contains(., 'Upload File')]")).click();
		
		Robot robot = new Robot();
		robot.setAutoDelay(1000);
		
		StringSelection stringSelection = new StringSelection("24701-nature-natural-beauty.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.setAutoDelay(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//div[@id='product']//button[contains(., 'Add to Cart')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='container']/div[contains(., 'uccess: You have added')]")).isDisplayed());
		
	}
	
}
