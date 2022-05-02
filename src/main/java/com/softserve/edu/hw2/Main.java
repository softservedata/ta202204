package com.softserve.edu.hw2;

public class Main {

	public static void main( String[] args) {
		
		String text = "()(())";
		StringVerifier stringVerifier = new StringVerifier();
		System.out.println(stringVerifier.numberBrackets(text));
		
	}
	
}
