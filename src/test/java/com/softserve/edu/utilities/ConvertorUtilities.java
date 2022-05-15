package com.softserve.edu.utilities;

public class ConvertorUtilities {
    public static double convertStringToPrice(String price) {
        String formattedPrice = price.replace("$", "").replace(",", "");
        return Double.parseDouble(formattedPrice);
    }
}
