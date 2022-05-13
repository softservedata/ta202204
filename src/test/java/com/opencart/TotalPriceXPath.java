package com.opencart;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TotalPriceXPath {
WebDriver driver;
	
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
	}
	
	public void clickOnCurrencyTab() {
		currencyTab.click();
	}
	
	public void selectCurrency() {
		currencyButton.click();
	}
	
	public void searchProduct(String product) {
		searchField.clear();
		searchField.sendKeys(product + Keys.ENTER);
	}
	
	public void addMacBookToCart() {
		addMacBookToCartButton.click();
	}
	
	public void addIPhoneToCart() {
		addIPhoneToCartButton.click();
	}
	
	public void clickOnCartButton() {
		cartButton.click();
	}
	
	public boolean verifyAddedItems() {
		if(!iPhone.isDisplayed() || !macBook.isDisplayed())
			return false;
		else
			return true;
	}
	
	public void clickOnShoppingCartButton() {
		shoppingCartButton.click();
	}

	
	public void setIPhoneQty(int iPhone) {
		iPhoneQty.clear();
		iPhoneQty.sendKeys(Integer.toString(iPhone) + Keys.TAB + Keys.ENTER);
	}
	
	public void setMacBookQty(int macBook) {
		macBookQty.clear();
		macBookQty.sendKeys(Integer.toString(macBook) + Keys.TAB + Keys.ENTER);
	}
	
	public String verifyTotalPrice() {
		return totalPrice.getText();
	}
}
