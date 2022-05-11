package com.softserve.homework02;

import com.softserve.homework01.Main;
import org.junit.jupiter.api.Assertions;

public class Test {
    Main main = new Main();

    @org.junit.Test
    public void firstTest() {
        Assertions.assertTrue(main.verifyBrackets("()"));
    }

    @org.junit.Test
    public void secondTest() {
        Assertions.assertFalse(main.verifyBrackets(")("));

    }
    @org.junit.Test
    public void thirdTest() {
        Assertions.assertEquals(main.numberBrackets("()"), 2);

    }
}
