package com.softserve.edu.opencart.data;

public enum Currencies {
	DEFAULT_CURRENCY("US Dollar"),
	EURO("Euro"),
	POUND_STERLING("Pound Sterling"),
	US_DOLLAR("US Dollar");
	//
	private String name;
	private final String EXPECTED_DOLLAR_SYMBOL = "\u0024";
	private final String EXPECTED_EURO_SYMBOL = "\u20AC";
	private final String EXPECTED_POUND_SYMBOL = "\u00A3";

	public String getExpectedDollarSymbol() {
		return EXPECTED_DOLLAR_SYMBOL;
	}

	public String getExpectedEuroSymbol() {
		return EXPECTED_EURO_SYMBOL;
	}

	public String getExpectedPoundSymbol() {
		return EXPECTED_POUND_SYMBOL;
	}

	private Currencies(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}