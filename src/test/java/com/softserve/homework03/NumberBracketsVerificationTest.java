package com.softserve.homework03;

import com.softserve.homework01.StringVerification;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

public class NumberBracketsVerificationTest {
    @Test
    public void testServiceCanCountBrackets() {
       StringVerification service = Mockito.spy(StringVerification.class);
        Mockito.when(service.verifybrackets(ArgumentMatchers.anyString())).thenReturn(true);
        Mockito.doCallRealMethod().when(service).numberbrackets(ArgumentMatchers.anyString());

        Assertions.assertEquals(2, service.numberbrackets("(test)"));
        Assertions.assertEquals(6, service.numberbrackets("(())()"));
        Assertions.assertEquals(3, service.numberbrackets("(()"));
        Assertions.assertEquals(2, service.numberbrackets(")("));
    }
}
