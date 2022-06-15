package com.softserve.homework12;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.tests.TestRunnerStrategy;

// public class CurrencyTest extends TestRunnerFirst{
public class CurrencyTest extends TestRunnerStrategy {

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
