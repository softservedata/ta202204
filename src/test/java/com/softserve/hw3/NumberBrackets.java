package com.softserve.hw3;

import com.softserve.hw1.Brackets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NumberBrackets {
    @Test
    public void testM() {
        Brackets service = Mockito.mock(Brackets.class);
        Mockito.when(service.verifyBrackets(Mockito.anyString())).thenReturn(true);

        Assertions.assertEquals(4,service.numberBrackets("()()"));
    }
}