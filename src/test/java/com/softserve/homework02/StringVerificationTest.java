package com.softserve.homework02;

import com.softserve.homework01.StringVerification;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class StringVerificationTest {
    @Test
    public void testServiceCanVerifyBrackets() {
        StringVerification service = new StringVerification();

        Assertions.assertTrue(service.verifybrackets("(test)"));
        Assertions.assertTrue(service.verifybrackets("(())()"));
        Assertions.assertTrue(service.verifybrackets("()test()"));
        Assertions.assertTrue(service.verifybrackets("((test))"));
        Assertions.assertTrue(service.verifybrackets("()"));

        Assertions.assertFalse(service.verifybrackets("(()"));
        Assertions.assertFalse(service.verifybrackets(")("));
        Assertions.assertFalse(service.verifybrackets(")test)"));
        Assertions.assertFalse(service.verifybrackets("("));
        Assertions.assertFalse(service.verifybrackets("())"));
    }
}
