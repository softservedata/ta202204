package com.softserve.homework14;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.user.IUser;
import com.softserve.edu.opencart.data.user.UserRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.guest.UnsuccessfulRegisterPage;
import com.softserve.edu.opencart.pages.logged.SuccessfulRegistrationPage;
import com.softserve.edu.opencart.tests.TestRunnerStrategy;

//public class RegisterTest extends TestRunner{
public class RegisterTest extends TestRunnerStrategy{

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][] {
                { UserRepository.getNewUser() },
        };
    }

    @Test(dataProvider = "dataSuccessful")
    //public void checkSuccessful(String email, String password, String firstName) {
    public void checkSuccessful(IUser validNewUser) {
        //
    	// Steps
    	SuccessfulRegistrationPage successfulRegisterPage = loadApplication()
    			.gotoRegisterPage()
    			.successfulRegister(validNewUser);
    	presentationSleep();
    	
    	// Check
    	Assert.assertEquals(successfulRegisterPage.getSuccessMessageText(), SuccessfulRegistrationPage.EXPECTED_REGISTRATION_MESSAGE); // static, correctness
    	Assert.assertTrue(successfulRegisterPage.getSuccessMessageText().contains(SuccessfulRegistrationPage.EXPECTED_REGISTRATION_MESSAGE));
    	
    	// Return to Previous State
    	HomePage homePage = successfulRegisterPage
    			.gotoContinue()
    			.gotoLogoutRight()
    			.gotoContinue();
    	
    	// Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
    	
    }

    @DataProvider//(parallel = true)
    public Object[][] dataUnsuccessful() {
        return new Object[][] {
                { UserRepository.getInvalidUser() },
                { UserRepository.getEmptyNewUser() },
        };
    }

    @Test(dataProvider = "dataUnsuccessful")
    public void checkUnsuccessful(IUser invalidNewUser) {
        
        // Steps
        UnsuccessfulRegisterPage unsuccessfulRegisterPage = loadApplication()
                .gotoRegisterPage()
                .unsuccessfulRegisterPage(invalidNewUser);
        presentationSleep();
        
        // Check
        Assert.assertTrue(unsuccessfulRegisterPage.getAlertWarningText()
                .contains(unsuccessfulRegisterPage.EXPECTED_REGISTER_MESSAGE));
        //
        // Return to Previous State
        HomePage homePage = unsuccessfulRegisterPage
                .gotoHomePage();
        //
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
    }
}
