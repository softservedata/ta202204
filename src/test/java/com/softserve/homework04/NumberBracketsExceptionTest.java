package com.softserve.homework04;

import com.softserve.homework01.StringVerification;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;


public class NumberBracketsExceptionTest {


    @Test
    public void testServiceCanVerifyRuntimeException() {
        StringVerification service = new StringVerification();
        Assertions.assertThrowsExactly(RuntimeException.class , () -> {
            service.numberbrackets("())");
        });
    }
}
