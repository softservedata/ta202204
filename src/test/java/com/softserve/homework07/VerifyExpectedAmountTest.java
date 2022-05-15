package com.softserve.homework07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyExpectedAmountTest {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private final String baseURL = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;

    private static void delaySec() {
        delaySec(1);
    }

    private static void delaySec(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.navigate().to(baseURL);
    }

    @Test
    public void checkShoppingCartFlow() {
        ShoppingCartFlow shoppingCart = new ShoppingCartFlow(driver);

        final String iphoneName = "iPhone 3";
        final String macBookName = "MacBook";

        shoppingCart.changeCurrency();
        shoppingCart.addProductToCart(macBookName);
        shoppingCart.addProductToCart(iphoneName);
        delaySec();

        shoppingCart.openCartDropDown();

        String cartContent = shoppingCart.getCardDropDownContent();

        Assert.assertTrue(cartContent.contains(macBookName));
        Assert.assertTrue(cartContent.contains(iphoneName));

        shoppingCart.openShoppingCartPage();
        delaySec();

        final int iphoneCartQuantity = 2;
        final int macBookQuantity = 3;

        shoppingCart.changeCartProductQuantity(iphoneName, iphoneCartQuantity ) ;
        shoppingCart.changeCartProductQuantity(macBookName, macBookQuantity);
        delaySec();

        double iphonePrice = shoppingCart.getCartProductPrice(iphoneName);
        double macPrice = shoppingCart.getCartProductPrice(macBookName);
        double totalAmount = (iphonePrice * iphoneCartQuantity )  + (macPrice * macBookQuantity);

        Assert.assertEquals(totalAmount, shoppingCart.getTotalPrice());
    }

    @AfterClass
    public void afterClass() {
       // driver.manage().deleteAllCookies();
        driver.quit();
    }
}
