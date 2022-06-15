package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {
    
	protected Search search;
	//
    public static final String EXPECTED_IPHONE6 = "iPhone6";
    public static final String EXPECTED_IPHONE_6 = "iPhone 6";
    //
    private WebElement slideshow0;
    //
    private ProductsContainer productsContainer;

    // public HomePage(WebDriver driver) {
    public HomePage() {
        // super(driver);
    	super();
    	search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
//        slideshow0 = driver.findElement(By.id("slideshow0"));
//        //
//        productsContainer = new ProductsContainer(driver);
    	slideshow0 = search.id("slideshow0");
        //
        productsContainer = new ProductsContainer();
    }

    // Page Object

    // slideshow0
    public WebElement getSlideshow0() {
        return slideshow0;
    }

    public WebElement getSlideshow0FirstImage() {
        // return getSlideshow0().findElement(By.cssSelector("a > img"));
        // return getSlideshow0().findElement(By.xpath(".//a/img"));
    	
    	return search.xpath(".//a/img", getSlideshow0());
        // return Slideshow0.findElement(By.xpath("//a/img")); // ERROR
        // return driver.findElement(By.xpath("//div[@id='slideshow0']//a/img"));
    }

    public String getSlideshow0FirstImageAttributeText(String attribute) {
        return getSlideshow0FirstImage().getAttribute(attribute).trim();
    }

    public String getSlideshow0FirstImageAttributeSrcText() {
        return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_SRC);
    }
    public String getSlideshow0FirstImageAttributeAltText() {
        return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_ALT);
    }

    // productComponentsContainer
    public ProductsContainer getProductComponentsContainer() {
        return productsContainer;
    }

    // Functional

    // Business Logic

    //public HomePage chooseCurrency(String currency) {
    public HomePage chooseCurrency(Currencies currency) {
        //logger.debug("start chooseCurrency() with currency = " + currency.toString());
        clickCurrencyByPartialName(currency);
        //logger.debug("end chooseCurrency() with currency = " + currency.toString());
        // return new HomePage(driver);
        return new HomePage();
    }

    public HomePage scrollToProduct(Product product) {
        WebElement webElement = getProductComponentsContainer()
                .getProductComponentByName(product.getName())
                .getName();
        scrollToElement(webElement);
        //return new HomePage(driver);
        //return new HomePage();
        return this;
    }
}
