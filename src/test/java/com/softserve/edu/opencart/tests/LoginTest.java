package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.EditAccountPage;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

// public class LoginTest extends TestRunner{
public class LoginTest extends TestRunnerStrategy{

    /*
    @DataProvider//(parallel = true)
    public Object[][] dataSuccessful() {
        return new Object[][] {
            { "xdknxusqvjeovowpfk@awdrt.com", "awdrt123", "my" },
            { "hahaha@gmail.com", "qwerty", "hahaha" },
        };
    }
    */

    @DataProvider(parallel = true)
    public Object[][] dataSuccessful() {
        return new Object[][] {
                { UserRepository.getHahaha() },
                //{ UserRepository.getAwdrt() },
        };
    }

    @Description("Test Description: Successful Login")
    @Severity(SeverityLevel.CRITICAL)
    @Story("STORY SearchAllureTest")
    @Issue("SSITAGT-1")
    @Link(name = "LINK goto site", url = "http://taqc-opencart.epizy.com/?i=1")
    @TmsLink(value = "TL-678")
    @Test(dataProvider = "dataSuccessful")
    //public void checkSuccessful(String email, String password, String firstName) {
    public void checkSuccessful(IUser validUser) {
        //
    	logger.info("Test Started");
        // Steps
        EditAccountPage editAccountPage = loadApplication()
                .gotoLoginPage()
                //.successfulLogin(email, password)
                .successfulLogin(validUser)
                .gotoEditAccountRight();
        presentationSleep();
        //
        // Check
        //Assert.assertEquals(editAccountPage.getFirstNameFieldText(), firstName);
        Assert.assertEquals(editAccountPage.getFirstNameFieldText(), validUser.getFirstname());
        
        SearchStrategy.setExplicitStrategy();
        //
        // Return to Previous State
        HomePage homePage = editAccountPage
                .gotoContinue() // optional
                .gotoLogoutRight()
                .gotoContinue();
        //
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
        logger.info("Test Finished");
    }

    /*
    @DataProvider//(parallel = true)
    public Object[][] dataUnsuccessful() {
        return new Object[][] {
                { "xdknx@awdrt.com", "aw123" },
                { "hah@gmail.com", "qwy" },
        };
    }
    */

    @DataProvider//(parallel = true)
    public Object[][] dataUnsuccessful() {
        return new Object[][] {
                { UserRepository.getInvalidUser() },
        };
    }

    //@Test(dataProvider = "dataUnsuccessful")
    //public void checkUnsuccessful(String emailInvalid, String passwordInvalid) {
    public void checkUnsuccessful(IUser invalidUser) {
        //
        // Steps
        UnsuccessfulLoginPage unsuccessfulLoginPage = loadApplication()
                .gotoLoginPage()
                //.unsuccessfulLoginPage(emailInvalid, passwordInvalid);
                .unsuccessfulLoginPage(invalidUser);
        presentationSleep();
        //
        // Check
        Assert.assertTrue(unsuccessfulLoginPage.getAlertWarningText()
                .contains(UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE));
        //
        // Return to Previous State
        HomePage homePage = unsuccessfulLoginPage
                .gotoHomePage();
        //
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
    }

    //@Test
    public void checkHome() {
        // Steps
        HomePage homePage = loadApplication();
        presentationSleep();
        //
        // Check
        Assert.assertEquals(homePage.getSlideshow0FirstImageAttributeAltText(), HomePage.EXPECTED_IPHONE_6);
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }
}
