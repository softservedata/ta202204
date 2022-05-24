package com.softserve.homework04;

import com.softserve.homework01.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

public class NumberOfBracketsRuntimeError {
    @DisplayName("Test data taken from csv file")
    @ParameterizedTest()
    @CsvFileSource(resources = "/test_data.csv")
    void checkBrackets(String actual, int expected){
        App service = Mockito.spy(App.class);
        Mockito.when(service.verifyBrackets(anyString())).thenReturn(true);
        Mockito.doCallRealMethod().when(service).numberBrackets(anyString());

        Assertions.assertEquals(expected,service.numberBrackets(actual));
        Assertions.assertEquals(expected,service.numberBrackets(actual));
        Assertions.assertEquals(expected,service.numberBrackets(actual));
        Assertions.assertEquals(expected,service.numberBrackets(actual));
        Assertions.assertEquals(expected,service.numberBrackets(actual));
        Assertions.assertEquals(expected,service.numberBrackets(actual));
    }

    @DisplayName("Test RuntimeException")
    @Test
    public void testRuntimeException() {
        App service = new App();
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            service.numberBrackets("()()(()");
            },"Expected exception");
    }
}