package com.softserve.homework02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.softserve.homework01.CheckBrackets;

class TestBracketsJU {

	@Test
	void testMethod() {
		CheckBrackets message = new CheckBrackets();
		boolean actual = true;
		boolean expected = true;
		actual = message.verifyBrackets("()()((()))");
		System.out.println("Result of verifying brackets is: " + actual);
		Assertions.assertEquals(actual, expected);
	}

}
