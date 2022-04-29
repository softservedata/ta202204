package com.softserve.edu;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Pass the method parameters provided by the @ValueSource annotation")
public class UserJUnitTest {

    static Stream<Arguments> userDataProvider() {
        return Stream.of(
                Arguments.arguments(new Integer(1), "my1"),
                Arguments.arguments(new Integer(3), "firstName3")
        );
    }

    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest
    @MethodSource("userDataProvider")
    public void checkUser(Integer value, String ExpectedFirstname) {
        System.out.println("\tvalue = " + value + "  ExpectedFirstname = " + ExpectedFirstname);
        //Assertions.assertEquals("firstName3", ExpectedFirstname);
    }
}
