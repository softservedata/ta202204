package com.softserve.edu.hw2;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringVerifierTest {
	
	StringVerifier stringVerifier = new StringVerifier();
	
	@Test
	public void checkBrackets() {
		boolean success = true;
		String text = "()()";
		boolean val = stringVerifier.verifyBrackets(text);
		assertEquals(success, val);
	}

}
