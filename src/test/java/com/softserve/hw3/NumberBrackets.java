package com.softserve.hw3;

import com.softserve.hw1.Brackets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class NumberBrackets {
    @Test
    public void testM() {
        Brackets service = Mockito.spy(Brackets.class);
        Mockito.when(service.verifyBrackets(Mockito.anyString())).thenReturn(true);
        Mockito.doCallRealMethod().when(service).numberBrackets(ArgumentMatchers.anyString());

        Assertions.assertEquals(4,service.numberBrackets("()()"));
        Assertions.assertEquals(2,service.numberBrackets(")("));
        Assertions.assertEquals(3,service.numberBrackets("(()"));
        Assertions.assertEquals(6,service.numberBrackets("(())()"));
    }
}