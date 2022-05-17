package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.softserve.utilities.CaptureScreenshot;
import com.softserve.utilities.PageActions;

public class TotalPriceXPath {
	WebDriver driver;
	PageActions action;
	
	@FindBy(xpath="//form[@id='form-currency']//button[@data-toggle='dropdown']")
	WebElement currencyTab;
	
	@FindBy(xpath="//form[@id='form-currency']//button[@name='USD']")
	WebElement currencyButton;
	
	@FindBy(xpath="//div[@id='search']/input")
	WebElement searchField;
	
	@FindBy(xpath="//a[contains(text(),'MacBook')]/../following-sibling::p[contains(text(),'Intel Core')]/../following-sibling::div//span/..")
	WebElement addMacBookToCartButton;
	
	@FindBy(xpath="//a[contains(text(),'iPhone 3')]/../following-sibling::p[contains(text(),'revolutionary')]/../following-sibling::div//span/..")
	WebElement addIPhoneToCartButton;
	
	@FindBy(xpath="//div[@id='cart']/button")
	WebElement cartButton;
	
	@FindBy(xpath="//table[@class='table table-striped']//a[contains(text(),'iPhone 3')]")
	WebElement iPhone;
	
	@FindBy(xpath="//table[@class='table table-striped']//a[contains(text(),'MacBook')]")
	WebElement macBook;
	
	@FindBy(xpath="//div[@id='top-links']//a[contains(@href,'checkout/cart')]")
	WebElement shoppingCartButton;
	
	@FindBy(xpath="//div[@id='content']//a[contains(text(),'iPhone 3')]/../following-sibling::td//input[contains(@name,'quantity')]")
	WebElement iPhoneQty;
	
	@FindBy(xpath="//div[@id='content']//a[contains(text(),'MacBook')]/../following-sibling::td//input[contains(@name,'quantity')]")
	WebElement macBookQty;
	
	@FindBy(xpath="//table[@class='table table-bordered']//strong[starts-with(text(),'Total:')]/../following-sibling::td")
	WebElement totalPrice;
	
	public TotalPriceXPath(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new PageActions(driver);
	}
	
	public void clickOnCurrencyTab() {
		try {
			action.clickButton(currencyTab);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
		//currencyTab.click();
	}
	
	public void selectCurrency() {
		try {
			action.clickButton(currencyButton);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
		//currencyButton.click();
	}
	
	public void searchProduct(String product) {
		try {
			action.enterDataIntoTextbox(searchField, product);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
		//searchField.clear();
		//searchField.sendKeys(product + Keys.ENTER);
	}
	
	public void addMacBookToCart() {
		try {
			action.clickButton(addMacBookToCartButton);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
		//addMacBookToCartButton.click();
	}
	
	public void addIPhoneToCart() {
		try {
			action.clickButton(addIPhoneToCartButton);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
		//addIPhoneToCartButton.click();
	}
	
	public void clickOnCartButton() {
		try {
			action.clickButton(cartButton);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
		//cartButton.click();
	}
	
	public boolean verifyAddedItems() {
		if(!iPhone.isDisplayed() || !macBook.isDisplayed())
			return false;
		else
			return true;
	}
	
	public void clickOnShoppingCartButton() {
		try {
			action.clickButton(shoppingCartButton);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
		//shoppingCartButton.click();
	}

	
	public void setIPhoneQty(int iPhone) {
		try {
			action.enterDataIntoTextbox(iPhoneQty, Integer.toString(iPhone));
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
		//iPhoneQty.clear();
		//iPhoneQty.sendKeys(Integer.toString(iPhone) + Keys.TAB + Keys.ENTER);
	}
	
	public void setMacBookQty(int macBook) {
		try {
			action.enterDataIntoTextbox(macBookQty, Integer.toString(macBook));
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
		//macBookQty.clear();
		//macBookQty.sendKeys(Integer.toString(macBook) + Keys.TAB + Keys.ENTER);
	}
	
	public String verifyTotalPrice() {
		return totalPrice.getText();
	}
}
