package com.softserve.homework13;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.ProductsContainer;
import com.softserve.edu.opencart.tests.TestRunnerStrategy;

// public class ProductPresenceTest extends TestRunnerFirst{
public class ProductPresenceTest extends TestRunnerStrategy {

	@Test
	public void checkCurrency() {
		// Steps
		loadApplication();
		// ProductsContainer product = new ProductsContainer(driver);
		ProductsContainer product = new ProductsContainer();
		
		// Check
		Assert.assertTrue(product.isProductComponentPresent(PRODUCT_NAME));
		Assert.assertEquals(product.getProductComponentName(PRODUCT_NAME), PRODUCT_NAME);
	}
}
