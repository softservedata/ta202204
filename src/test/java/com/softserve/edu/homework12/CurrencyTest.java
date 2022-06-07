package com.softserve.edu.homework12;

/*
  12.1) Скопіювати файли з вітки testpage.
  Написати в пакеті com.softserve.edu.opencart.pages новий клас CurrencyDropdown, який відповідає випадаючому вікну з вибором валюти.
  Додати CurrencyDropdown як поле у клас TopPart. Додати відповідні методи створення та кліків по аналогії з GuestDropdown.
  Написати тестовий метод в якому зайти на сторінку HomePage, вибрати потрібну валюту та перевірити вибір.
  Дотримуватися підгоду PageObject.
  Для коду використати пакет com.softserve.homework12
  Запушати код на github у свою вітку.
*/

import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.tests.TestRunnerFirst;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyTest extends TestRunnerFirst {
    @Test
    public void checkCurrency() {
        HomePage homePage = loadApplication().clickCurrency();

        homePage.createDropdownCurrency();
        homePage.clickDropdownCurrencyUsDollar();

        String actual = homePage.getCurrencyText();
        String expected = "$ Currency";

        Assert.assertEquals(actual, expected);
    }
}