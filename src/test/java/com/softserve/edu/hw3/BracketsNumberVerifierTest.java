package com.softserve.edu.hw3;

import com.softserve.edu.hw2.BracketsFactory;
import com.softserve.edu.hw2.StringVerifier;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BracketsNumberVerifierTest {
	
	@Test
	public void checkNumberOfBrackets() {
		BracketsFactory mockedStringVerifier = Mockito.mock(BracketsFactory.class);
		Mockito.when(mockedStringVerifier.verifyBrackets("()()")).thenReturn(true);
		StringVerifier stringVerifier = new StringVerifier(mockedStringVerifier);
		int actual;
		int expected;
		expected = 4;
		actual = stringVerifier.numberBrackets("()()");
		Assert.assertEquals(actual, expected);
	}
}
