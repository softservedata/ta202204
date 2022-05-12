package com.opencart;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TotalPrice {
	
	WebDriver driver;
	// Actions action;
	
	@FindBy(css="#form-currency button[data-toggle=dropdown]")
	WebElement currencyTab;
	
	@FindBy(css="#form-currency button[name=USD]")
	WebElement currencyButton;
	
	@FindBy(css="#search input[name=search]")
	WebElement searchField;
	
	@FindBy(css="button[onclick*=\"cart.add('43'\"]")
	WebElement addMacBookToCartButton;
	
	@FindBy(css=".button-group button[onclick*='cart.add']")
	WebElement addIPhoneToCartButton;
	
	@FindBy(css="#cart>button")
	WebElement cartButton;
	
	@FindBy(css="img[alt='iPhone 3'][class*='thumbnail']")
	WebElement iPhoneImg;
	
	@FindBy(css="img[alt='MacBook'][class*='thumbnail']")
	WebElement macBookImg;
	
	@FindBy(css="#top-links a[href*='checkout/cart']")
	WebElement shoppingCartButton;
	
	@FindBy(css="form[action*='checkout'] tbody>tr:first-child>td:nth-child(4)>div>input")
	WebElement iPhoneQty;
	
	@FindBy(css="form[action*='checkout'] tbody>tr:last-child>td:nth-child(4) input")
	WebElement macBookQty;
	
	@FindBy(css="div.col-sm-4.col-sm-offset-8>table.table.table-bordered tr:last-child>td:last-child")
	WebElement totalPrice;
	
	public TotalPrice(WebDriver driver) {
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
		if(!iPhoneImg.isEnabled() || !macBookImg.isEnabled())
			return false;
		else
			return true;
	}
	
	public void clickOnShoppingCartButton() {
		shoppingCartButton.click();
	}

	
	public void setIPhoneQty(int iPhone) {
		// action.moveToElement(iPhoneQty);
		iPhoneQty.clear();
		iPhoneQty.sendKeys(Integer.toString(iPhone) + Keys.TAB + Keys.ENTER);
	}
	
	public void setMacBookQty(int macBook) {
		// action.moveToElement(macBookQty);
		macBookQty.clear();
		macBookQty.sendKeys(Integer.toString(macBook) + Keys.TAB + Keys.ENTER);
	}
	
	public String verifyTotalPrice() {
		// action.moveToElement(totalPrice);
		return totalPrice.getText();
	}
}
