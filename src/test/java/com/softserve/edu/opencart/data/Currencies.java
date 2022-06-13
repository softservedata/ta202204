package com.softserve.edu.opencart.data;


public enum Currencies {
	DEFAULT_CURRENCY("US Dollar", "h"),
	EURO("Euro", "€"),
	POUND_STERLING("Pound Sterling", "3"),
	US_DOLLAR("US Dollar", "u");
	//
	private String name;
	private String expectedResult;

	Currencies(String name, String expectedResult) {
		this.name = name;
		this.expectedResult = expectedResult;
	}
	
	//private Currencies(String expectedResult) {this.expectedResult = expectedResult; }

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
	
	public int getExpectedResult() {
		return expectedResult.charAt(0);
	}
	
}
