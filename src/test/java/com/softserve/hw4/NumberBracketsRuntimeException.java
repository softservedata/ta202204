package com.softserve.hw4;

import com.softserve.hw1.Brackets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class NumberBracketsRuntimeException {
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void numberBracketsFromFile(
            String input, int expected) {
        Brackets service = Mockito.spy(Brackets.class);
        Mockito.when(service.verifyBrackets(Mockito.anyString())).thenReturn(true);
        Mockito.doCallRealMethod().when(service).numberBrackets(ArgumentMatchers.anyString());

        Assertions.assertEquals(expected,service.numberBrackets(input));
        Assertions.assertEquals(expected,service.numberBrackets(input));
        Assertions.assertEquals(expected,service.numberBrackets(input));
        Assertions.assertEquals(expected,service.numberBrackets(input));
    }

    @Test
    public void testRuntimeException() {
        Brackets service = new Brackets();
        Assertions.assertThrowsExactly(RuntimeException.class, () -> service.numberBrackets(")(()"), "Ups, something went WRONG!");
    }
}