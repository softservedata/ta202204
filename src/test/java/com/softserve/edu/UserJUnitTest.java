package com.softserve.edu;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UserJUnitTest {

    static Stream<Arguments> userDataProvider() {
        return Stream.of(
                Arguments.arguments(new Integer(1), "my1"),
                Arguments.arguments(new Integer(3), "firstName3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("userDataProvider")
    public void checkUser(Integer value, String ExpectedFirstname) {
        System.out.println("\tvalue = " + value + "  ExpectedFirstname = " + ExpectedFirstname);
        //Assertions.assertEquals("firstName3", ExpectedFirstname);
    }
}
