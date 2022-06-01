package com.softserve.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="browsers")
	public Object[][] getData(){
		return new Object[][] {
			{"chrome"}, {"firefox"},
			{"edge"}
		};
	}

}
