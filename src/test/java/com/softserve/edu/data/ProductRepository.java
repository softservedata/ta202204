package com.softserve.edu.data;

public final class ProductRepository {

	private ProductRepository() {
	}

	public static Product getDefault() {
		return getMacBook();
	}

	public static Product getMacBook() {
		return new Product("MacBook",
				"Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..", "500.00")
						.addPrice(Currencies.EURO, "472.33")
						.addPrice(Currencies.POUND_STERLING, "368.73")
						.addPrice(Currencies.US_DOLLAR, "602.00");
	}

	public static Product getIPhone3() {
		return new Product("iPhone 3",
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..", "101.00")
						.addPrice(Currencies.EURO, "96.66")
						.addPrice(Currencies.POUND_STERLING, "75.46")
						.addPrice(Currencies.US_DOLLAR, "123.20");
	}

	public static Product getCanon() {
		return new Product("Canon EOS 5D",
				"Canon's press material for the EOS 5D states that it 'defines (a) new D-SLR category', while we'r..",
				"80.00")
				.addPrice(Currencies.EURO, "76.89")
				.addPrice(Currencies.POUND_STERLING, "60.03")
				.addPrice(Currencies.US_DOLLAR, "98.00");
	}

	public static Product getInvalid() {
		return new Product("Box", "Intel", "100");
	}

}
