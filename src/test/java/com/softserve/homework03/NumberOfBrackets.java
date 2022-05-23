package com.softserve.homework03;

import com.softserve.homework01.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mockito;

public class NumberOfBrackets {
    @Test
    public void test() {
        App service = Mockito.spy(App.class);
        Mockito.when(service.verifyBrackets(anyString())).thenReturn(true);
        Mockito.doCallRealMethod().when(service).numberBrackets(anyString());

        Assertions.assertEquals(2,service.numberBrackets("()"));
        Assertions.assertEquals(4,service.numberBrackets("(())"));
        Assertions.assertEquals(6,service.numberBrackets("(())()"));
        Assertions.assertEquals(3,service.numberBrackets("(()"));
        Assertions.assertEquals(2,service.numberBrackets(")("));
        Assertions.assertEquals(3,service.numberBrackets("())"));
    }
}