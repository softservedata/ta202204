package com.softserve.homework03;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserve.homework01.Brackets;
import com.softserve.homework01.CheckBrackets;


@PrepareForTest(Brackets.class)
public class UnitTest extends PowerMockTestCase {
	private CheckBrackets check;
	private String text;
	
//	@ObjectFactory
//	public ITestObjectFactory setObjectFactory() {
//		return new PowerMockObjectFactory();
//	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		text = "()()()(())";
	}

	@Test
	public void testMethod() {
		check = PowerMockito.mock(CheckBrackets.class);
		PowerMockito.when(check.verifyBrackets(Mockito.anyString())).thenReturn(true);
		Brackets bracket = new Brackets(check);
		int actual, expected = 10;
		actual = bracket.getNumberBrackets(text);
		System.out.println("\tString contains " + actual + " brackets in total");
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
}
