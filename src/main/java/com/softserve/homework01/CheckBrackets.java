package com.softserve.homework01;

public class CheckBrackets implements ICheckBrackets
{
	public boolean verifyBrackets(String text) {
		int brackets = 0;
		if(text.isEmpty())
			return false;
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == '(')
				brackets++;
			else if(text.charAt(i) == ')') {
				brackets--;
				if(brackets == -1)
					break;
			}
		}
		if(brackets == 0)
			return true;
		else
			return false;
	}
	
	public int numberBrackets(String text) {
		int count = 0;
		boolean brackets = verifyBrackets(text);
		if(!brackets) {
			throw new RuntimeException("Brackets are incorrect");
		}
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == '(' || text.charAt(i) == ')')
				count++;
		}
		return count;
	}
	
}
