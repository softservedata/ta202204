package com.softserve.homework13;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.ProductsContainer;
import com.softserve.edu.opencart.tests.TestRunnerFirst;

public class ProductPresenceTest extends TestRunnerFirst{

	@Test
	public void checkCurrency() {
		// Steps
		loadApplication();
		ProductsContainer product = new ProductsContainer(driver);
		
		// Check
		Assert.assertTrue(product.isProductComponentPresent(PRODUCT_NAME));
		Assert.assertEquals(product.getProductComponentName(PRODUCT_NAME), PRODUCT_NAME);
	}
}
