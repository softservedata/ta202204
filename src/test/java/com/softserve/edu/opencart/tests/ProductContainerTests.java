package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.ProductsContainer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductContainerTests extends TestRunnerStrategy{
	
	@Test
	public void checkProductIsDisplayed() {
		loadApplication();
		ProductsContainer productsContainer = new ProductsContainer();
		Assert.assertTrue(productsContainer.checkProductIsDisplayed("Canon EOS 5D"));
	}
	
}
