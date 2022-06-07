package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.ProductsContainer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductContainerTests extends TestRunnerFirst{
	
	@Test
	public void checkProductIsDisplayed() {
		loadApplication();
		ProductsContainer productsContainer = new ProductsContainer(driver);
		Assert.assertTrue(productsContainer.checkProductIsDisplayed("Canon EOS 5D"));
	}
	
}
