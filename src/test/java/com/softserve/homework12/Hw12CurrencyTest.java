package com.softserve.homework12;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hw12CurrencyTest extends TestRunner {
    @Test
    public void checkCurrency () {
        HomePage homepage = loadApplication()
                .chooseCurrency(Currencies.US_DOLLAR);

        Assert.assertTrue(homepage.getCurrencyText().contains("$"));
    }
}
