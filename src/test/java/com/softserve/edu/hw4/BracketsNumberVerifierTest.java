package com.softserve.edu.hw4;

import com.softserve.edu.hw2.StringVerifier;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class BracketsNumberVerifierTest {

	StringVerifier stringVerifier = new StringVerifier();
	
	@Test
	public void checkBracketsFromFile() {
		File file = new File("src/test/java/com/softserve/edu/hw4/brackets.txt");
		String text = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			text = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int actual = stringVerifier.numberBrackets(text);
		int expected = 12;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void checkRuntimeException() {
		Assert.assertThrows(RuntimeException.class, () -> stringVerifier.numberBrackets("(())("));
	}
	
}
