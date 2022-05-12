package com.softserve.edu.homework04;

import com.softserve.edu.homework01.VerifyBrackets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyString;

public class CountBracketsTest {

       @ParameterizedTest
       @CsvFileSource(resources = "/testCountBracketsData.csv")
        void testCheckNumber(String text, int number) {

           VerifyBrackets VerifyBracketsMock = Mockito.spy(new VerifyBrackets());
           Mockito.when(VerifyBracketsMock.isCorrectBrackets(anyString())).thenReturn(true);
           Mockito.doCallRealMethod().when(VerifyBracketsMock).countBrackets(anyString());

                Assertions.assertEquals(number, VerifyBracketsMock.countBrackets(text));
                Assertions.assertEquals(number, VerifyBracketsMock.countBrackets(text));
                Assertions.assertEquals(number, VerifyBracketsMock.countBrackets(text));
        }
        @ParameterizedTest
        @CsvFileSource(resources = "/testExceptionThrown.csv")
    void testExceptionThrown(String text){
            VerifyBrackets checkCountBrackets = new VerifyBrackets();

            RuntimeException thrown = Assertions.assertThrows(
                    RuntimeException.class,
                    () -> {
                        checkCountBrackets.countBrackets(text);
                    },"Incorrect brackets format!");
        }

}
