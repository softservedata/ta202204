package com.softserve.hw13;

import com.opencart.pages.ProductsContainer;
import org.junit.Test;
import org.testng.Assert;

public class ProductPresence extends TestRunnerStrategy {

    @Test
    public void checkProductPresence() {
        loadApplication();
        ProductsContainer product = new ProductsContainer();
        Assert.assertTrue(product.checkProductPresence("iPhone 3"));
    }
}
