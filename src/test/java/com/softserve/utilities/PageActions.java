package com.softserve.utilities;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageActions {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	public PageActions(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
		action = new Actions(driver);
	}
	
	public void clickButton(WebElement element) {
		try {
			action.moveToElement(element).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void enterDataIntoTextbox(WebElement element, String text) {
		try {
			action.moveToElement(element).build().perform();
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text + Keys.TAB + Keys.ENTER);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void selectVisibleTextInDropdown(WebElement element, String text) {
		try {
			action.moveToElement(element).build().perform();
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			Select s = new Select(element);
			s.selectByVisibleText(text);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementDataNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}

}
