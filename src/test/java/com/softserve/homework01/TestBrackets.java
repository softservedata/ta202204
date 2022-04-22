package com.softserve.homework01;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrackets {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@Test
	public void testMethod() {
		CheckBrackets message = new CheckBrackets();
		boolean actual = true;
		boolean expected = true;
		actual = message.verifyBrackets("()()((()))");
		System.out.println("\tResult of verifying brackets is: " + actual);
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
}
