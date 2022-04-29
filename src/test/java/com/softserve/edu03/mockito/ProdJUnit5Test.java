package com.softserve.edu03.mockito;

import com.softserve.edu03.dao.IProductDao;
import com.softserve.edu03.dao.ProductDao;
import com.softserve.edu03.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;

@PrepareForTest(ProductService.class)
@ExtendWith(MockitoExtension.class)
//@RunWith(PowerMockRunner.class)
//@RunWith(JUnitPlatform.class)
//@ExtendWith(PowerMockExtension.class)s
public class ProdJUnit5Test { //extends PowerMockTestCase {

    //@Test
    public void checkMockito() throws Exception {
        IProductDao productDao = Mockito.mock(ProductDao.class); // = Mockito.mock(IProductDao.class)
        Mockito.when(productDao.getIPAddress()).thenReturn(".123");
        ProductService productService = new ProductService(productDao);
        //
        String actual;
        String expected;
        //
        expected = "123";
        actual = productService.getLastDigits();
        //
        Assertions.assertEquals(actual, expected, "LastDigits ERROR");
    }

    @Test
    public void checkConstructor() throws Exception {
        ProductDao productDao = PowerMockito.mock(ProductDao.class);
        PowerMockito.when(productDao.getIPAddress()).thenReturn(".123");
        //
        PowerMockito.whenNew(ProductDao.class).withNoArguments().thenReturn(productDao);
        ProductService productService = new ProductService();
        //
        String actual;
        String expected;
        //
        expected = "123";
        actual = productService.getLastDigits();
        //
        Assert.assertEquals(actual, expected, "LastDigits ERROR");
    }
}
