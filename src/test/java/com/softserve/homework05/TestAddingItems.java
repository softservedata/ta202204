package com.softserve.homework05;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencart.pageobject.AddingItems;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAddingItems {
	private WebDriver driver;
	private AddingItems addToCart;
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

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		addToCart = new AddingItems(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));
		driver.navigate().to(baseURL);
	}

	@Test
	public void testMethod() throws InterruptedException {
		addToCart.clickOnAddToCartButton();
		presentationSleep();
		addToCart.clickOnCartButton();
		presentationSleep();
		addToCart.clickOnViewCartButton();
		presentationSleep();
		String item = addToCart.getItem();
		Assert.assertTrue(item.contains("MacBook"));
		presentationSleep();
		System.out.println(item + " has been added to the cart");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
