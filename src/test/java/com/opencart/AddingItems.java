package com.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingItems {
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'MacBook')]/../../following-sibling::div/button[1]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement cartButton;
	
	@FindBy(xpath="//p[@class='text-right']//i[@class='fa fa-shopping-cart']")
	WebElement viewCartButton;
	
	@FindBy(xpath="//div[@class='table-responsive']//a[contains(@href,'id=43') and contains(text(),'MacBook')]")
	WebElement itemToVerify;
	
	public AddingItems(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	
	public void clickOnCartButton() {
		cartButton.click();
	}
	
	public void clickOnViewCartButton() {
		viewCartButton.click();
	}
	
	public String getItem() {
		WebElement item = itemToVerify;
		return item.getText();
	}

}
