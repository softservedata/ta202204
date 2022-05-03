package com.softserve.edu.homework02;

import com.softserve.edu.homework01.VerifyBrackets;
import org.junit.Assert;
import org.junit.Test;

public class VerifyBracketsTest {
    VerifyBrackets testBrackets = new VerifyBrackets();

    @Test
    public void testIsCorrectBracketsTrue() {
        Assert.assertTrue(testBrackets.isCorrectBrackets("Correct (brackets)()"));
        Assert.assertTrue(testBrackets.isCorrectBrackets("()"));
        Assert.assertTrue((testBrackets.isCorrectBrackets("((()))")));
        Assert.assertTrue(testBrackets.isCorrectBrackets("Text {(with) [several] type of (brackets)}"));
    }

    @Test
    public void testIsCorrectBracketsFalse(){
        Assert.assertFalse(testBrackets.isCorrectBrackets("((("));
        Assert.assertFalse(testBrackets.isCorrectBrackets("Test (text "));
        Assert.assertFalse(testBrackets.isCorrectBrackets(")(("));
        Assert.assertFalse(testBrackets.isCorrectBrackets("((())()"));
    }
}
