package com.softserve.homework01;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrackets {
	private CheckBrackets message;
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		message = new CheckBrackets();
	}

	@Test
	public void testMethod() {
		boolean actual = true, expected = true;
		actual = message.verifyBrackets("()()((()))");
		System.out.println("\tResult of verifying brackets is: " + actual);
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
}
