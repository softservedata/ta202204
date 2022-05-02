package com.softserve.edu.homework03;
/*
    3.2) Написати unit тест на метод numberBrackets(). В тесті замокати verifyBrackets()
    Для коду використати пакет com.softserve.homework03
    Запушати код на github у свою вітку.
*/

import com.softserve.edu.homework01.BracketsAppImp;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NumberBracketsTests {
    private BracketsAppImp bracketsAppSpy;
    private BracketsAppImp bracketsAppMock;

    @BeforeClass
    public void prepareMocks() {
        this.bracketsAppSpy = Mockito.spy(BracketsAppImp.class);
        this.bracketsAppMock = Mockito.mock(BracketsAppImp.class);
    }

    @Test
    public void calculateBracketsCountSpyBefore() {
        Mockito.doReturn(true).when(this.bracketsAppSpy).verifyBrackets("((((()");
        Mockito.doReturn(true).when(this.bracketsAppSpy).verifyBrackets("");

        Assert.assertEquals(this.bracketsAppSpy.numberBrackets("((((()"), 6);
        Assert.assertEquals(this.bracketsAppSpy.numberBrackets(""), 0);
    }

    @Test
    public void calculateBracketsCountSpyAfter() {
        Mockito.when(this.bracketsAppSpy.verifyBrackets("((((")).thenReturn(true);

        Assert.assertEquals(this.bracketsAppSpy.numberBrackets("(((("), 4);
    }

    @Test
    public void calculateBracketsCountMock() {
        Mockito.when(this.bracketsAppMock.verifyBrackets(")")).thenReturn(true);
        Mockito.when(this.bracketsAppMock.verifyBrackets("")).thenReturn(true);
        Mockito.doCallRealMethod().when(this.bracketsAppMock).numberBrackets(ArgumentMatchers.anyString());

        Assert.assertEquals(this.bracketsAppMock.numberBrackets(")"), 1);
        Assert.assertEquals(this.bracketsAppMock.numberBrackets(""), 0);
    }
}
