package com.softserve.homework03;

import org.testng.Assert;
import com.softserve.homework03.brackets.Brackets03;
import com.softserve.homework03.symbols.ISymbols;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class App03Test {

    @BeforeMethod
    public void setUp() {
        System.out.println("Start running tests.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Finish running tests.");
    }
    @Test
    public void numberBracketsTest () {
        ISymbols symbolsTest = PowerMockito.mock(ISymbols.class);
        PowerMockito.when(symbolsTest.verifyBrackets(Mockito.anyString())).thenReturn(true);
        Brackets03 bracketTest = new Brackets03(symbolsTest);
        //
        int actual;
        int expected;
        //
        expected = 4;
        actual = bracketTest.numberBrackets("test()()");
        Assert.assertEquals(actual, expected, "even number tested");
        //
        expected = 3;
        actual = bracketTest.numberBrackets("test)try(catch)");
        Assert.assertEquals(actual, expected, "uneven number tested");
    }
}