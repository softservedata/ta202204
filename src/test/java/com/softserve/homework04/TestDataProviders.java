package com.softserve.homework04;

import com.softserve.utilities.ExcelUtility;

import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.homework01.CheckBrackets;

public class TestDataProviders {
	private CheckBrackets message, check;

	@BeforeClass
	public void beforeClass() throws Exception {
		System.out.println("Before Class");
		message = new CheckBrackets();
		
		//Location of Excel file with test data
		ExcelUtility.setExcelFile("resources\\test-data.xlsx", "BracketsNumber");
	}
	
	@DataProvider(name="even-brackets")
	public Object[][] eBracketsProvider(){
		Object[][] testData = ExcelUtility.getTestData("EvenTestData");
		return testData;
	}
	
	@DataProvider(name="odd-brackets")
	public Object[][] oBracketsProvider(){
		Object[][] testData = ExcelUtility.getTestData("OddTestData");
		return testData;
	}

	@Test
	public void unitTest() {
		System.out.println("\n\tNumberBrackets Unit Test");
		check = PowerMockito.mock(CheckBrackets.class);
		PowerMockito.when(check.verifyBrackets("()()()(())")).thenReturn(true);
		int actual = 0, expected = 10;
		actual = message.numberBrackets("()()()(())");
		System.out.println("\tString contains " + actual + " brackets in total");
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expectedExceptions = RuntimeException.class)
	public void testEExceptions() {
		System.out.println("\tWait for RuntimeException");
		check = PowerMockito.mock(CheckBrackets.class);
		PowerMockito.when(check.verifyBrackets("()()()(())")).thenReturn(true);
		int actual = 0, expected = 10;
		actual = message.numberBrackets("()()(()(())");
		System.out.println("\tString contains " + actual + " brackets in total");
		Assert.assertEquals(actual, expected);
	}
	
	@Test(dataProvider="even-brackets")
	public void testEFileData(String text, String expected) {
		check = PowerMockito.mock(CheckBrackets.class);
		PowerMockito.when(check.verifyBrackets("()()()(())")).thenReturn(true);
		int actual = 0;
		actual = message.numberBrackets(text);
		System.out.println("\tString contains " + actual + " brackets in total");
		Assert.assertEquals(actual, Integer.parseInt(expected));
	}
	
	@Test(dataProvider="odd-brackets", expectedExceptions = RuntimeException.class)
	public void testOFileData(String text, String expected) {
		System.out.println("\tTest odd number of brackets from Excel file");
		check = PowerMockito.mock(CheckBrackets.class);
		PowerMockito.when(check.verifyBrackets("()()()(())")).thenReturn(true);
		int actual = 0;
		actual = message.numberBrackets(text);
		System.out.println("\tString contains " + actual + " brackets in total");
		Assert.assertEquals(actual, Integer.parseInt(expected));
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

}
