package com.softserve.homework02;

import com.softserve.homework01.App;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    App main = new App();
    Boolean actual = null;

    @Test
    public void verifyBrackets1() {
        actual = main.verifyBrackets("()");
        Assert.assertTrue(actual);
    }

    @Test
    public void verifyBrackets2() {
        actual = main.verifyBrackets("(())");
        Assert.assertTrue(actual);
    }

    @Test
    public void verifyBrackets3() {
        actual = main.verifyBrackets("(())()");
        Assert.assertTrue(actual);
    }

    @Test
    public void verifyBrackets4() {
        actual = main.verifyBrackets("(()");
        Assert.assertFalse(actual);
    }

    @Test
    public void verifyBrackets5() {
        actual = main.verifyBrackets(")(");
        Assert.assertFalse(actual);
    }

    @Test
    public void verifyBrackets6() {
        actual = main.verifyBrackets("()) ");
        Assert.assertFalse(actual);
    }
}