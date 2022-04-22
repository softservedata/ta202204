package com.softserve.homework01;

public class CheckBrackets 
{
	public boolean verifyBrackets(String text) {
		int opened = 0;
		int closed = 0;
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
}
