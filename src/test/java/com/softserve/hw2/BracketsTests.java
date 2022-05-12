package com.softserve.hw2;

import com.softserve.hw1.Brackets;
import org.junit.Assert;
import org.junit.Test;

public class BracketsTests {
    Brackets bracketsTests = new Brackets();

    @Test
    public void verifyBracketsCorrect() {
        Assert.assertTrue(bracketsTests.verifyBrackets("()"));
        Assert.assertTrue(bracketsTests.verifyBrackets("(())"));
        Assert.assertTrue(bracketsTests.verifyBrackets("(())()"));
    }

    @Test
    public void verifyBracketsFalse() {
        Assert.assertFalse(bracketsTests.verifyBrackets("(()"));
        Assert.assertFalse(bracketsTests.verifyBrackets(")("));
        Assert.assertFalse(bracketsTests.verifyBrackets("())"));
    }
}