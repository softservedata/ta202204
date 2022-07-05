package com.softserve.edu.opencart.pages.guest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.data.user.IUser;
import com.softserve.edu.opencart.pages.logged.SuccessfulRegistrationPage;
import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class RegisterPage extends AccountSidebarGuestPart {

	protected Search search;
	
	private WebElement firstname;
    private WebElement lastname;
    private WebElement email;
    private WebElement telephone;
    private WebElement fax;      // not required
    private WebElement company;  // not required
    private WebElement address1;
    private WebElement address2; // not required
    private WebElement city;
    private WebElement postcode;
    private WebElement country;
    private WebElement region;
    private WebElement password;
    private WebElement confirmpassword;
    private WebElement subscribe;
    private WebElement privacypolicy;
	private WebElement continueButton;
	
	private Select s;
	
    // public RegisterPage(WebDriver driver) {
	public RegisterPage() {
        // super(driver);
		search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
//    	  firstname = driver.findElement(By.id("input-firstname"));
//        lastname = driver.findElement(By.id("input-lastname"));
//        email = driver.findElement(By.id("input-email"));
//        telephone = driver.findElement(By.id("input-telephone"));
//        fax = driver.findElement(By.id("input-fax"));     // not required
//        company = driver.findElement(By.id("input-company")); // not required
//        address1 = driver.findElement(By.id("input-address-1"));
//        address2 = driver.findElement(By.id("input-address-2")); // not required
//        city = driver.findElement(By.id("input-city"));
//        postcode = driver.findElement(By.id("input-postcode"));
//        country = driver.findElement(By.id("input-country"));
//        region = driver.findElement(By.id("input-zone"));
//        password = driver.findElement(By.id("input-password"));
//        confirmpassword = driver.findElement(By.id("input-confirm"));
//        subscribe = driver.findElement(By.cssSelector("input[name='newsletter'][value='1']"));
//        privacypolicy = driver.findElement(By.name("agree"));
//    	  continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
    	firstname = search.id("input-firstname");
        lastname = search.id("input-lastname");
        email = search.id("input-email");
        telephone = search.id("input-telephone");
        fax = search.id("input-fax");     // not required
        company = search.id("input-company"); // not required
        address1 = search.id("input-address-1");
        address2 = search.id("input-address-2"); // not required
        city = search.id("input-city");
        postcode = search.id("input-postcode");
        country = search.id("input-country");
        region = search.id("input-zone");
        password = search.id("input-password");
        confirmpassword = search.id("input-confirm");
        subscribe = search.cssSelector("input[name='newsletter'][value='1']");
        privacypolicy = search.name("agree");
    	continueButton = search.cssSelector(".btn.btn-primary");
    }

    // Page Object
    
    // firstname
    private WebElement getFirstname() {
        return firstname;
    }

    protected String getFirstnameText() {
        return getFirstname().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearFirstnameField() {
    	getFirstname().clear();
    }

    private void clickFirstnameField() {
    	getFirstname().click();
    }

    private void setFirstname(String firstname) {
    	getFirstname().sendKeys(firstname);
    }
    
    // lastname
    private WebElement getLastname() {
        return lastname;
    }

    protected String getLastnameText() {
        return getLastname().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearLastnameField() {
    	getLastname().clear();
    }

    private void clickLastnameField() {
    	getLastname().click();
    }

    private void setLastname(String lastname) {
    	getLastname().sendKeys(lastname);
    }
    
    // email
    private WebElement getEmail() {
        return email;
    }

    protected String getEmailText() {
        return getEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearEmailField() {
        getEmail().clear();
    }

    private void clickEmailField() {
        getEmail().click();
    }

    private void setEmail(String email) {
        getEmail().sendKeys(email);
    }
    
    // telephone
    private WebElement getTelephone() {
        return telephone;
    }

    protected String getTelephoneText() {
        return getTelephone().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearTelephoneField() {
    	getTelephone().clear();
    }

    private void clickTelephoneField() {
    	getTelephone().click();
    }

    private void setTelephone(String telephone) {
    	getTelephone().sendKeys(telephone);
    }
    
    // fax
    private WebElement getFax() {
        return fax;
    }

    protected String getFaxText() {
        return getFax().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearFaxField() {
    	getFax().clear();
    }

    private void clickFaxField() {
    	getFax().click();
    }

    private void setFax(String fax) {
    	getFax().sendKeys(fax);
    }
    
    // company
    private WebElement getCompany() {
        return company;
    }

    protected String getCompanyText() {
        return getCompany().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearCompanyField() {
    	getCompany().clear();
    }

    private void clickCompanyField() {
    	getCompany().click();
    }

    private void setCompany(String company) {
    	getCompany().sendKeys(company);
    }
    
    // address1
    private WebElement getAddress1() {
        return address1;
    }

    protected String getAddress1Text() {
        return getAddress1().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearAddress1Field() {
    	getAddress1().clear();
    }

    private void clickAddress1Field() {
    	getAddress1().click();
    }

    private void setAddress1(String address1) {
    	getAddress1().sendKeys(address1);
    }
    
    // address2
    private WebElement getAddress2() {
        return address2;
    }

    protected String getAddress2Text() {
        return getAddress2().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearAddress2Field() {
    	getAddress2().clear();
    }

    private void clickAddress2Field() {
    	getAddress2().click();
    }

    private void setAddress2(String address2) {
    	getAddress2().sendKeys(address2);
    }
    
    // city
    private WebElement getCity() {
        return city;
    }

    protected String getCityText() {
        return getCity().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearCityField() {
    	getCity().clear();
    }

    private void clickCityField() {
    	getCity().click();
    }

    private void setCity(String city) {
    	getCity().sendKeys(city);
    }
    
    // postcode
    private WebElement getPostcode() {
        return postcode;
    }

    protected String getPostcodeText() {
        return getPostcode().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearPostcodeField() {
    	getPostcode().clear();
    }

    private void clickPostcodeField() {
    	getPostcode().click();
    }

    private void setPostcode(String postcode) {
    	getPostcode().sendKeys(postcode);
    }
    
    // country
    private WebElement getCountry() {
        return country;
    }

    protected String getCountryText() {
        return getCountry().getText();
    }

    private void clickCountryField() {
    	getCountry().click();
    }

    private void setCountry(String countryname) {
    	s = new Select(country);
    	s.selectByVisibleText(countryname);
    }
    
    // region
    private WebElement getRegion() {
        return region;
    }

    protected String getRegionText() {
        return getRegion().getText();
    }

    private void clickRegionField() {
    	getRegion().click();
    }

    private void setRegion(String regionname) {
    	s = new Select(region);
    	s.selectByVisibleText(regionname);
    }
    
    // password
    private WebElement getPassword() {
        return password;
    }

    protected String getPasswordText() {
        return getPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearPasswordField() {
    	getPassword().clear();
    }

    private void clickPasswordField() {
    	getPassword().click();
    }

    private void setPassword(String password) {
    	getPassword().sendKeys(password);
    }
    
    // confirmpassword
    private WebElement getConfirmpassword() {
        return confirmpassword;
    }

    protected String getConfirmpasswordText() {
        return getConfirmpassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    private void clearConfirmpasswordField() {
    	getConfirmpassword().clear();
    }

    private void clickConfirmpasswordField() {
    	getConfirmpassword().click();
    }

    private void setConfirmpassword(String confirmpassword) {
    	getConfirmpassword().sendKeys(confirmpassword);
    }
    
    // subscribe
    private WebElement getSubscribe() {
        return subscribe;
    }

    private void setSubscribe(boolean subscribe) {
    	if(subscribe)
    		getSubscribe().click();
    }
    
    // privacypolicy
    private WebElement getPrivacypolicy() {
        return privacypolicy;
    }

    private void setPrivacypolicy(boolean privacypolicy) {
    	if(privacypolicy)
    		getPrivacypolicy().click();
    }
    
    // continue button
    private WebElement getContinueButton() {
    	return continueButton;
    }
    
    private void clickContinueButton() {
    	getContinueButton().click();
    }

    // Functional
    
    private void enterFirstname(String firstname) {
    	clickFirstnameField();
    	clearFirstnameField();
    	setFirstname(firstname);
    }
    
    private void enterLastname(String lastname) {
    	clickLastnameField();
    	clearLastnameField();
    	setLastname(lastname);
    }
    
    private void enterEmail(String email) {
    	clickEmailField();
    	clearEmailField();
    	setEmail(email);
    }
    
    private void enterTelephone(String telephone) {
    	clickTelephoneField();
    	clearTelephoneField();
    	setTelephone(telephone);
    }
    
    private void enterFax(String fax) {
    	clickFaxField();
    	clearFaxField();
    	setFax(fax);
    }
    
    private void enterCompany(String company) {
    	clickCompanyField();
    	clearCompanyField();
    	setCompany(company);
    }
    
    private void enterAddress1(String address1) {
    	clickAddress1Field();
    	clearAddress1Field();
    	setAddress1(address1);
    }
    
    private void enterAddress2(String address2) {
    	clickAddress2Field();
    	clearAddress2Field();
    	setAddress2(address2);
    }
    
    private void enterCity(String city) {
    	clickCityField();
    	clearCityField();
    	setCity(city);
    }
    
    private void enterPostcode(String postcode) {
    	clickPostcodeField();
    	clearPostcodeField();
    	setPostcode(postcode);
    }
    
    private void enterCountry(String country) {
    	clickCountryField();
    	setCountry(country);
    }
    
    private void enterRegion(String region) {
    	clickRegionField();
    	setRegion(region);
    }
    
    private void enterPassword(String password) {
    	clickPasswordField();
    	clearPasswordField();
    	setPassword(password);
    }
    
    private void enterConfirmpassword(String confirmpassword) {
    	clickConfirmpasswordField();
    	clearConfirmpasswordField();
    	setConfirmpassword(confirmpassword);
    }
    
    private void fillRegister(IUser user) {
    	enterFirstname(user.getFirstname());
    	enterLastname(user.getLastname());
    	enterEmail(user.getEmail());
    	enterTelephone(user.getTelephone());
    	enterFax(user.getFax());
    	enterCompany(user.getCompany());
    	enterAddress1(user.getAddress1());
    	enterAddress2(user.getAddress2());
    	enterCity(user.getCity());
    	enterPostcode(user.getPostcode());
    	enterCountry(user.getCountry());
    	enterRegion(user.getRegion());
    	enterPassword(user.getPassword());
    	enterConfirmpassword(user.getConfirmPassword());
    	setSubscribe(user.isSubscribe());
    	setPrivacypolicy(user.agreePrivacypolicy());
    	clickContinueButton();
    }

    // Business Logic
    
    public SuccessfulRegistrationPage successfulRegister(IUser newValidUser) {
    	fillRegister(newValidUser);
    	// return new SuccessfulRegistrationPage(driver);
    	return new SuccessfulRegistrationPage();
    }
    
	public UnsuccessfulRegisterPage unsuccessfulRegisterPage(IUser invalidUser) {
		// public UnsuccessfulLoginPage unsuccessfulLoginPage(String email, String
		// password) {
		fillRegister(invalidUser);
		// fillLogin(email, password);
		// return new UnsuccessfulRegisterPage(driver);
		return new UnsuccessfulRegisterPage();
	}

}
