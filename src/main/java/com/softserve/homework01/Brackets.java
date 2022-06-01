package com.softserve.homework01;

public class Brackets {

	private ICheckBrackets check;

	public Brackets(ICheckBrackets check) {
		this.check = check;
	}

	public Brackets() {
		check = new CheckBrackets();
	}

	public ICheckBrackets getCheckBrackets() {
		return check;
	}

	public boolean getVerifyBrackets(String text) {
		boolean origin = getCheckBrackets().verifyBrackets(text);
		return origin;
	}

	public int getNumberBrackets(String text) {
		int origin = getCheckBrackets().numberBrackets(text);
		return origin;
	}

}
