package com.softserve.homework02;

import com.softserve.homework01.StringVerification;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class StringVerificationTest {
    @Test
    public void testApp() {
        StringVerification service = new StringVerification();

        Assertions.assertTrue(service.verifyBrackets("(test)"));
        Assertions.assertTrue(service.verifyBrackets("(())()"));
        Assertions.assertTrue(service.verifyBrackets("()test()"));
        Assertions.assertTrue(service.verifyBrackets("((test))"));
        Assertions.assertTrue(service.verifyBrackets("()"));

        Assertions.assertFalse(service.verifyBrackets("(()"));
        Assertions.assertFalse(service.verifyBrackets(")("));
        Assertions.assertFalse(service.verifyBrackets(")test)"));
        Assertions.assertFalse(service.verifyBrackets("("));
        Assertions.assertFalse(service.verifyBrackets("())"));
    }
}
