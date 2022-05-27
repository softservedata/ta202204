package com.softserve.edu.homework12.data;

import com.softserve.edu.homework12.data.Currencies;

public final class ProductRepository {

	private ProductRepository() {
	}

	public static Product getDefault() {
		return getMacBook();
	}

	public static Product getMacBook() {
		return new Product("MacBook",
				"Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..", "500.00")
						.addPrice(com.softserve.edu.homework12.data.Currencies.EURO, "472.33")
						.addPrice(com.softserve.edu.homework12.data.Currencies.POUND_STERLING, "368.73")
						.addPrice(com.softserve.edu.homework12.data.Currencies.US_DOLLAR, "602.00");
	}

	public static Product getIPhone3() {
		return new Product("iPhone 3",
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..", "101.00")
						.addPrice(com.softserve.edu.homework12.data.Currencies.EURO, "96.66")
						.addPrice(com.softserve.edu.homework12.data.Currencies.POUND_STERLING, "75.46")
						.addPrice(Currencies.US_DOLLAR, "123.20");
	}

	public static Product getInvalid() {
		return new Product("Box", "Intel", "100");
	}

}
