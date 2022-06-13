package com.softserve.edu.opencart.data;


public enum Currencies {
	DEFAULT_CURRENCY("US Dollar", "$"),
	EURO("Euro", "€"),
	POUND_STERLING("Pound Sterling", "£"),
	US_DOLLAR("US Dollar", "$");
	//
	private final String name;
	private final String expectedResult;

	Currencies(String name, String expectedResult) {
		this.name = name;
		this.expectedResult = expectedResult;
	}

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
