package com.opencart.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.softserve.utilities.CaptureScreenshot;
import com.softserve.utilities.PageActions;

public class GridFilteringPage {
	WebDriver driver;
	PageActions action;
	private static final Logger log = LogManager.getLogger(GridFilteringPage.class.getName());

	@FindBy(css="button.cookie-module--button--3dBOi")
	WebElement cookiesButton;

	@FindBy(xpath="//div[contains(@data-options,'{\"path\":\"/demo/grid-filtering/filter-row\"')]//iframe")
	WebElement uncontrolledFrame;

	@FindBy(xpath="//div[contains(@data-options,'/filter-row/material-ui/light/clean')]//span[contains(text(),'City')]/../../../../following-sibling::tr/th[3]//input[contains(@class,'Editor-input')]")
	WebElement cityTextbox;

	@FindBy(xpath="//td[contains(text(),'Sandra')]/following-sibling::td[contains(text(),'Las Vegas')]")
	WebElement sLasVegas;

	@FindBy(xpath="//td[contains(text(),'Robert')]/following-sibling::td[contains(text(),'Las Vegas')]")
	WebElement rLasVegas;

	@FindBy(xpath="//td[contains(text(),'Lisa')]/following-sibling::td[contains(text(),'London')]")
	WebElement lLondon;

	public GridFilteringPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new PageActions(driver);
	}

	public void acceptCookies() {
		try {
			action.clickButton(cookiesButton);
			log.info("Cookies are accepted");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void searchCity(String city) {
		try {
			driver.switchTo().frame(uncontrolledFrame);
			action.enterDataIntoTextbox(cityTextbox, city);
			log.info("\'{s}\' is typed", city);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public boolean verifyFilteredCities() {
		if(!sLasVegas.isDisplayed() || !rLasVegas.isDisplayed() || !lLondon.isDisplayed()) {
			log.error("Some cities have not been filtered");
			return false;
		}
		else
			return true;
	}
}
