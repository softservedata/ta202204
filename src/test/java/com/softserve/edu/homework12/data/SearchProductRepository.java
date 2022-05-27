package com.softserve.edu.homework12.data;

import com.softserve.edu.homework12.data.Currencies;

public final class SearchProductRepository {

    private SearchProductRepository() {
    }

    public static SearchProduct getDefault() {
        return getMacDollar();
    }
    
    public static SearchProduct getMacEuro() {
        return new SearchProduct("mac", "Desktops", true,
                com.softserve.edu.homework12.data.Currencies.EURO,
                ProductRepository.getMacBook());
    }
    
    public static SearchProduct getMacPoundSterling() {
        return new SearchProduct("mac", "Desktops", true,
                com.softserve.edu.homework12.data.Currencies.POUND_STERLING,
                ProductRepository.getMacBook());
    }
    
    public static SearchProduct getMacDollar() {
        return new SearchProduct("mac", "Desktops", true,
                Currencies.US_DOLLAR,
                ProductRepository.getMacBook());
    }
    
}
