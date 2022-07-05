package com.softserve.edu.opencart.pages.footer.customerservice;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.contactus.IContactUs;
import com.softserve.edu.opencart.pages.TopPart;
import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class ContactUsPage extends TopPart {

	protected Search search;

	private WebElement yourname;
	private WebElement email;
	private WebElement enquiry;
	private WebElement submitbutton;

	// public LoginPage(WebDriver driver) {
	public ContactUsPage() {
		// super(driver);
		search = SearchStrategy.getSearch();
		initElements();
	}

	private void initElements() {
		yourname = search.id("input-name");
		email = search.id("input-email");
		enquiry = search.id("input-enquiry");
		submitbutton = search.cssSelector(".btn.btn-primary");
	}

	// Page Object

	// yourname
	public WebElement getYourName() {
		return yourname;
	}

	public String getYourNameText() {
		return getYourName().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clearYourNameField() {
		getYourName().clear();
	}

	public void clickYourNameField() {
		getYourName().click();
	}

	public void setPassword(String yourname) {
		getYourName().sendKeys(yourname);
	}

	// email
	public WebElement getEmail() {
		return email;
	}

	public String getEmailText() {
		return getEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clearEmailField() {
		getEmail().clear();
	}

	public void clickEmailField() {
		getEmail().click();
	}

	public void setEmail(String email) {
		getEmail().sendKeys(email);
	}

	// enquiry
	public WebElement getEnquiry() {
		return enquiry;
	}

	public String getEnquiryText() {
		return getEnquiry().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clearEnquiryField() {
		getEnquiry().clear();
	}

	public void clickEnquiryField() {
		getEnquiry().click();
	}

	public void setEnquiry(String enquiry) {
		getEnquiry().sendKeys(enquiry);
	}

	// submitbutton
	public WebElement getSubmitButton() {
		return submitbutton;
	}

	public String getSubmitButtonText() {
		return getSubmitButton().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clickSubmitButton() {
		getSubmitButton().click();
	}

	// Functional

	private void enterYourName(String yourname) {
		clickYourNameField();
		setPassword(yourname);
	}
	
	private void enterEmail(String email) {
		clickEmailField();
		setEmail(email);
	}
	
	private void enterEnquiry(String enquiry) {
		clickEnquiryField();
		setEnquiry(enquiry);
	}

	public void fillData(IContactUs data) {
		enterYourName(data.getYourName());
		enterEmail(data.getEmail());
		enterEnquiry(data.getEnquiry());
		clickSubmitButton();
	}

	// Business Logic

	public SuccessfulEnquiryPage successfulEnquiry(IContactUs validData) {
		fillData(validData);
		return new SuccessfulEnquiryPage();
	}

	public UnsuccessfulEnquiryPage unsuccessfulEnquiry(IContactUs invalidData) {
		fillData(invalidData);
		return new UnsuccessfulEnquiryPage();
	}

}
