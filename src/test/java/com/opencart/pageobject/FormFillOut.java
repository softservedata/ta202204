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

public class FormFillOut {
	WebDriver driver;
	PageActions action;
	private static final Logger log = LogManager.getLogger(FormFillOut.class.getName());

	@FindBy(xpath="//a[contains(text(),'Apple Cinema 30')]/../following-sibling::p[contains(text(),'Cinema HD')]/../following-sibling::div//span/..")
	WebElement addCinemaToCartButton;

	@FindBy(css="#input-option218 input[value='7']")
	WebElement sizeRadioButton;

	@FindBy(css="#input-option223 input[value='10']")
	WebElement checkbox;

	@FindBy(id="input-option208")
	WebElement inputTextbox;

	@FindBy(id="input-option217")
	WebElement selectColor;

	@FindBy(id="input-option209")
	WebElement textarea;

	@FindBy(id="button-upload222")
	WebElement uploadFileButton;

	@FindBy(id="input-option219")
	WebElement inputDate;

	@FindBy(css="input[name='option[221]']")
	WebElement inputTime;

	@FindBy(id="input-option220")
	WebElement inputDateTime;

	@FindBy(css="div.input-group.datetime button.btn.btn-default")
	WebElement dateTimeButton;

	@FindBy(css="div.input-group.date button.btn.btn-default")
	WebElement dateButton;

	@FindBy(css="div.input-group.time button.btn.btn-default")
	WebElement timeButton;

	@FindBy(id="input-quantity")
	WebElement inputQuantity;

	@FindBy(css=".container > .alert.alert-success")
	WebElement successMSG;

	@FindBy(id="cart-total")
	WebElement totalPrice;

	public FormFillOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new PageActions(driver);
	}

	public void clickAddCinemaToCart() {
		try {
			action.clickButton(addCinemaToCartButton);
			log.info("Add Apple Cinema to cart button is clicked");
			Thread.sleep(500);
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void selectSizeRadioButton() {
		try {
			action.clickButton(sizeRadioButton);
			log.info("Size is selected");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void selectCheckbox() {
		try {
			action.clickButton(checkbox);
			log.info("Checkbox is selected");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void enterText(String text) {
		try {
			action.enterDataIntoTextbox(inputTextbox, text);
			log.info("Text is typed");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void selectColor(String text) {
		try {
			action.selectVisibleTextInDropdown(selectColor, text);
			log.info("Color is selected");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void enterAdditionalText(String text) {
		try {
			action.enterDataIntoTextbox(textarea, text);
			log.info("Additional text is typed");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void uploadFile(String filePath) {
		try {
			action.clickButton(uploadFileButton);
			action.uploadFileAI(filePath);
			action.uploadFileAI(filePath);
			action.acceptPopUp();
			log.info("File is uploaded");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ButtonNotClickable");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void enterDate(String date) {
		try {
			action.enterDataIntoTextbox(inputDate, date);
			action.clickButton(dateButton);
			log.info("Date is set");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void enterTime(String time) {
		try {
			action.enterDataIntoTextbox(inputTime, time);
			action.clickButton(timeButton);
			log.info("Time is set");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}


	public void enterDateTime(String value) {
		try {
			action.enterDataIntoTextbox(inputDateTime, value);
			action.clickButton(dateTimeButton);
			log.info("Date & Time are set");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void setQuantity(int qty) {
		try {
			action.enterDataIntoTextbox(inputQuantity, Integer.toString(qty));
			log.info("Apple Cinema quantity is set");
			log.info("Apple Cinema is added to the cart");
		}
		catch (Exception e) {
			System.out.println("Exception");
			CaptureScreenshot.takeScreenshot(driver, "ElementNotVisible");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public String verifySuccessMessage() {
		action.messageToBeVisible(successMSG);
		return successMSG.getText();
	}

	public String verifyTotalPrice() throws InterruptedException {
		Thread.sleep(1500);
		//action.elementToBeLoaded(totalPrice);
		//log.info(totalPrice.getText());
		return totalPrice.getText();
	}
}
