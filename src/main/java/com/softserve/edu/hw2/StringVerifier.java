package com.softserve.edu.hw2;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class StringVerifier implements BracketsFactory {

	private int counterOpenBrackets = 0;
	private int counterClosedBrackets = 0;
	private BracketsFactory bracketsFactory;

	public StringVerifier(BracketsFactory bracketsFactory) {
		this.bracketsFactory = bracketsFactory;
	}
	
	public StringVerifier() {
	
	}

	@Override
	public boolean verifyBrackets(String text) {
		
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

	@Override
	public int numberBrackets(String text) {
		if (verifyBrackets(text)) {
			return counterClosedBrackets + counterOpenBrackets;
		} else {
			throw new RuntimeException();
		}
	}
}
