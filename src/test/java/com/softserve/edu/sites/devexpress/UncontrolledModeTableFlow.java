package com.softserve.edu.sites.devexpress;

import com.softserve.edu.browsersDrivers.ChromeDriverUtilitiesImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UncontrolledModeTableFlow {
    public ChromeDriverUtilitiesImp driverUtilities;

    public UncontrolledModeTableFlow(ChromeDriverUtilitiesImp driver) {
        this.driverUtilities = driver;
    }

    public void closePopUp(String popUp) {
        WebElement popUpButton = this.driverUtilities.findByXpath(popUp);
        popUpButton.click();
    }

    public void switchToIframe(String iframeXpath) {
        WebElement iframe = this.driverUtilities.findByXpath(iframeXpath);
        this.driverUtilities.switchToIframe(iframe);
    }

    public List<WebElement> returnAllRows(String rowsPath) {
        return this.driverUtilities.findAllByXpath(rowsPath);
    }

    public void setValueToInput(String filterPath, String filterValue) {
        WebElement filterParameter = this.driverUtilities.findByXpath(filterPath);
        filterParameter.click();
        filterParameter.sendKeys(filterValue);
    }

    public List<String> getTextByColumnForRows(List<WebElement> allRows, String column) {
        List<String> foundValues = new ArrayList<>();

        for (WebElement current : allRows) {
            WebElement columnElement = current.findElement(By.xpath(column));
            foundValues.add(columnElement.getText());
        }

        return foundValues;
    }
}
