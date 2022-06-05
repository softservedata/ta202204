package com.softserve.edu.homework11;

/*
    11.1) Зайти на сайт http://taqc-opencart.epizy.com/
    Додати до корзини Apple Cinema 30"
    P.S. Після натискання кнопки ADD TO CART потрібно заповнити форму.
    //Вирішити питання з Upload File.
    Для коду використати пакет com.softserve.homework11
    Запушати код на github у свою вітку.
 */

import com.softserve.edu.sites.opencart.pages.FeatureComponent;
import com.softserve.edu.sites.opencart.pages.NotificationComponent;
import com.softserve.edu.sites.opencart.pages.ProductForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FillFormTest {
    private final String baseUrl = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;
    private Integer implicitlyWaitSeconds = 10;
    private FeatureComponent featureComponent;
    private ProductForm productForm;
    private NotificationComponent notificationComponent;

    @BeforeTest
    public void BeforeTest() {
        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(this.implicitlyWaitSeconds));
        this.driver.manage().window().maximize();
        this.driver.get(this.baseUrl);
        this.featureComponent = new FeatureComponent(this.driver);
        this.productForm = new ProductForm(this.driver);
        this.notificationComponent = new NotificationComponent(this.driver);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void addToCart() {
        this.featureComponent.clickCartButton("42");
        this.productForm.clickSizeRadioButton("6");
        this.productForm.clickCheckbox("8");
        this.productForm.clearTextField();
        this.productForm.setTextField("Some text 1");
        this.productForm.selectColor("3");
        this.productForm.setTextArea("Some text 2");

        this.productForm.uploadFile();

        this.productForm.clearDate();
        this.productForm.setDate("2022-07-05");
        this.productForm.clearTime();
        this.productForm.setTime("22:30");
        this.productForm.clearDateTime();
        this.productForm.setDateTime("2011-02-21 18:25");
        this.productForm.clearQty();
        this.productForm.setQty("3");

        this.productForm.clickAddToCartButton();

        String actual = this.notificationComponent.getSuccessAlertText();
        String expected = "You have added Apple Cinema 30";
        Assert.assertTrue(actual.contains(expected));
    }
}
