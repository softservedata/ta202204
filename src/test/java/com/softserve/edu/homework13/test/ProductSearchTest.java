package com.softserve.edu.homework13.test;

import com.softserve.edu.test.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.data.SearchProduct;
import com.softserve.edu.data.SearchProductRepository;
import com.softserve.edu.pages.HomePage;

public class ProductSearchTest extends TestRunner {

    @DataProvider
    public Object[][] searchProducts() {
        return new Object[][] {
                //{ SearchProductRepository.getMacDollar() },
                { SearchProductRepository.getCanonDollar() },
                //{ SearchProductRepository.getMacPoundSterling() },
        };
    }

    @Test(dataProvider = "searchProducts")
    public void checkFirst(SearchProduct searchProduct) {
        //
        // Steps
        HomePage homePage = loadApplication()
                .chooseCurrency(searchProduct.getCurrency())
                .scrollToProduct(searchProduct.getProduct());
        presentationSleep();
        //
        // Check
        Assert.assertTrue(homePage
                .getProductComponentsContainer()
                .getProductComponentPriceByName(searchProduct.getProduct())
                .contains(searchProduct.getPrice()));
        //
        presentationSleep(2);
    }
}