package com.softserve.edu.homework04;

import com.softserve.edu.homework01.VerifyBrackets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountBracketsTest {

       @DisplayName("Should check the number of brackets")
       @ParameterizedTest(name = "{index} => text={0}, number={1}")
        @CsvFileSource(resources = "/testCountBracketsData.csv")
        void testCheckNumber(String text, int number) {

                VerifyBrackets mockVerifyBrackets = mock(VerifyBrackets.class);
                when(mockVerifyBrackets.isCorrectBrackets(anyString())).thenReturn(true);
                when(mockVerifyBrackets.countBrackets(anyString())).thenCallRealMethod();

                Assertions.assertEquals(number, mockVerifyBrackets.countBrackets(text));
                Assertions.assertEquals(number, mockVerifyBrackets.countBrackets(text));
                Assertions.assertEquals(number, mockVerifyBrackets.countBrackets(text));
        }
}
