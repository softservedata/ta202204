package com.softserve.edu.homework14;

/*
    14.1) Скопіювати файли з вітки testpage.
    Написати в пакеті com.softserve.edu.opencart.pages клас RegisterPage.
    Підготувати тестовий метод для перевірки функціоналу реєстрації нового користувача.
    Дотримуватися підходу PageObject.
    Для коду використати пакет com.softserve.homework14
    Запушати код на github у свою вітку.
 */

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.RegisterPage;
import com.softserve.edu.opencart.tests.TestRunnerFirst;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends TestRunnerFirst {

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][]{
            {UserRepository.getNewUser()},
        };
    }

    @Test(dataProvider = "dataSuccessful")
    //public void checkSuccessful(String email, String password, String firstName) {
    public void checkSuccessful(IUser validNewUser) {
        HomePage homePage = loadApplication();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.successfulRegister(validNewUser);

        Assert.assertEquals(registerPage.getSuccessMessageText(), registerPage.successRegistrationMessage);
    }
}
