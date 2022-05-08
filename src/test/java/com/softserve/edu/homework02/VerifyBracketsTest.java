package com.softserve.edu.homework02;

import com.softserve.edu.homework01.VerifyBrackets;
import org.junit.Assert;
import org.junit.Test;

public class VerifyBracketsTest {

    VerifyBrackets testBrackets = new VerifyBrackets();

    @Test
    public void testIsCorrectBracketsTrue_1() {
        Assert.assertTrue(testBrackets.isCorrectBrackets("Correct (brackets)()"));
    }

    @Test
    public void testIsCorrectBracketsTrue_2() {
        Assert.assertTrue(testBrackets.isCorrectBrackets("()"));
    }

    @Test
    public void testIsCorrectBracketsTrue_3() {
        Assert.assertTrue((testBrackets.isCorrectBrackets("((()))")));
    }

    @Test
    public void testIsCorrectBracketsTrue_4() {
        Assert.assertTrue(testBrackets.isCorrectBrackets("Text {(with) [several] type of (brackets)}"));
    }

    @Test
    public void testIsCorrectBracketsFalse_1() {
        Assert.assertFalse(testBrackets.isCorrectBrackets("((("));
    }

    @Test
    public void testIsCorrectBracketsFalse_2() {
        Assert.assertFalse(testBrackets.isCorrectBrackets("Test (text "));
    }

    @Test
    public void testIsCorrectBracketsFalse_3() {
        Assert.assertFalse(testBrackets.isCorrectBrackets(")(("));
    }

    @Test
    public void testIsCorrectBracketsFalse_4() {
        Assert.assertFalse(testBrackets.isCorrectBrackets("((())()"));
    }
}
