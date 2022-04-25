package com.softserve.edu.homework02;

/*
    1) Склонувати репозиторій, створити та перейти у свою вітку
    В cmd перейти в якусь папку та склонувати проект
    git clone https://github.com/softservedata/ta202204.git
    Перейти в папку ta202204 (всі дій з командою git.exe виконувати з цієї папки)
    cd ta202204
    Перевірити вітку
    git branch
    Повинні отримати main
    Створити нову вітку (назвати так, щоб можна було ідентифікувати автора)
    git branch MYBRANCH
    Перейти у свою вітку
    git checkout MYBRANCH
    Додати java файли першого завдання
    Проіндексувати
    git add .
    Закоммітити у локальний репозиторій
    git commit -m "MESSAGE"
    Запушти код у свою вітку на github
    git push origin MYBRANCH

    2) На базі JUnit написати тестовий клас з методами для тестування методу verifyBrackets() першого завдання.
    Для коду використати пакет com.softserve.homework02 у тестовій вітці.
    Запушати код на github у свою вітку.
 */

import com.softserve.edu.homework01.BracketsApp;
import com.softserve.edu.homework01.BracketsAppImp;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppBracketsTests {
    private static final ByteArrayOutputStream testStream = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static BracketsApp bracketsApp;

    @BeforeClass
    public static void prepareBracketsApp() {
        System.setOut(new PrintStream(AppBracketsTests.testStream));
        AppBracketsTests.bracketsApp = new BracketsAppImp();
    }

    @AfterClass
    public static void finishBracketsApp() {
        System.setOut(AppBracketsTests.originalOut);
    }

    @After
    public void resetStream() {
        AppBracketsTests.testStream.reset();
    }

    @Test
    public void verifyBracketsSuccessResult() {
        Assert.assertTrue(AppBracketsTests.bracketsApp.verifyBrackets("()"));
        Assert.assertTrue(AppBracketsTests.bracketsApp.verifyBrackets("(())"));
        Assert.assertTrue(AppBracketsTests.bracketsApp.verifyBrackets("(())()"));
        Assert.assertTrue(AppBracketsTests.bracketsApp.verifyBrackets("aa()"));
        Assert.assertTrue(AppBracketsTests.bracketsApp.verifyBrackets("aa(__)dsadasdas(dsadas())"));
    }

    @Test
    public void verifyBracketsErrorResult() {
        Assert.assertFalse(AppBracketsTests.bracketsApp.verifyBrackets("(()"));
        Assert.assertFalse(AppBracketsTests.bracketsApp.verifyBrackets(")("));
        Assert.assertFalse(AppBracketsTests.bracketsApp.verifyBrackets("())"));
        Assert.assertFalse(AppBracketsTests.bracketsApp.verifyBrackets("aa"));
        Assert.assertFalse(AppBracketsTests.bracketsApp.verifyBrackets(""));
    }

    @Test
    public void printErrorMessage() {
        Assert.assertFalse(AppBracketsTests.bracketsApp.verifyBrackets(""));
        Assert.assertEquals("Text doesn't have bracket!", AppBracketsTests.testStream.toString().trim());
    }

    @Test
    public void noPrintErrorMessage() {
        AppBracketsTests.bracketsApp.verifyBrackets("(");
        AppBracketsTests.bracketsApp.verifyBrackets(")");
        AppBracketsTests.bracketsApp.verifyBrackets("()");
        Assert.assertEquals("", AppBracketsTests.testStream.toString().trim());
    }
}
