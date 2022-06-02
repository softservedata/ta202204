package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.CurrencyDropdown;
import com.softserve.edu.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends TestRunnerFirst {

    @Test
    public void checkHome() {
        // Steps
        HomePage homePage = loadApplication();
        presentationSleep();
        //
        // Check
        Assert.assertEquals(homePage.getSlideshow0FirstImageAttributeAltText(), HomePage.EXPECTED_IPHONE_6);
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }

    @Test
    public void checkEurCurrency() {
        HomePage homePage = loadApplication();
        homePage.selectEurCurrency(); // NullPointer on eurCurrency element initialization (CurrencyDropdown->initElement())
        //homePage.gotoCurrencyDropdown();
<<<<<<< HEAD
        CurrencyDropdown currencyDropdown = currencyDropdownLoading();//NullPointerException
        currencyDropdown.selectEurCurrency();
        Assert.assertTrue(currencyDropdown.getEurCurrencyText().contains(CurrencyDropdown.EUR));
=======
        /*CurrencyDropdown currencyDropdown = currencyDropdownLoading();//NullPointerException
        currencyDropdown.selectEurCurrency();
        Assert.assertTrue(currencyDropdown.getEurCurrencyText().contains(CurrencyDropdown.EUR));*/
>>>>>>> 5377b8bdf4b41443c4c91dc22bb1a740512d60c6
        //=c
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        // Assert.assertEquals();
        
    }

}
