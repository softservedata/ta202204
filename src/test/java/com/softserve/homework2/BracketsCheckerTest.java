package com.softserve.homework2;

import com.softserve.homework1.BracketsChecker;
import org.junit.Assert;
import org.testng.annotations.Test;

public class BracketsCheckerTest {
    BracketsChecker checker = new BracketsChecker();
    @Test
    public void ValidCasesTest() {
        String str1 = "()";
        String str2 = "((()))";
        String str3 = "()()()";
        String str4 = "()(())()";
        String str5 = "()()((())())";
        Assert.assertTrue(checker.checkBrackets(str1));
        Assert.assertTrue(checker.checkBrackets(str2));
        Assert.assertTrue(checker.checkBrackets(str3));
        Assert.assertTrue(checker.checkBrackets(str4));
        Assert.assertTrue(checker.checkBrackets(str5));
    }

    @Test
    public void emptyStringTest() {
        String str = "";
        Assert.assertFalse(checker.checkBrackets(str));
    }

    @Test
    public void invalidSymbolsTest() {
        String str = "12345678";
        String str2 = "()(())[]";
        String str3 = "{()()}";
        String str4 = "[()())";
        Assert.assertFalse(checker.checkBrackets(str));
        Assert.assertFalse(checker.checkBrackets(str2));
        Assert.assertFalse(checker.checkBrackets(str3));
        Assert.assertFalse(checker.checkBrackets(str4));
    }

    @Test
    public void invalidBracketsOrderTest() {
        String str = ")(";
        String str2 = "()((()))))";
        String str3 = "(()()(";
        String str4 = "((()()";
        Assert.assertFalse(checker.checkBrackets(str));
        Assert.assertFalse(checker.checkBrackets(str2));
        Assert.assertFalse(checker.checkBrackets(str3));
        Assert.assertFalse(checker.checkBrackets(str4));
    }
}
