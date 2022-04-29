package com.softserve.homework01;

public class CheckBrackets implements ICheckBrackets
{
	public boolean verifyBrackets(String text) {
		int opened = 0;
		int closed = 0;
		if(text.isEmpty())
			return false;
		String[] stext = null;
		stext = text.split("");
		for(int i = 0; i < stext.length; i++) {
			if(stext[0].equals(")"))
				return false;
			else if(stext[i].equals("("))
				opened++;
			else if(stext[i].equals(")"))
				closed++;
		}
		if(opened != closed)
			return false;
		else
			return true;
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
