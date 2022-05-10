package com.softserve.hw2;

import com.softserve.hw1.Brackets;
import org.junit.Assert;
import org.junit.Test;

public class BracketsTests {
    Brackets BracketsTests = new Brackets();

    @Test
    public void verifyBracketsCorrect() {
        Assert.assertTrue(BracketsTests.verifyBrackets("()"));
        Assert.assertTrue(BracketsTests.verifyBrackets("(())"));
        Assert.assertTrue(BracketsTests.verifyBrackets("(())()"));
    }

    @Test
    public void verifyBracketsFalse() {
        Assert.assertFalse(BracketsTests.verifyBrackets("(()"));
        Assert.assertFalse(BracketsTests.verifyBrackets(")("));
        Assert.assertFalse(BracketsTests.verifyBrackets("())"));
        Assert.assertFalse(BracketsTests.verifyBrackets(""));
    }
}