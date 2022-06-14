package com.softserve.hw12;

import com.opencart.pages.HomePage;
import org.junit.jupiter.api.*;

public class ChooseCurrency extends TestRunner{
    @Test
    public void chooseCurrency() {

        HomePage homePage = loadApplication();
        homePage.selectCurrencyPoundSterling();

        Assertions.assertTrue(priceInGBP.getText().contains(EXPECTED));
    }
}
