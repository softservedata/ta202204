package com.softserve.edu.sites.opencart;

import com.softserve.edu.browsersDrivers.ChromeDriverUtilitiesImp;
import org.openqa.selenium.WebElement;

public class SettingsFlow {
    public ChromeDriverUtilitiesImp driverUtilities;

    public SettingsFlow(ChromeDriverUtilitiesImp driver) {
        this.driverUtilities = driver;
    }

    public void setCurrency(String currencyName) {
        WebElement dropDownButton = this.driverUtilities.findByXpath(
            "//button[@class='btn btn-link dropdown-toggle']"
        );
        dropDownButton.click();

        WebElement currency = this.driverUtilities.findByXpath("//button[@name='" + currencyName + "']");
        currency.click();
    }
}
