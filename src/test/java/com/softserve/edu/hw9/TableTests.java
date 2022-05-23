package com.softserve.edu.hw9;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class TableTests {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void checkTable() {
		driver.get("https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/");
		driver.findElement(By.xpath("//button[@class[contains(., 'cookie-module--button')]]")).click();
		driver.manage().timeouts().getImplicitWaitTimeout();
		WebElement iframe = driver.findElement(By.xpath("//h3[contains(., 'Uncontrolled Mode')]/following-sibling::div[@class=\"embedded-demo\"][1]//iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//thead//tr[2]/th[3]")).click();
		driver.findElement(By.xpath("//thead//tr[2]/th[3]//input")).sendKeys("L");
		List<WebElement> citiesSelectors = driver.findElements(By.xpath("//tbody//tr//td"));
		List<String> cities = new ArrayList<>();
		for (WebElement e: citiesSelectors) {
			cities.add(e.getText());
		}
		boolean matches1 = cities.stream().anyMatch(e->e.contains("Las Vegas"));
		boolean matches2 = cities.stream().anyMatch(e->e.contains("London"));
		Assert.assertTrue(matches1);
		Assert.assertTrue(matches2);
		driver.quit();
	}
}
