package com.softserve.homework03;

import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserve.homework01.CheckBrackets;

public class TestBracketsNumber {
	private CheckBrackets message, check;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		message = new CheckBrackets();
	}

	@Test
	public void testMethod() {
		check = PowerMockito.mock(CheckBrackets.class);
		PowerMockito.when(check.verifyBrackets("()()()(())")).thenReturn(true);
		int actual = 0, expected = 10;
		actual = message.numberBrackets("()()()(())");
		System.out.println("\tString contains " + actual + " brackets in total");
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
}
