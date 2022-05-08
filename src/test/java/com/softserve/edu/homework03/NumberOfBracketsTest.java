package com.softserve.edu.homework03;

import com.softserve.edu.homework01.VerifyBrackets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class NumberOfBracketsTest {


    @Test
    public void testCountBrackets() {
        VerifyBrackets VerifyBracketsMock = Mockito.spy(new VerifyBrackets());
        Mockito.when(VerifyBracketsMock.isCorrectBrackets(anyString())).thenReturn(true);
        Mockito.doCallRealMethod().when(VerifyBracketsMock).countBrackets(anyString());

        Assert.assertEquals(6, VerifyBracketsMock.countBrackets("(((str)))"));
        Assert.assertEquals(1, VerifyBracketsMock.countBrackets("( String"));
        Assert.assertEquals(8, VerifyBracketsMock.countBrackets("(((str)))()"));
    }

}
