package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.contactus.ContactUsRepositorySingleton;
import com.softserve.edu.opencart.data.contactus.IContactUs;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.footer.customerservice.SuccessfulEnquiryPage;
import com.softserve.edu.opencart.pages.footer.customerservice.UnsuccessfulEnquiryPage;

//import io.qameta.allure.Description;
//import io.qameta.allure.Issue;
//import io.qameta.allure.Link;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import io.qameta.allure.Story;
//import io.qameta.allure.TmsLink;

public class ContactUsTest extends TestRunnerStrategy {

	@DataProvider
	public Object[][] dataSuccessful() {
		return new Object[][] { { ContactUsRepositorySingleton.get().guest() }, };
	}

//	@Description("Test Description: Successful Contact Form")
//	@Severity(SeverityLevel.TRIVIAL)
//	@Story("STORY ContactUs Form")
//	@Issue("SSITAGT-1")
//	@Link(name = "LINK goto site", url = "http://taqc-opencart.epizy.com/?i=1")
//	@TmsLink(value = "TL-680")
	@Test(dataProvider = "dataSuccessful")
	public void checkSuccessfulContactUs(IContactUs validData) {
		
		logger.info("Test Started");
		
		// Steps
		SuccessfulEnquiryPage successfulEnquiry = loadApplication()
				.gotoContactUsPage()
				.successfulEnquiry(validData);
		
		presentationSleep();
		
		// Check
		Assert.assertEquals(successfulEnquiry.getSuccessMessageText(), 
				SuccessfulEnquiryPage.EXPECTED_MESSAGE);
		
		logger.info("Successful Enquiry");
		
		HomePage homePage = successfulEnquiry
				.gotoContinue();
				
		// Check
		Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.EXPECTED_IPHONE6));
		presentationSleep();
		
		logger.info("Test Finished");
		
	}
	
	@DataProvider
	public Object[][] dataUnsuccessful() {
		return new Object[][] { { ContactUsRepositorySingleton.get().invalidData() }, };
	}

//	@Description("Test Description: Unsuccessful Contact Form")
//	@Severity(SeverityLevel.MINOR)
//	@Story("STORY ContactUs Form")
//	@Issue("SSITAGT-1")
//	@Link(name = "LINK goto site", url = "http://taqc-opencart.epizy.com/?i=1")
//	@TmsLink(value = "TL-685")
	@Test(dataProvider = "dataUnsuccessful")
	public void checkUnsuccessfulContactUs(IContactUs invalidData) {
		
		logger.info("Test Started");
		
		// Steps
		UnsuccessfulEnquiryPage unsuccessfulEnquiryPage = loadApplication()
				.gotoContactUsPage()
				.unsuccessfulEnquiry(invalidData);
		presentationSleep();
		
		// Check
		Assert.assertEquals(unsuccessfulEnquiryPage
				.getErrorYourNameText(), 
				UnsuccessfulEnquiryPage.EXPECTED_YOURNAME_ERROR_MESSAGE);
		logger.info("Incorrect Name Entered");
		
		Assert.assertEquals(unsuccessfulEnquiryPage
				.getErrorEmailText(), 
				UnsuccessfulEnquiryPage.EXPECTED_EMAIL_ERROR_MESSAGE);
		logger.info("Incorrect Email Entered");
		
		Assert.assertEquals(unsuccessfulEnquiryPage
				.getErrorEnquiryText(), 
				UnsuccessfulEnquiryPage.EXPECTED_ENQUIRY_ERROR_MESSAGE);
		logger.info("Incorrect Enquiry Entered");
		
		HomePage homePage = unsuccessfulEnquiryPage
				.gotoHomePage();
				
		// Check
		Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.EXPECTED_IPHONE6));
		presentationSleep();
		
		logger.info("Test Finished\n");
		
	}
	
}