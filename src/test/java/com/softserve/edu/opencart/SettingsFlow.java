package com.softserve.edu.opencart;

import com.softserve.edu.utilities.ChromeDriverUtilities;
import org.openqa.selenium.WebElement;

public class SettingsFlow {
    public ChromeDriverUtilities driverUtilities;

    public SettingsFlow(ChromeDriverUtilities driver) {
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
