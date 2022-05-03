package com.softserve.edu.homework03;

import com.softserve.edu.homework01.VerifyBrackets;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class NumberOfBracketsTest {

    @Test
    public void testCountBrackets() {

        VerifyBrackets mockVerifyBrackets = mock(VerifyBrackets.class);
        when(mockVerifyBrackets.isCorrectBrackets(anyString())).thenReturn(true);
        when(mockVerifyBrackets.countBrackets(anyString())).thenCallRealMethod();

        Assert.assertEquals(6, mockVerifyBrackets.countBrackets("(((str)))"));
        Assert.assertEquals(1, mockVerifyBrackets.countBrackets("( String"));
        Assert.assertEquals(8, mockVerifyBrackets.countBrackets("(((str)))()"));

    }

}
