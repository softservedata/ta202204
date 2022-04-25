package com.softserve.edu.hw2;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class StringVerifier {
	
	public boolean verifyBrackets(String text) {
		
		int counterOpenBrackets = 0;
		int counterClosedBrackets = 0;
		CharacterIterator charIterator = new StringCharacterIterator(text);
		while (charIterator.current() != CharacterIterator.DONE) {
			if (charIterator.current() == '(') {
				counterOpenBrackets = counterOpenBrackets + 1;
				while (charIterator.next() == ')') {
					counterClosedBrackets = counterClosedBrackets + 1;
				}
			} else {
				System.out.println("Not Ok!");
				return false;
			}
		}
		if (counterOpenBrackets == counterClosedBrackets) {
			System.out.println("Ok!");
			return true;
		} else {
			System.out.println("Not Ok!");
			return false;
		}
	}
}
