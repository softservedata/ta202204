package com.softserve.edu.homework12.test;

import com.softserve.edu.homework12.data.Currencies;
import com.softserve.edu.homework12.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Currency;

public class SelectCurrencyTest extends TestRunner {

    @DataProvider(parallel = true)

    public Object[][] searchCurrencies() {
        return new Object[][] {
                { Currencies.EURO },
                //{Currencies.POUND_STERLING},
        };
    }


 @Test(dataProvider = "searchCurrencies")
    public void checkCurrency(Currencies currency) {
        //
        // Steps
        HomePage homePage = loadApplication()
                .chooseCurrency(currency);
        presentationSleep();
        //
        // Check
        Assert.assertTrue(homePage.getCurrencyText().contains(Currencies.EUR));
        //
        presentationSleep(4);
    }

}
