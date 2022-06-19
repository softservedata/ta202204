package com.softserve.edu.data;

public enum Currencies {
    DEFAULT_CURRENCY("US Dollar"),
    EURO("Euro"),
    POUND_STERLING("Pound Sterling"),
    US_DOLLAR("US Dollar");
    //
    private String name;

    public static final String GBP = "\u00A3";
    public static final String EUR = "\u20AC";

    private Currencies(String name) {
        this.name = name;
    }

/*    public String getCurrencySymbol(String currencyName){
        System.out.println(Currency.getAvailableCurrencies());
        Currency currencyInstance = Currency.getInstance(currencyName);
        String currencySymbol = currencyInstance.getSymbol();
        return currencySymbol;
    }*/

    @Override
    public String toString() {
        return name;
    }
}
