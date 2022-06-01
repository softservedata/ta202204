package com.softserve.homework12;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.HomePage;

public class CurrencyTest extends TestRunner{

	@Test
	public void checkCurrency() {
		// Steps
		HomePage homePage = loadApplication();
		homePage = homePage.selectCurrency("GBP");
		
		// Check
		Assert.assertEquals(homePage.getCurrencyText() , EXPECTED_CURRENCY);
		Assert.assertTrue(homePage.getCurrencyText().contains(EXPECTED_CURRENCY_CODE));
	}
}
