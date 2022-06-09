package com.softserve.edu.homework13;

/*
    13.1) Скопіювати файли з вітки testpage.
    Написати в пакеті com.softserve.edu.opencart.pages класи
    ProductComponent який відповідає елементу продукту на головній сторінці та
    ProductsContainer який містить список ProductComponent.
    Підготувати тестовий метод, в якому перевірити присутність продукта на сторінці.
    Дотримуватися підходу PageObject.
    Для коду використати пакет com.softserve.homework13
    Запушати код на github у свою вітку.
 */

import com.softserve.edu.opencart.tests.TestRunnerMy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPresenceTest extends TestRunnerMy {

    @Test
    public void verifyProductIsFound() {
        String expected = "iPhone 3";
        String actual = loadApplication()
            .getProductsContainer()
            .getProductComponentsByName("iPhone 3")
            .getNameText();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void verifyProductIsNotFound() {
        Assert.expectThrows(RuntimeException.class, () -> {
            loadApplication()
                .getProductsContainer()
                .getProductComponentsByName("Not Found Product");
        });
    }
}
