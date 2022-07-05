package com.softserve.homework15;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.product.Currencies;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.tests.TestRunnerStrategy;

// public class CurrencyTest extends TestRunner{
public class CurrencyTest extends TestRunnerStrategy {

    @DataProvider(parallel = true)
    public Object[][] searchCurrencies() {
        return new Object[][] { 
            { Currencies.EURO, Currencies.EURO.getExpectedEuroSymbol() },
            { Currencies.POUND_STERLING, Currencies.POUND_STERLING.getExpectedPoundSymbol() },
        };
    }
    
    @Test(dataProvider = "searchCurrencies")
    public void checkFirst(Currencies currency, String expectedSign) {
        //
        // Steps
        HomePage homePage = loadApplication()
                //.chooseCurrency("US Dollar");
                .chooseCurrency(currency);
                //.scrollToProduct(searchProduct.getProduct());
        presentationSleep();
        //
        // Check
        Assert.assertTrue(homePage.getCurrencyText().contains(expectedSign));
        // Assert.assertTrue(homePage.getCurrencyText().contains(currency.getExpectedEuroSign()));
        // Assert.assertTrue(homePage.getCurrencyText().contains(Currencies.EURO.getExpectedEuroSign()));
        //
        presentationSleep(4);
    }
	
}
