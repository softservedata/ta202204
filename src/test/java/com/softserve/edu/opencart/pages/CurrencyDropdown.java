package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyDropdown {
	
	public static final String EUR = "€";
	public static final String USD = "US Dollar";
	public static final String GBP = "Pound Sterling";

	private WebDriver driver;
	
	private WebElement eurCurrency;
	private WebElement usdCurrency;
	private WebElement gbpCurrency;
	
	public CurrencyDropdown(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		initElement();
	}

	private void initElement() {
		eurCurrency = driver.findElement(By.xpath("//button[contains(., 'Currency')]/following-sibling::ul//button[@name='EUR']"));
		usdCurrency = driver.findElement(By.xpath("//button[contains(., 'Currency')]/following-sibling::ul//button[@name='USD']"));
		gbpCurrency = driver.findElement(By.xpath("//button[contains(., 'Currency')]/following-sibling::ul//button[@name='GBP']"));
	}
	
	
	public WebElement getEurCurrency() {
		return eurCurrency;
	}
	
	public WebElement getUsdCurrency() {
		return usdCurrency;
	}
	
	public WebElement getGbpCurrency() {
		return gbpCurrency;
	}
	
	public void clickUsdCurrency() {
		getUsdCurrency().click();
	}

	public void clickEur() {
		getEurCurrency().click();
	}
	
	public void clickGbp() {
		getGbpCurrency().click();
	}
	
	public String getUsdCurrencyTest() {
		return getUsdCurrency().getText();
	}

	public String getEurCurrencyText() {
		return getEurCurrency().getText();
	}
	
}
