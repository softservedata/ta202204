package com.softserve.utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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
	JavascriptExecutor js;
	
	public PageActions(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	
	public void clickButton(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			//js.executeScript("window.scrollBy(0, 200);");
			//action.moveToElement(element).build().perform();
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
			wait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			//action.moveToElement(element).build().perform();
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
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			//action.moveToElement(element).build().perform();
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
