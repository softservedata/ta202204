package com.softserve.edu.browsersDrivers;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface DriverUtilities {
    public WebElement findByCssSelector(String conditionCss);

    public WebElement findByXpath(String conditionXpath);

    public List<WebElement> findAllByXpath(String conditionXpath);

    public WebElement findById(String condition);

    public void switchToIframe(WebElement iframe);

    public void stalenessExceptionCLick(String conditionCss);
}
